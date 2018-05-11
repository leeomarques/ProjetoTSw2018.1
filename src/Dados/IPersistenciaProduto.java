/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.util.ArrayList;

import Excecoes.ConexaoException;
import Negocio.ClassesBasicas.Produto;

public interface IPersistenciaProduto {
	/**
	 * Cadastra um produto no banco de dados
	 * 
	 * @param p
	 *            Objeto com todos os dados de um produto
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public void inserirProduto(Produto p) throws ConexaoException;

	/**
	 * Altera os Dados do produto ja cadastrado
	 * 
	 * @param p
	 *            Objeto contendo todos os dados de um produto
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public void alterarProduto(Produto p) throws ConexaoException;

	/**
	 * Deleta um produto cadastrado do banco de dados
	 * 
	 * @param IDProduto
	 *            Identifica o produto no registro do banco
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public void deletarProduto(int IDProduto) throws ConexaoException;

	/**
	 * Seleciona a partir de um ArrayList todos os dados de um produto junto com o
	 * seu fornecedor
	 * 
	 * @return Retorna os dados do produto a partir de um fornecedor
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public ArrayList<Produto> getListaProduto() throws ConexaoException;

	/**
	 * Retorna todos os dados do Produto
	 * 
	 * @param IDProduto
	 *            Identifica o Produto a partir do seu IDProduto
	 * @return Retorna todos os dados de Produto a partir do seu IDProduto e do
	 *         IDFornecedor
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public Produto getProduto(int IDProduto) throws ConexaoException;

	/**
	 * Seleciona a partir de um ArrayList todos os dados de um produto a partir de
	 * um fornecedor
	 * 
	 * @param idFornecedor
	 *            Identifica o Fornecedor cadastrado no banco
	 * @return Retorna uma lista com os dados do produto a partir de um fornecedor
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public ArrayList<Produto> getListaProdutoFornecedor(int idFornecedor) throws ConexaoException;
}
