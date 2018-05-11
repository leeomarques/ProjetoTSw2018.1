
package Dados;

import java.util.ArrayList;

import Excecoes.ConexaoException;
import Negocio.ClassesBasicas.Usuario;

public interface IPersistenciaUsuario {

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
	public boolean AutenticarUsuario(String Login, String Senha) throws ConexaoException;

	/**
	 * Verifica se o usuario ja esta cadastrado no banco
	 * 
	 * @param Login
	 *            login usuario
	 * @return impede o cadastro do usuario caso o login ja exista
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	public boolean VerificarLogin(String Login) throws ConexaoException;

	/**
	 * Cadastra um usuario no banco
	 * 
	 * @param usu
	 *            Objeto com todos os dados de um usuario
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */
	public void InserirUsuario(Usuario usu) throws ConexaoException;

	/**
	 * ArrayList com todos os usuarios
	 * 
	 * @return Retorna uma lista com usuarios pela ordem do ID
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	public ArrayList<Usuario> GetListaUsuarios() throws ConexaoException;

	/**
	 * Seleciona o dados de um usuario
	 * 
	 * @param ID
	 *            identifica o usuario
	 * @return Retorna todos os dados de um usuario a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	public Usuario getUsuario(int ID) throws ConexaoException;

	/**
	 * Altera um usuario ja cadastrado
	 * 
	 * @param usu
	 *            Objeto contendo todos os dados de um usuario
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */

	public void AlterarUsuario(Usuario usu) throws ConexaoException;

	/**
	 * Deleta um usuario cadastrado no banco
	 * 
	 * @param ID
	 *            Identifica um usuario cadastro no banco
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o banco de dados
	 */
	public void DeletarUsuario(int ID) throws ConexaoException;
}
