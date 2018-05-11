
package Dados;

import java.util.ArrayList;

import Excecoes.ConexaoException;
import Excecoes.cpfExistenteException;
import Negocio.ClassesBasicas.Cliente;

/**
 *
 * @author karli
 */
public interface IPersistenciaCliente {
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

	public void CasdastraCliente(Cliente cli) throws ConexaoException, cpfExistenteException;

	/**
	 * Altera os Dados do Cliente ja cadastrado
	 * 
	 * @param cli
	 *            Objeto contendo todos os dados de um cliente
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public void AlteraCliente(Cliente cli) throws ConexaoException;

	/**
	 * Deleta um cliente cadastrado do banco de dados
	 * 
	 * @param id
	 *            Identifica o cliente no registro do banco
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public void DeletaCliente(int id) throws ConexaoException;

	/**
	 * Seleciona a partir de um ArrayList todos os dados de um cliente
	 * 
	 * @return Retorna os dados do Cliente em uma lista a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public ArrayList<Cliente> getlistaCliente() throws ConexaoException;

	/**
	 * Retorna todos os dados de Cliente
	 * 
	 * @param id
	 *            Identifica o Cliente a partir do seu ID
	 * @return Retorna todos os dados de Cliente a partir do ID
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public Cliente getCliente(int id) throws ConexaoException;

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

	public boolean ConsultaCliente(String cpf) throws ConexaoException;

}
