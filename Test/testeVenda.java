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
import Negocio.ClassesBasicas.Cliente;
import Negocio.ClassesBasicas.Funcionario;
import Negocio.ClassesBasicas.Venda;
import Negocio.RegrasNegocio.ControladorVenda;

public class testeVenda {
	
	//ControladorVenda cv;
	Venda venda;
	Fachada fachada;
	Cliente cliente;
	Funcionario funcionario;
	
	@Before
	public void before() {
		fachada = new Fachada();
		//cv = new ControladorVenda();
		venda = new Venda();
		cliente = new Cliente();
		funcionario = new Funcionario();
	}
	
	@Test
	public void insereVenda() throws CampoVazioException, ConexaoException, DadosInvalidosException, cpfExistenteException, 
	CampoVazioException, DadosInvalidosException, cpfExistenteException, cpfInvalidoException,
	ConexaoException, SQLException, DadoDuplicadoException, GeralException, FuncionarioExistenteException {
		
		cliente.setNome("Leonardo");
		cliente.setSexo("M");
		cliente.setCpf("96367617019");
		cliente.setEndereco("Rua nova");
		cliente.setEmail("cadastro@gmail.com");
		cliente.setNasc("30/10/1870");
		cliente.setTelefone("81997724885");

		
		fachada.CadastraCliente(cliente);
		
		cliente = fachada.getCliente(cliente.getCpf());
		
		
		funcionario.setNome("Carlos");
		funcionario.setFuncao("vendedor");
		funcionario.setCpf("22222222233");
		funcionario.setSexo("M");
		funcionario.setTelefone("99992222");
		funcionario.setDataNascimento("03/01/1980");
		funcionario.setDepartamento("vendas");
		
		fachada.salvarFuncionario(funcionario);
		
		funcionario = fachada.consultarFuncionario(funcionario.getCpf());
		
		
		venda.setValorTotal(10);
		venda.setIDCliente(cliente);
		venda.setIDFuncionario(funcionario);
		
		fachada.InserirVenda(venda);
		
		
		fachada.excluirFuncionario(funcionario.getId());
		fachada.DeletaCliente(cliente.getID());

	}
	@Test (expected=CampoVazioException.class)
	public void insereVenda1() throws CampoVazioException, ConexaoException  {

		venda = new Venda();
		venda.setValorTotal(0);

		
		fachada.InserirVenda(venda);

	}
	
	@Test
	public void insereVendaProduto() throws CampoVazioException, ConexaoException  {

		
		fachada.InserirVendaProduto(1, 1);

	}
	
	@Test
	public void listaVenda() throws GeralException, ConexaoException, SQLException  {

		
		assertNotNull(fachada.listarVenda());

	}
	
	
	

}
