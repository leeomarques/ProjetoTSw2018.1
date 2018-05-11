package Dados.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dados.IPersistenciaFornecedor;
import Excecoes.ConexaoException;
import FabricaConexao.FabricaConexao;
import Negocio.ClassesBasicas.Fornecedor;

public class PersistenciaFornecedor implements IPersistenciaFornecedor {

	// Metodo para verificar se um fornecedor existe
	@Override
	public boolean VerificarCnpj(String cnpj) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT * FROM Fornecedor WHERE cnpj = '" + cnpj + "'";
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			throw new ConexaoException();
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

	// Metodo para inserir um novo fornecedor
	@Override
	public void InserirFornecedor(Fornecedor novoForn) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "INSERT INTO Fornecedor (cnpj, razaoSocial, nomeFantasia, contato, email, telefone, status) VALUES "
					+ "('" + novoForn.getCnpj() + "', '" + novoForn.getRazao() + "', '" + novoForn.getFantasia()
					+ "', '" + novoForn.getContato() + "', '" + novoForn.getEmail() + "', '" + novoForn.getTelefone()
					+ "'," + 1 + ")";
			st.executeUpdate(query);

		} catch (SQLException ex) {
			throw new ConexaoException();
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

	// Metodo para listar todos os fornecedores ativos
	@Override
	public ArrayList<Fornecedor> ListagemFornecedor() throws ConexaoException {
		ArrayList<Fornecedor> listaForn = new ArrayList<>();

		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT cnpj, razaoSocial, nomeFantasia, contato, email, telefone, id FROM Fornecedor WHERE status ='"
					+ 1 + "' ORDER BY ID";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Fornecedor novoForn = new Fornecedor();
				novoForn.setCnpj(rs.getString("cnpj"));
				novoForn.setRazao(rs.getString("razaoSocial"));
				novoForn.setFantasia(rs.getString("nomeFantasia"));
				novoForn.setContato(rs.getString("contato"));
				novoForn.setEmail(rs.getString("email"));
				novoForn.setTelefone(rs.getString("telefone"));
				novoForn.setId(rs.getInt("id"));
				listaForn.add(novoForn);
			}

		} catch (SQLException e) {
			throw new ConexaoException();
		} finally {
			if (conexao != null) {
				try {
					con.desconectar(conexao);
				} catch (ConexaoException ex) {
					throw new ConexaoException();
				}
			}
		}
		return listaForn;
	}

	// Metodo para verificar se um fornecedor existe
	@Override
	public Fornecedor consultaFornecedor(int ID) throws ConexaoException {
		Fornecedor novoForn = new Fornecedor();

		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT cnpj, razaoSocial, nomeFantasia, contato, email, telefone FROM Fornecedor WHERE ID = "
					+ ID;
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				novoForn = new Fornecedor();
				novoForn.setCnpj(rs.getString("cnpj"));
				novoForn.setRazao(rs.getString("razaoSocial"));
				novoForn.setFantasia(rs.getString("nomeFantasia"));
				novoForn.setContato(rs.getString("contato"));
				novoForn.setEmail(rs.getString("email"));
				novoForn.setTelefone(rs.getString("telefone"));
			}

		} catch (SQLException e) {
			throw new ConexaoException();
		} finally {
			if (conexao != null) {
				try {
					con.desconectar(conexao);
				} catch (ConexaoException e) {
					throw new ConexaoException();
				}
			}
		}
		return novoForn;
	}

	// Metodo para alterar um fornecedor existente
	@Override
	public void AlterarFornecedor(Fornecedor novoForn) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "UPDATE Fornecedor SET        cnpj           = '" + novoForn.getCnpj()
					+ "', razaoSocial    = '" + novoForn.getRazao() + "', nomeFantasia   = '" + novoForn.getFantasia()
					+ "', contato        = '" + novoForn.getContato() + "', email          = '" + novoForn.getEmail()
					+ "', telefone       = '" + novoForn.getTelefone() + "'" + " WHERE ID = " + novoForn.getId();
			st.executeUpdate(query);

		} catch (SQLException ex) {
			throw new ConexaoException();
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

	// Metodo para excluir um fornecedor
	@Override
	public void ExcluirFornecedor(int ID) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "UPDATE Fornecedor SET  status = " + 0 + "" + " WHERE ID = " + ID;
			st.executeUpdate(query);

		} catch (SQLException e) {
			throw new ConexaoException();
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