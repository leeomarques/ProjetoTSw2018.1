package Dados.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dados.IPersistenciaUsuario;
import Excecoes.ConexaoException;
import FabricaConexao.FabricaConexao;
import Negocio.ClassesBasicas.Usuario;

public class PersistenciaUsuario implements IPersistenciaUsuario {

	/**
	 * Autentica um usuario ja cadastrado no banco de dados
	 * 
	 * @param Login
	 *            Login de um usuario
	 * @param Senha
	 *            Senha de um usuario
	 * @return Retorna o acesso ao programa caso o login e senha sejam confirmados
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */
	@Override
	public boolean AutenticarUsuario(String Login, String Senha) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT * FROM Usuario WHERE Usuario = '" + Login + "' AND Senha = '" + Senha + "'";
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

	/**
	 * Verifica se o usuario ja esta cadastrado no banco
	 * 
	 * @param Login
	 *            login usuario
	 * @return impede o cadastro do usuario caso o login ja exista
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	@Override
	public boolean VerificarLogin(String Login) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT * FROM Usuario WHERE Usuario = '" + Login + "'";
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

	/**
	 * Cadastra um usuario no banco
	 * 
	 * @param usu
	 *            Objeto com todos os dados de um usuario
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */
	@Override
	public void InserirUsuario(Usuario usu) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "INSERT INTO Usuario (Usuario, Senha) VALUES " + "('" + usu.getLogin() + "', '"
					+ usu.getSenha() + "')";
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

	/**
	 * ArrayList com todos os usuarios
	 * 
	 * @return Retorna uma lista com usuarios pela ordem do ID
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	@Override
	public ArrayList<Usuario> GetListaUsuarios() throws ConexaoException {
		ArrayList<Usuario> lista = new ArrayList<>();

		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT ID, Usuario, Senha FROM Usuario ORDER BY ID";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setLogin(rs.getString("Usuario"));
				usu.setSenha(rs.getString("Senha"));
				usu.setID(rs.getInt("ID"));
				lista.add(usu);
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

		return lista;
	}

	/**
	 * Seleciona o dados de um usuario
	 * 
	 * @param ID
	 *            identifica o usuario
	 * @return Retorna todos os dados de um usuario a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	@Override
	public Usuario getUsuario(int ID) throws ConexaoException {
		Usuario usu = new Usuario();

		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT Usuario, Senha FROM Usuario WHERE ID = " + ID;
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				usu = new Usuario();
				usu.setLogin(rs.getString("Usuario"));
				usu.setSenha(rs.getString("Senha"));
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

		return usu;
	}

	/**
	 * Altera um usuario ja cadastrado
	 * 
	 * @param usu
	 *            Objeto contendo todos os dados de um usuario
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	@Override
	public void AlterarUsuario(Usuario usu) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "UPDATE Usuario SET Usuario = '" + usu.getLogin() + "', Senha = '" + usu.getSenha() + "'"
					+ " WHERE ID = " + usu.getID();
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

	/**
	 * Deleta um usuario cadastrado no banco
	 * 
	 * @param ID
	 *            Identifica um usuario cadastro no banco
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	@Override
	public void DeletarUsuario(int ID) throws ConexaoException {
		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "DELETE FROM Usuario WHERE ID = " + ID;
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
