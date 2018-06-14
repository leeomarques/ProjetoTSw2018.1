import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Excecoes.CampoVazioException;
import Excecoes.ConexaoException;
import Negocio.Fachada;
import Negocio.ClassesBasicas.Funcionario;
import Negocio.ClassesBasicas.Produto;
import Negocio.RegrasNegocio.ControladorFuncionario;
import Negocio.RegrasNegocio.ControladorProduto;

public class testeProduto {

	Produto produto;
	Fachada fachada; 
	@Before
	public void before() {
		produto = new Produto();
		fachada = new Fachada();
	}
	@Test(expected=CampoVazioException.class)
	public void verificarProdutoVazio1() throws ConexaoException, CampoVazioException{
		
		
		fachada.inserirProduto(produto);

	}
	
	@Test(expected=CampoVazioException.class)
	public void verificarProdutoVazio2() throws  ConexaoException, CampoVazioException {
		
		produto.setDescricaoProduto("PRODUTO1");
		
		fachada.inserirProduto(produto);

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
	public void verificarProdutoVazio4() throws  ConexaoException,CampoVazioException {
		
		produto.setDescricaoProduto("PRODUTO1");
		produto.setValorProduto(10.3);

		fachada.inserirProduto(produto);

	}
	
	@Test
	public void insereProduto() throws  ConexaoException, CampoVazioException {
		
		produto.setDescricaoProduto("PRODUTO1");
		produto.setValorProduto(10.3);
		produto.setQuantidadeProduto("10");
		produto.setIdFornecedorProduto(1);
		
		fachada.inserirProduto(produto);

	}
	
	@Test
	public void insereProdutoFachada() throws  ConexaoException, CampoVazioException{
		
		
		
		produto.setDescricaoProduto("PRODUTO1");
		produto.setValorProduto(10.3);
		produto.setQuantidadeProduto("10");
		produto.setIdFornecedorProduto(1);
		
		fachada.inserirProduto(produto);

	}
	
	
}
