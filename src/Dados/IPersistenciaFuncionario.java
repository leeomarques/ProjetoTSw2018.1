package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import Excecoes.ConexaoException;
import Negocio.ClassesBasicas.Funcionario;

public interface IPersistenciaFuncionario {

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
	public void incluirFuncionario(Funcionario f) throws ConexaoException, SQLException;

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
	public void excluirFuncionario(Integer id) throws ConexaoException, SQLException;

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
	public void alterarFuncionario(Funcionario f) throws ConexaoException, SQLException;

	/**
	 * Lista todos os Funcionários
	 *
	 * @return Um ArrayList contendo todos os Funcionários
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	public ArrayList<Funcionario> listarFuncionario() throws ConexaoException, SQLException;

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
	public Funcionario getFuncionario(Integer id) throws ConexaoException, SQLException;

	/**
	 * Faz uma busca na tabela funcionário pelo valor digitado no campo Nome
	 *
	 * @param nome
	 *            Nome do Funcionário
	 * @return retorna um funcionario através do nome
	 * @throws ConexaoException
	 *             Trata o erro com a conexão com o BD
	 * @throws SQLException
	 *             Trata o erro com o BD
	 */
	public Funcionario consultarFuncionario(String nome) throws ConexaoException, SQLException;

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
	public boolean verificarCpf(String cpf) throws ConexaoException, SQLException;

}
