
package Negocio.RegrasNegocio;

import java.util.ArrayList;

import Dados.IPersistenciaUsuario;
import Dados.Dao.PersistenciaUsuario;
import Excecoes.CampoVazioException;
import Excecoes.ConexaoException;
import Excecoes.LoginExistenteException;
import Negocio.ClassesBasicas.Usuario;

public class ControladorUsuario {

	IPersistenciaUsuario persistenciaUsuario = new PersistenciaUsuario();

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
	public boolean AutenticarUsuario(String Login, String Senha) throws ConexaoException {
		if (!Login.equals("") && !Senha.equals("")) {

			return persistenciaUsuario.AutenticarUsuario(Login, Senha);
		} else {
			return false;
		}
	}

	/**
	 * Cadastra um Usuario na banco de dados
	 * 
	 * @param usu
	 *            Objeto com os dados do usuario
	 * @throws CampoVazioException
	 *             Trata o erro de campo vazio
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 * @throws LoginExistenteException
	 *             Trata o erro caso usuario ja esteja cadastrado
	 */

	public void InserirUsuario(Usuario usu) throws CampoVazioException, ConexaoException, LoginExistenteException {
		if (usu.getLogin().equals("") || usu.getSenha().equals("")) {
			throw new CampoVazioException();
		} else {
			boolean loginExistente = persistenciaUsuario.VerificarLogin(usu.getLogin());
			if (usu.getID() == 0 && loginExistente) {// verifica se o login ja existe
				throw new LoginExistenteException();
			} else {
				if (usu.getID() == 0) {
					persistenciaUsuario.InserirUsuario(usu);
				} else {
					persistenciaUsuario.AlterarUsuario(usu);
				}

			}
		}
	}

	public ArrayList<Usuario> GetListaUsuarios() throws ConexaoException {
		return persistenciaUsuario.GetListaUsuarios();
	}

	public Usuario getUsuario(int ID) throws ConexaoException {
		return persistenciaUsuario.getUsuario(ID);
	}

	public void DeletarUsuario(int ID) throws ConexaoException {
		persistenciaUsuario.DeletarUsuario(ID);
	}

}
