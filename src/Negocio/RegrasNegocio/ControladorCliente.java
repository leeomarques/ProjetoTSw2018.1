/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.RegrasNegocio;

import java.util.ArrayList;

import Dados.IPersistenciaCliente;
import Dados.Dao.PersistenciaCliente;
import Excecoes.CampoVazioException;
import Excecoes.ConexaoException;
import Excecoes.DadosInvalidosException;
import Excecoes.cpfExistenteException;
import Negocio.ClassesBasicas.Cliente;

/**
 * Encontra-se toda a parte do negocio cliente
 * 
 * @author Carlos Eduardo
 */
public class ControladorCliente {

	IPersistenciaCliente persistenciaCli = new PersistenciaCliente();

	/**
	 * Verifica se da campo de cadastro é nulo ou vazio
	 * 
	 * @param cli
	 *            Objeto com todos os dados do Cliente
	 * @return Retorna true caso não tenha nenhum erro
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws CampoVazioException
	 *             Trata o erro de campo vazio
	 */

	public boolean VerificaCliente(Cliente cli) throws ConexaoException, CampoVazioException {
		if (cli.getNome() == null || cli.getNome().trim().isEmpty()) {
			throw new CampoVazioException();
		}
		if (cli.getCpf() == null || cli.getCpf().trim().isEmpty()) {
			throw new CampoVazioException();
		}
		if (cli.getEndereco() == null || cli.getEndereco().trim().isEmpty()) {
			throw new CampoVazioException();
		}
		if (cli.getEmail() == null || cli.getEmail().trim().isEmpty()) {
			throw new CampoVazioException();
		}
		if (cli.getNasc() == null || cli.getNasc().trim().isEmpty()) {
			throw new CampoVazioException();
		}
		if (cli.getTelefone() == null || cli.getTelefone().isEmpty()) {
			throw new CampoVazioException();
		}

		if (cli.getSexo() == null || cli.getSexo().isEmpty()) {
			throw new CampoVazioException();
		}

		return true;

	}

	/**
	 * Verifica se todos os campos do cadastro cliente estão certos
	 * 
	 * @param cli
	 *            Objeto com todos os dados do Cliente
	 * @return retorna true caso passe pelas validações
	 * @throws DadosInvalidosException
	 *             Trata o erro dos dados invalidos
	 */
	public boolean ValidaCliente(Cliente cli) throws DadosInvalidosException {

		if (cli.getNome().length() < 3) {
			throw new DadosInvalidosException("Nome invalido!");
		} else if (!cli.getNome().matches("^[A-Za-z ]+$")) {// utiliza um Regulador de expresão para permitir so letras
															// no campo
			throw new DadosInvalidosException("digite somente letras no campo nome!");
		} else if (cli.getSexo().length() > 1 || !cli.getSexo().matches("^[A-Za-z]+")) {// utiliza um Regulador de
																						// expresão para permitir so
																						// letras no campo
			throw new DadosInvalidosException("Só é permitido um caracter no campo Sexo!");
		} else if (cli.getCpf().length() != 11 || !cli.getCpf().matches("^[0-9]+")) {// Regulador de expresão para
																						// permitir só numeros
			throw new DadosInvalidosException("CPF invalido, preencha ao menos 11 numeros!");
		} else if (cli.getNasc().length() != 10) {// verifica se a data de nascimento é válida
			throw new DadosInvalidosException("Data de nascimento Invalida, preencha com numeros e barras!");
		} else if (cli.getTelefone().length() != 11 || !cli.getTelefone().matches("^[0-9]+")) {// verifica se a telofone
																								// é válido, junto com
																								// o Regulador de
																								// expresão para
																								// permitir só numeros
			throw new DadosInvalidosException("Telefone Invalido, digite somente numeros!");
		} else if (cli.getEmail().endsWith(".com") || cli.getEmail().endsWith(".com.br")
				|| cli.getEmail().endsWith(".COM") || cli.getEmail().endsWith(".COM.BR")) {
			return true;
		} // retorna true caso o email seja valido
		else {
			throw new DadosInvalidosException("Email invalido!");
		}

	}

	/**
	 * Efetua o cadastro do cliente caso o seu cpf ainda não esja cadastrado no
	 * banco
	 * 
	 * @param cli
	 *            Objeto com todos os dados do Cliente
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws cpfExistenteException
	 *             Trata o erro caso o cpf ja esteja cadastrado
	 */
	public void CadastraCliente(Cliente cli) throws ConexaoException, cpfExistenteException {

		boolean cpfjacadastrado = persistenciaCli.ConsultaCliente(cli.getCpf());
		if (cli.getID() == 0 && cpfjacadastrado) {// verifica se o cpf ja exite
			throw new cpfExistenteException();
		} else {
			if (cli.getID() == 0) {
				persistenciaCli.CasdastraCliente(cli);
			}

		}
	}

	public void AlteraCliente(Cliente cli) throws ConexaoException {
		persistenciaCli.AlteraCliente(cli);
	}

	public ArrayList<Cliente> getlistaCliente() throws ConexaoException {
		return persistenciaCli.getlistaCliente();
	}

	public Cliente getCliente(int id) throws ConexaoException {
		return persistenciaCli.getCliente(id);
	}

	public void DeletaCliente(int id) throws ConexaoException {
		persistenciaCli.DeletaCliente(id);
	}

}
