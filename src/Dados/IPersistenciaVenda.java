/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.SQLException;
import java.util.ArrayList;

import Excecoes.ConexaoException;
import Negocio.ClassesBasicas.ListaVenda;
import Negocio.ClassesBasicas.ListaVendaProduto;
import Negocio.ClassesBasicas.Venda;

/**
 *
 * @author Júnior
 */
public interface IPersistenciaVenda {
	/**
	 * Cadastra a venda no banco de dados
	 * 
	 * @param v
	 *            Objeto contendo os dados da venda
	 * @return Insere um venda no banco
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public int InserirVenda(Venda v) throws ConexaoException;

	/**
	 * Insere os produtos selecionados na tabela Venda
	 * 
	 * @param IDVenda
	 *            Identifica a Venda
	 * @param IDProduto
	 *            Identifica o produto cadastrado no banco
	 * @param Quantidade
	 *            Identifica a quantidade do produto
	 * @param ValorProdutos
	 *            identifica os valores de cada produto
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public void InserirVendaProduto(int IDVenda, int IDProduto, int Quantidade, double ValorProdutos)
			throws ConexaoException;

	/**
	 * Arraylist de todas as vendas realizadas
	 * 
	 * @return Retorna uma lista com todos os dados das vendas
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws SQLException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public ArrayList<ListaVenda> listarVenda() throws ConexaoException, SQLException;

	/**
	 * ArrayList com os dados complementares de um produto (Descrição, Quantidade)
	 * 
	 * @param ID
	 *            Identifica uma venda a partir do ID
	 * @return retorna um lista com todos os produtos por venda
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public ArrayList<ListaVendaProduto> ListarVendaProduto(int ID) throws ConexaoException;

}
