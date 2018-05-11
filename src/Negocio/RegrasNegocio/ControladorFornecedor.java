package Negocio.RegrasNegocio;

import java.util.ArrayList;

import Dados.IPersistenciaFornecedor;
import Dados.Dao.PersistenciaFornecedor;
import Excecoes.CampoVazioException;
import Excecoes.CnpjExistenteException;
import Excecoes.CnpjInvalidoException;
import Excecoes.ConexaoException;
import Negocio.ClassesBasicas.Fornecedor;

public class ControladorFornecedor {

	IPersistenciaFornecedor persistenciaFornecedor = new PersistenciaFornecedor();

	// Metodo para inserir um novo fornecedor
	public void InserirFornecedor(Fornecedor novoForn)
			throws CnpjInvalidoException, CampoVazioException, CnpjExistenteException, ConexaoException {

		// Verifica se existe algum campo obrigatorio vazio
		if (novoForn.getCnpj().trim().isEmpty() || novoForn.getRazao().trim().isEmpty()
				|| novoForn.getFantasia().trim().isEmpty() || novoForn.getContato().trim().isEmpty()
				|| novoForn.getTelefone().trim().isEmpty() || novoForn.getEmail().trim().isEmpty()) {
			throw new CampoVazioException();
		} else {// Verifica se o CNPJ informado é valido
			if (novoForn.getCnpj().length() != 14) {
				throw new CnpjInvalidoException();
			} else {// Verifica se um CNPJ ja existe
				boolean cnpjExistente = persistenciaFornecedor.VerificarCnpj(novoForn.getCnpj());
				if (novoForn.getId() == 0 && cnpjExistente) {
					throw new CnpjExistenteException();
				} else {// SE o CNPJ não existe ele inclui
					if (novoForn.getId() == 0) {
						persistenciaFornecedor.InserirFornecedor(novoForn);
					} else {// Se o CNPJ já existe ele alterar
						persistenciaFornecedor.AlterarFornecedor(novoForn);
					}
				}
			}
		}
	}

	// Metodo para listar todos os fornecedores ativos
	public ArrayList<Fornecedor> ListagemFornecedor() throws ConexaoException {
		return persistenciaFornecedor.ListagemFornecedor();
	}

	// Metodo para verificar se um fornecedor existe
	public Fornecedor consultaFornecedor(int ID) throws ConexaoException {
		return persistenciaFornecedor.consultaFornecedor(ID);
	}

	// Metodo para excluir um fornecedor
	public void ExcluirFornecedor(int ID) throws ConexaoException {
		persistenciaFornecedor.ExcluirFornecedor(ID);
	}
}