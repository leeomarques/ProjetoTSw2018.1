import static org.junit.Assert.*;

import org.junit.Test;

import Dados.Dao.PersistenciaCliente;
import Dados.Dao.PersistenciaFornecedor;
import Dados.Dao.PersistenciaProduto;
import Excecoes.ConexaoException;
import Excecoes.cpfExistenteException;
import Excecoes.CampoVazioException;
import Excecoes.CnpjExistenteException;
import Excecoes.CnpjInvalidoException;
import Negocio.ClassesBasicas.Cliente;
import Negocio.ClassesBasicas.Fornecedor;
import Negocio.ClassesBasicas.Funcionario;
import Negocio.ClassesBasicas.Produto;
import Negocio.RegrasNegocio.ControladorFornecedor;
import Negocio.RegrasNegocio.ControladorFuncionario;
import Negocio.RegrasNegocio.ControladorProduto;

public class testeUnitario {

	@Test
	public void InsereCliente() throws ConexaoException, cpfExistenteException{
		boolean retorno = false;
		
		Cliente c = new Cliente();
		c.setNome("Leonardo");
		c.setSexo("M");
		c.setCpf("333");
		c.setEndereco("Avenida Boa Viagem, 1000");
		c.setEmail("leonardogm16@gmail.com");
		c.setNasc("30/10/1990");
		c.setTelefone("81997724885");
		
		
		PersistenciaCliente pc = new PersistenciaCliente();
		
		pc.CasdastraCliente(c);
		retorno = pc.ConsultaCliente("333");
		
		assertTrue(retorno);
	}
	
	@Test(timeout=4000) 
	public void testaConsultaClienteValido() throws ConexaoException{
		boolean retorno = false;
		PersistenciaCliente pc = new PersistenciaCliente();
		

		retorno = pc.ConsultaCliente("01144511410");

		assertTrue(retorno);
	}
	
	@Test
	public void testaConsultaClienteInValido() throws ConexaoException{
		boolean retorno = false;
		PersistenciaCliente pc = new PersistenciaCliente();
		retorno = pc.ConsultaCliente("014511410");

		assertFalse(retorno);
	}
	
	@Test(expected=CampoVazioException.class)
	public void InsereFornecedorCampoVazioException() throws CnpjInvalidoException, CampoVazioException, CnpjExistenteException, ConexaoException {
		boolean retorno = false;
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj("");
		fornecedor.setRazao("");
		fornecedor.setFantasia("");
		fornecedor.setContato("");
		fornecedor.setTelefone("");
		fornecedor.setEmail("");
		
		
		ControladorFornecedor pf = new ControladorFornecedor();
		
		pf.InserirFornecedor(fornecedor);
		
		
	}
	
	@Test(expected=CnpjInvalidoException.class)
	public void InsereFornecedorCnpjInvalidoException() throws CnpjInvalidoException, CampoVazioException, CnpjExistenteException, ConexaoException {
		boolean retorno = false;
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj("222");
		fornecedor.setRazao("asd");
		fornecedor.setFantasia("dd");
		fornecedor.setContato("ff");
		fornecedor.setTelefone("asdas");
		fornecedor.setEmail("asdsad");
		
		
		ControladorFornecedor pf = new ControladorFornecedor();
		
		pf.InserirFornecedor(fornecedor);
		
		
	}
	
	@Test
	public void InsereFornecedor() throws CnpjInvalidoException, CampoVazioException, CnpjExistenteException, ConexaoException {
		boolean retorno = true;
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj("1111");
		fornecedor.setRazao("razãot");
		fornecedor.setFantasia("fantasiat");
		fornecedor.setContato("contatot");
		fornecedor.setTelefone("telefonet");
		fornecedor.setEmail("emailt");
		
		
		PersistenciaFornecedor pf = new PersistenciaFornecedor();
		
		pf.InserirFornecedor(fornecedor);
		
		
	}
	
	@Test
	public void ConsultaFornecedor() throws  ConexaoException {
	
		ControladorFornecedor pf = new ControladorFornecedor();

		assertNull( pf.consultaFornecedor(123) );

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarProdutoVazio1() throws  CampoVazioException {
		
		Produto produto = new Produto();
		
		ControladorProduto cp = new ControladorProduto();
		
		cp.verificarProduto(produto);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarProdutoVazio2() throws  CampoVazioException {
		
		Produto produto = new Produto();
		produto.setDescricaoProduto("PRODUTO1");
		ControladorProduto cp = new ControladorProduto();
		
		cp.verificarProduto(produto);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarProdutoVazio3() throws  CampoVazioException {
		
		Produto produto = new Produto();
		produto.setDescricaoProduto("PRODUTO1");
		produto.setValorProduto(10.3);
		ControladorProduto cp = new ControladorProduto();
		
		cp.verificarProduto(produto);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarProdutoVazio4() throws  CampoVazioException {
		
		Produto produto = new Produto();
		produto.setDescricaoProduto("PRODUTO1");
		produto.setValorProduto(10.3);
		produto.setQuantidadeProduto("10");
		ControladorProduto cp = new ControladorProduto();
		
		cp.verificarProduto(produto);

	}
	
	@Test
	public void insereProduto() throws  ConexaoException {
		
		Produto produto = new Produto();
	
		produto.setDescricaoProduto("PRODUTO2");
		produto.setValorProduto(100);
		produto.setQuantidadeProduto("10");
		
		PersistenciaProduto cp = new PersistenciaProduto();
		
		cp.inserirProduto(produto);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio1() throws  CampoVazioException {
		
		Funcionario funcionario = new Funcionario();

		ControladorFuncionario cf = new ControladorFuncionario();
		
		cf.verificaCampo(funcionario);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarFuncionarioVazio2() throws  CampoVazioException {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Henrique");

		ControladorFuncionario cf = new ControladorFuncionario();
		
		cf.verificaCampo(funcionario);

	}
	

}
