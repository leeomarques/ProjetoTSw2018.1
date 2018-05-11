package Negocio.RegrasNegocio;

import java.sql.SQLException;
import java.util.ArrayList;

import Dados.IPersistenciaFuncionario;
import Dados.Dao.PersistenciaFuncionario;
import Excecoes.CampoVazioException;
import Excecoes.ConexaoException;
import Excecoes.FuncionarioExistenteException;
import Excecoes.GeralException;
import Excecoes.cpfExistenteException;
import Excecoes.cpfInvalidoException;
import Negocio.ClassesBasicas.Funcionario;

public class ControladorFuncionario {

	public IPersistenciaFuncionario persistenciaFuncionario;

	public ControladorFuncionario() {
		persistenciaFuncionario = new PersistenciaFuncionario();
	}

	/**
	 * Verifica se os campos do cadastro são nulos ou vazio
	 * 
	 * @param f
	 *            Objeto com todos os dados do funcionario
	 * @throws CampoVazioException
	 *             Trata o erro de campo vazio
	 */
	public void verificaCampo(Funcionario f) throws CampoVazioException {

		if (f.getNome() == null || f.getNome().trim().isEmpty()) {
			throw new CampoVazioException("Campo do Nome Vazio");
		}
		if (f.getFuncao() == null || f.getFuncao().trim().isEmpty()) {
			throw new CampoVazioException("Campo da Função Vazio");
		}
		if (f.getCpf() == null || f.getCpf().trim().isEmpty()) {
			throw new CampoVazioException("Campo do CPF Vazio");
		}
		if (f.getSexo() == null || f.getSexo().trim().isEmpty()) {
			throw new CampoVazioException("Campo do Sexo Vazio");
		}
		if (f.getTelefone() == null || f.getTelefone().trim().isEmpty()) {
			throw new CampoVazioException("Campo do Telefone Vazio");
		}
		if (f.getDataNascimento() == null || f.getDataNascimento().trim().isEmpty()) {
			throw new CampoVazioException("Campo da Data de Nascimento Vazia");
		}
		if (f.getDepartamento() == null || f.getDepartamento().trim().isEmpty()) {
			throw new CampoVazioException("Campo do Departamento Vazio");
		}
	}

	/**
	 * Verifica se todos os dados estão certos
	 * 
	 * @param f
	 *            Objeto com todos os dados do funcionario
	 * @throws cpfExistenteException
	 *             Trata o erro caso o cpf ja esteja cadastrado
	 * @throws cpfInvalidoException
	 *             Trata o erro caso o cpf esteja invalido
	 * @throws ConexaoException
	 *             erro de conexão com o banco de dados
	 * @throws SQLException
	 *             erro de conexão com o banco de dados
	 */
	public void validacaoCpf(Funcionario f)
			throws cpfExistenteException, cpfInvalidoException, ConexaoException, SQLException {
		if (f.getCpf().length() != 11) {
			throw new cpfInvalidoException("CPF Inválido");
		} else {
			boolean cpfExistente = persistenciaFuncionario.verificarCpf(f.getCpf());// verifica se cpf ja existe
			if (cpfExistente == true) {
				throw new cpfExistenteException("CPF Já Existe no BD !");
			}

		}
	}

	public void incluirFuncionario(Funcionario f)
			throws GeralException, ConexaoException, SQLException, FuncionarioExistenteException {
		persistenciaFuncionario.incluirFuncionario(f);

	}

	public void alterarFuncionario(Funcionario f) throws GeralException, ConexaoException, SQLException {
		persistenciaFuncionario.alterarFuncionario(f);

	}

	public void excluirFuncionario(Integer id) throws GeralException, ConexaoException, SQLException {
		persistenciaFuncionario.excluirFuncionario(id);

	}

	public ArrayList<Funcionario> listarFuncionario() throws GeralException, ConexaoException, SQLException {
		return persistenciaFuncionario.listarFuncionario();
	}

	public Funcionario getFuncionario(Integer id) throws GeralException, ConexaoException, SQLException {
		return persistenciaFuncionario.getFuncionario(id);
	}

	public Funcionario consultarFuncionario(String nome) throws GeralException, ConexaoException, SQLException {
		return persistenciaFuncionario.consultarFuncionario(nome);
	}

	public boolean verificarCpf(String cpf) throws GeralException, ConexaoException, SQLException {
		return persistenciaFuncionario.verificarCpf(cpf);
	}
}
