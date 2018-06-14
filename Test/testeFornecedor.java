import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Dados.Dao.PersistenciaFornecedor;
import Excecoes.CampoVazioException;
import Excecoes.CnpjExistenteException;
import Excecoes.CnpjInvalidoException;
import Excecoes.ConexaoException;
import Negocio.Fachada;
import Negocio.ClassesBasicas.Fornecedor;
import Negocio.RegrasNegocio.ControladorFornecedor;

public class testeFornecedor {
	
	Fornecedor fornecedor;
	Fachada fachada;
	
	
	@Before
	public void before() {
		fornecedor = new Fornecedor();
		fachada = new Fachada();
		
	}

	@Test(expected=CampoVazioException.class)
	public void InsereFornecedorCampoVazioException() throws CnpjInvalidoException, CampoVazioException, CnpjExistenteException, ConexaoException {
		
		fornecedor.setCnpj("");
		fornecedor.setRazao("");
		fornecedor.setFantasia("");
		fornecedor.setContato("");
		fornecedor.setTelefone("");
		fornecedor.setEmail("");
		
		fachada.InserirFornecedor(fornecedor);
	}
	
	@Test(expected=CnpjInvalidoException.class)
	public void InsereFornecedorCnpjInvalidoException() throws CnpjInvalidoException, CampoVazioException, CnpjExistenteException, ConexaoException {
		
		fornecedor.setCnpj("222");
		fornecedor.setRazao("asd");
		fornecedor.setFantasia("dd");
		fornecedor.setContato("ff");
		fornecedor.setTelefone("asdas");
		fornecedor.setEmail("asdsad");

		fachada.InserirFornecedor(fornecedor);
		
	}
	
	@Test
	public void InsereFornecedor() throws CnpjInvalidoException, CampoVazioException, CnpjExistenteException, ConexaoException {
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj("12345678912345");
		fornecedor.setRazao("razãot");
		fornecedor.setFantasia("fantasiat");
		fornecedor.setContato("contatot");
		fornecedor.setTelefone("telefonet");
		fornecedor.setEmail("emailt");	
		
		
		fachada.InserirFornecedor(fornecedor);
		
		fachada.ExcluirFornecedor(fachada.consultaFornecedor(fornecedor.getCnpj()).getId());
		
		
	}
	
	@Test
	public void ConsultaFornecedor() throws  ConexaoException {

		assertNotNull( fachada.consultaFornecedor("123") );

	}

}
