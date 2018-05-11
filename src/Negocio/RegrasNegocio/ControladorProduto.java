package Negocio.RegrasNegocio;

import java.util.ArrayList;

import Dados.IPersistenciaProduto;
import Dados.Dao.PersistenciaProduto;
import Excecoes.CampoVazioException;
import Excecoes.ConexaoException;
import Negocio.ClassesBasicas.Produto;

/**
 * verifica e autentica o produto que será cadastrado
 *
 * @author rafael
 */
public class ControladorProduto {

	public IPersistenciaProduto IPP;

	public ControladorProduto() {
		IPP = new PersistenciaProduto();
	}

	/**
	 * vefifica se os campos do produto que esta sendo cadastrado é nulo ou vazio
	 * 
	 * @param p
	 *            recebe uma instancia de Produto
	 * @throws CampoVazioException
	 *             trata o erro de campo vazio ou nulo
	 */

	public void verificarProduto(Produto p) throws CampoVazioException {

		if (p.getDescricaoProduto() == null || p.getDescricaoProduto().trim().isEmpty()) {
			throw new CampoVazioException("Campo da Descrição está vazio");
		}
		if (p.getValorProduto() == 0) {
			throw new CampoVazioException("Campo do valor está vazio");
		}
		if (p.getQuantidadeProduto() == null || p.getQuantidadeProduto().equals("")) {
			throw new CampoVazioException("A quantidade deste produto está vazia, favor preencher");
		}

	}

	/**
	 * insere um produto na pessistencia
	 * 
	 * @param p
	 *            recebe uma instanci de produto
	 * @throws ConexaoException
	 *             trata o erro de conexao com o banco de dados
	 */
	public void inserirProduto(Produto p) throws ConexaoException {
		IPP.inserirProduto(p);
	}

	/**
	 * altera os valores de um produto inserido
	 * 
	 * @param p
	 *            recebe uma instancia de Produto
	 * @throws ConexaoException
	 *             trata o erro de conexao com o banco de dados
	 */
	public void alterar(Produto p) throws ConexaoException {
		IPP.alterarProduto(p);
	}

	/**
	 * exclui todas as informações de um produto cadastrado
	 * 
	 * @param IDProduto
	 *            recebe o ID do produto que sera removido
	 * @throws ConexaoException
	 *             trata o erro de conexao com o banco de dados
	 */
	public void deletarProduto(Integer IDProduto) throws ConexaoException {
		IPP.deletarProduto(IDProduto);
	}

	/**
	 * lista todos os produtos cadastrados
	 * 
	 * @return uma lista com todos os produtos cadastrados
	 * @throws ConexaoException
	 *             trata o erro de conexao com o banco de dados
	 */
	public ArrayList<Produto> getListaProduto() throws ConexaoException {
		return IPP.getListaProduto();
	}

	/**
	 * lista as informações de um produto especifico
	 * 
	 * @param IDProduto
	 *            recebe o ID do produto que sera listado
	 * @return as informações do produto que contem o ID que foi passado como
	 *         parametro
	 * @throws ConexaoException
	 *             trata o erro de conexao com o banco de dados
	 */
	public Produto getProduto(Integer IDProduto) throws ConexaoException {
		return IPP.getProduto(IDProduto);
	}

	/**
	 * lista todos os produtos cadastrados referentes a um fornecedor especifico
	 * 
	 * @param idFornecedor
	 *            recebe um ID de um fornecedor ja cadastrado
	 * @return todos os produtos cadastrados com um fornecedor especifico
	 * @throws ConexaoException
	 *             trata o erro de conexao com o banco de dados
	 */
	public ArrayList<Produto> getListaProdutoFornecedor(int idFornecedor) throws ConexaoException {
		return IPP.getListaProdutoFornecedor(idFornecedor);
	}
}
