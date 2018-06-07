package projetopoo;

import Dados.Dao.PersistenciaFornecedor;
import Excecoes.ConexaoException;
import Negocio.ClassesBasicas.Fornecedor;

public class ProjetoPOO {

	public static void main(String[] args) {

		// TelaAutenticacaoUsuario telaAut = new TelaAutenticacaoUsuario();
		// telaAut.show();

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj("1");
		fornecedor.setRazao("1sadas");
		fornecedor.setFantasia("dasd");
		fornecedor.setContato("dasd");
		fornecedor.setTelefone("123");
		fornecedor.setEmail("as");

		PersistenciaFornecedor pfadd = new PersistenciaFornecedor();
		try {
			pfadd.InserirFornecedor(fornecedor);
		} catch (ConexaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
