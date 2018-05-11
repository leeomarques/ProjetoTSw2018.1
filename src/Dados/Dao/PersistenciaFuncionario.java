package Dados.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dados.IPersistenciaFuncionario;
import Excecoes.ConexaoException;
import FabricaConexao.FabricaConexao;
import Negocio.ClassesBasicas.Funcionario;

public class PersistenciaFuncionario implements IPersistenciaFuncionario {

	private final FabricaConexao fc;

	public PersistenciaFuncionario() {
		fc = FabricaConexao.getInstancia();
	}

	/**
	 * Inclui um funcionário no BD
	 *
	 * @param f
	 *            Objeto contendo todas as informações do Funcionário
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	@Override
	public void incluirFuncionario(Funcionario f) throws ConexaoException, SQLException {
		Connection c = fc.conectar();
		String sql = "INSERT INTO funcionario (nome, funcao, cpf, sexo, telefone, departamento, dataNascimento) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, f.getNome());
			pstm.setString(2, f.getFuncao());
			pstm.setString(3, f.getCpf());
			pstm.setString(4, f.getSexo());
			pstm.setString(5, f.getTelefone());
			pstm.setString(6, f.getDepartamento());
			pstm.setString(7, f.getDataNascimento());

			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}

	}

	/**
	 * Exclui um funcionário no BD
	 *
	 * @param id
	 *            Identificação da chave primária do registro
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	@Override
	public void excluirFuncionario(Integer id) throws ConexaoException, SQLException {
		Connection c = fc.conectar();
		String sql = "DELETE FROM funcionario WHERE id=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

	/**
	 * Altera um registro na tabela Funcionário
	 *
	 * @param f
	 *            Objeto contendo todas as informações
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	@Override
	public void alterarFuncionario(Funcionario f) throws ConexaoException, SQLException {
		Connection c = fc.conectar();
		String sql = "UPDATE funcionario SET nome=?, funcao=?, sexo=?, telefone=?, departamento=?, dataNascimento=?, cpf=? WHERE id=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, f.getNome());
			pstm.setString(2, f.getFuncao());
			pstm.setString(3, f.getSexo());
			pstm.setString(4, f.getTelefone());
			pstm.setString(5, f.getDepartamento());
			pstm.setString(6, f.getDataNascimento());
			pstm.setString(7, f.getCpf());
			pstm.setInt(8, f.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

	/**
	 * Lista todos os Funcionários
	 *
	 * @return Um ArrayList contendo todos os Funcionários
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	@Override
	public ArrayList<Funcionario> listarFuncionario() throws ConexaoException, SQLException {
		Connection c = fc.conectar();
		ArrayList<Funcionario> lista = new ArrayList<>();

		String sql = "SELECT id, nome, funcao, cpf, sexo, telefone, departamento, dataNascimento FROM funcionario";

		try {
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Funcionario f = new Funcionario();
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setFuncao(rs.getString("funcao"));
				f.setCpf(rs.getString("cpf"));
				f.setSexo(rs.getString("sexo"));
				f.setTelefone(rs.getString("telefone"));
				f.setDepartamento(rs.getString("departamento"));
				f.setDataNascimento(rs.getString("dataNascimento"));
				lista.add(f);
			}
			return lista;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

	/**
	 * Retorna o objeto com os dados da tabela
	 *
	 * @param id
	 *            Chave primária
	 * @return Retorna um funcionário a partir do seu id
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	@Override
	public Funcionario getFuncionario(Integer id) throws ConexaoException, SQLException {
		Connection c = fc.conectar();
		Funcionario f = null;

		String sql = "SELECT id, nome, funcao, cpf, sexo, telefone, departamento, dataNascimento FROM funcionario WHERE id=?";

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				f = new Funcionario();

				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setFuncao(rs.getString("funcao"));
				f.setCpf(rs.getString("cpf"));
				f.setSexo(rs.getString("sexo"));
				f.setTelefone(rs.getString("telefone"));
				f.setDepartamento(rs.getString("departamento"));
				f.setDataNascimento(rs.getString("dataNascimento"));
			}
			return f;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

	/**
	 * Faz uma busca na tabela funcionário pelo valor digitado no campo cpf
	 *
	 * @param cpf
	 *            cpf do Funcionário
	 * @return retorna um funcionario através do nome
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	@Override
	public Funcionario consultarFuncionario(String cpf) throws ConexaoException, SQLException {
		Connection c = fc.conectar();
		Funcionario f = null;

		String sql = "SELECT id, nome, funcao, cpf, sexo, telefone, departamento, dataNascimento FROM funcionario WHERE cpf = ?";

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cpf);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				f = new Funcionario();

				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setFuncao(rs.getString("funcao"));
				f.setCpf(rs.getString("cpf"));
				f.setSexo(rs.getString("sexo"));
				f.setTelefone(rs.getString("telefone"));
				f.setDepartamento(rs.getString("departamento"));
				f.setDataNascimento(rs.getString("dataNascimento"));
			}
			return f;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

	/**
	 * Verifica o Cpf existente no BD procurando duplicidade
	 *
	 * @param cpf
	 *            CPF do funcionário
	 * @return verifica um cpf contido no BD
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	@Override
	public boolean verificarCpf(String cpf) throws ConexaoException, SQLException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT * FROM Usuario WHERE Usuario = '" + cpf + "'";
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			throw new SQLException();
		} finally {
			if (conexao != null) {
				try {
					con.desconectar(conexao);
				} catch (ConexaoException ex) {
					throw new ConexaoException();
				}
			}

		}
	}

}
