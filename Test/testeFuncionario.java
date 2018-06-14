import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


import Excecoes.CampoVazioException;
import Excecoes.ConexaoException;
import Excecoes.DadoDuplicadoException;
import Excecoes.DadosInvalidosException;
import Excecoes.FuncionarioExistenteException;
import Excecoes.GeralException;
import Excecoes.cpfExistenteException;
import Excecoes.cpfInvalidoException;
import Negocio.Fachada;
import Negocio.ClassesBasicas.Funcionario;

public class testeFuncionario {
	
	Funcionario funcionario;
	Fachada fachada;
	
	@Before
	public void before(){
		funcionario = new Funcionario();
		fachada = new Fachada();
	}
	
	@Test
	public void insereFuncionario() throws  FuncionarioExistenteException,CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {

		funcionario.setNome("Carlos");
		funcionario.setFuncao("vendedor");
		funcionario.setCpf("22222222233");
		funcionario.setSexo("M");
		funcionario.setTelefone("99992222");
		funcionario.setDataNascimento("03/01/1980");
		funcionario.setDepartamento("vendas");
		
		fachada.salvarFuncionario(funcionario);//.incluirFuncionario(funcionario);
		fachada.excluirFuncionario(fachada.consultarFuncionario(funcionario.getCpf()).getId());

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio1() throws  FuncionarioExistenteException,CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {

		
		fachada.salvarFuncionario(funcionario);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio2() throws  FuncionarioExistenteException,CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {

		funcionario.setNome("Henrique");
		
		fachada.salvarFuncionario(funcionario);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio3() throws  FuncionarioExistenteException,CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {

		funcionario.setNome("Pedro");
		funcionario.setFuncao("vendedor");
		
		
		fachada.salvarFuncionario(funcionario);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio4() throws  FuncionarioExistenteException,CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {

		funcionario.setNome("Pedro");
		funcionario.setFuncao("vendedor");
		funcionario.setCpf("22333444");
		
		
		fachada.salvarFuncionario(funcionario);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio5() throws  FuncionarioExistenteException,CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {

		funcionario.setNome("Pedro");
		funcionario.setFuncao("vendedor");
		funcionario.setCpf("22333444");
		funcionario.setSexo("M");
		
		
		fachada.salvarFuncionario(funcionario);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio6() throws  FuncionarioExistenteException,CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {

		funcionario.setNome("Pedro");
		funcionario.setFuncao("vendedor");
		funcionario.setCpf("22333444");
		funcionario.setSexo("M");
		funcionario.setTelefone("99992222");
		
		
		fachada.salvarFuncionario(funcionario);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio7() throws  FuncionarioExistenteException,CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {

		funcionario.setNome("Pedro");
		funcionario.setFuncao("vendedor");
		funcionario.setCpf("22333444");
		funcionario.setSexo("M");
		funcionario.setTelefone("99992222");
		funcionario.setDataNascimento("03/01/1980");
		
		
		fachada.salvarFuncionario(funcionario);

	}
	
	
	

}
