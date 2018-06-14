import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Dados.Dao.PersistenciaCliente;
import Excecoes.CampoVazioException;
import Excecoes.ConexaoException;
import Excecoes.DadosInvalidosException;
import Excecoes.cpfExistenteException;
import Negocio.Fachada;
import Negocio.ClassesBasicas.Cliente;

public class testeCliente {

	//PersistenciaCliente pc;
	Fachada fachada; 
	Cliente c;
	
	@Before
	public void before() {
		c = new Cliente();
		fachada = new Fachada();
		//pc = new PersistenciaCliente();
	}
	
	@Test
	public void InsereCliente() throws ConexaoException, CampoVazioException, cpfExistenteException, DadosInvalidosException {
	
			
		c.setNome("Leonardo");
		c.setSexo("M");
		c.setCpf("66666666666");
		c.setEndereco("Avenida Boa Viagem, 1000");
		c.setEmail("leonardogm16@gmail.com");
		c.setNasc("30/10/1990");
		c.setTelefone("81997724885");
		
		fachada.CadastraCliente(c);
		
		assertEquals("66666666666", fachada.getCliente("66666666666").getCpf());
		
		fachada.DeletaCliente(fachada.getCliente("66666666666").getID());
	}
	
	@Test(timeout=4000) 
	public void testaConsultaClienteValido() throws ConexaoException{
	
		assertEquals("66666666667", fachada.getCliente("66666666667").getCpf());
	}
	
	@Test
	public void testaConsultaClienteInValido() throws ConexaoException{
		
		assertNull( fachada.getCliente("123456789"));
	}

	@Test
    public void InsereClienteConstrutor() throws ConexaoException, CampoVazioException, cpfExistenteException, DadosInvalidosException {
	
	

	c = new Cliente("Paulo", "98765432109", "hh", "hh", "hh", "12343","m", 99999);
	assertEquals("Paulo", c.getNome());
}
}
