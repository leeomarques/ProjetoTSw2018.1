
package Dados.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dados.IPersistenciaCliente;
import Excecoes.ConexaoException;
import Excecoes.cpfExistenteException;
import FabricaConexao.FabricaConexao;
import FabricaConexao.IFabricaConexao;
import Negocio.ClassesBasicas.Cliente;

/**
 *
 * @author Carlos
 */
public class PersistenciaCliente implements IPersistenciaCliente {

	public IFabricaConexao f;

	public PersistenciaCliente() {
		f = FabricaConexao.getInstancia();

	}

	/**
	 * Realiza o cadastro de um Cliente
	 * 
	 * @param cli
	 *            Objeto contendo todos os dados de um cliente
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws cpfExistenteException
	 *             Este erro é tratado caso o CPF ja estiver incluso no BD
	 */

	@Override
	public void CasdastraCliente(Cliente cli) throws ConexaoException, cpfExistenteException {
		Connection c = f.conectar();

		String sql = "INSERT INTO cliente (nome, sexo, cpf, endereco, email, dataNascimento, telefone) VALUES(?,?,?,?,?,?,?)";

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cli.getNome());
			pstm.setString(2, cli.getSexo());
			pstm.setString(3, cli.getCpf());
			pstm.setString(4, cli.getEndereco());
			pstm.setString(5, cli.getEmail());
			pstm.setString(6, cli.getNasc());
			pstm.setString(7, cli.getTelefone());

			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			f.desconectar(c);
		}

	}

	/**
	 * Altera os Dados do Cliente ja cadastrado
	 * 
	 * @param cli
	 *            Objeto contendo todos os dados de um cliente
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public void AlteraCliente(Cliente cli) throws ConexaoException {
		Connection c = null;
		try {
			c = f.conectar();
			Statement st = c.createStatement();
			String sql = "UPDATE cliente SET          nome            = '" + cli.getNome()
					+ "',     sexo            = '" + cli.getSexo() + "',     cpf             = '" + cli.getCpf()
					+ "',     endereco        = '" + cli.getEndereco() + "', email           = '" + cli.getEmail()
					+ "', dataNascimento  = '" + cli.getNasc() + "', telefone        = '" + cli.getTelefone() + "'"
					+ " WHERE ID = " + cli.getID();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			f.desconectar(c);
		}

	}

	/**
	 * Deleta um cliente cadastrado do banco de dados
	 * 
	 * @param id
	 *            Identifica o cliente no registro do banco
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public void DeletaCliente(int id) throws ConexaoException {
		Connection c = f.conectar();

		String sql = "DELETE FROM cliente WHERE id=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			f.desconectar(c);
		}
	}

	/**
	 * Seleciona a partir de um ArrayList todos os dados de um cliente
	 * 
	 * @return Retorna os dados do Cliente em uma lista a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public ArrayList<Cliente> getlistaCliente() throws ConexaoException {
		Connection c = f.conectar();
		ArrayList<Cliente> lista = new ArrayList<>();

		String sql = "SELECT id, nome, sexo, cpf, endereco, email, dataNascimento, telefone  FROM cliente ORDER BY ID";
		try {

			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setID(rs.getInt("id"));
				cli.setNome(rs.getString("nome"));
				cli.setSexo(rs.getString("sexo"));
				cli.setCpf(rs.getString("cpf"));
				cli.setEndereco(rs.getString("endereco"));
				cli.setEmail(rs.getString("email"));
				cli.setNasc(rs.getString("dataNascimento"));
				cli.setTelefone(rs.getString("telefone"));
				lista.add(cli);
			}
			return lista;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			f.desconectar(c);
		}

	}

	/**
	 * Retorna todos os dados de Cliente
	 * 
	 * @param id
	 *            Identifica o Cliente a partir do seu ID
	 * @return Retorna todos os dados de Cliente a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public Cliente getCliente(int id) throws ConexaoException {
		Connection c = f.conectar();
		Cliente cli = null;

		String sql = "SELECT id, nome, sexo, cpf, endereco, email, dataNascimento, telefone FROM cliente WHERE id=?";

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				cli = new Cliente();
				cli.setID(rs.getInt("id"));
				cli.setNome(rs.getString("nome"));
				cli.setSexo(rs.getString("sexo"));
				cli.setCpf(rs.getString("cpf"));
				cli.setEndereco(rs.getString("endereco"));
				cli.setEmail(rs.getString("email"));
				cli.setNasc(rs.getString("dataNascimento"));
				cli.setTelefone(rs.getString("telefone"));

			}
			return cli;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			f.desconectar(c);
		}

	}

	/**
	 * Consulta se o CPF ja esta incluso no banco de dados a partir do CPF digitado
	 * no cadastro
	 *
	 * @param cpf
	 *            CPF do Cliente
	 * @return retorna falso caso esse cliente ja esteja cadastrado
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	@Override
	public boolean ConsultaCliente(String cpf) throws ConexaoException {
		Connection c = f.conectar();

		//Cliente cli = null;

		String sql = "SELECT * FROM cliente WHERE cpf=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cpf);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			f.desconectar(c);
		}
	}

}