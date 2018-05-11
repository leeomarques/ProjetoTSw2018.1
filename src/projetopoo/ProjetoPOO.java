package projetopoo;

import Dados.Dao.PersistenciaCliente;
import Excecoes.ConexaoException;
import Excecoes.cpfExistenteException;
import Negocio.ClassesBasicas.Cliente;

public class ProjetoPOO {

	public static void main(String[] args) {

		// TelaAutenticacaoUsuario telaAut = new TelaAutenticacaoUsuario();
		// telaAut.show();

		Cliente c = new Cliente();
		c.setNome("Leonardo");
		c.setSexo("M");
		c.setCpf("01144511410");
		c.setEndereco("Avenida Boa Viagem, 1000");
		c.setEmail("leonardogm16@gmail.com");
		c.setNasc("30/10/1990");
		c.setTelefone("81997724885");
		
		PersistenciaCliente pc = new PersistenciaCliente();
		try {
			pc.CasdastraCliente(c);
		} catch (ConexaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (cpfExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
