/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.RegrasNegocio;

import java.sql.SQLException;
import java.util.ArrayList;

import Dados.IPersistenciaVenda;
import Dados.Dao.PersistenciaVenda;
import Excecoes.CampoVazioException;
import Excecoes.ConexaoException;
import Excecoes.GeralException;
import Negocio.ClassesBasicas.ListaVenda;
import Negocio.ClassesBasicas.ListaVendaProduto;
import Negocio.ClassesBasicas.Venda;

public class ControladorVenda {

	IPersistenciaVenda persistenciaVenda = new PersistenciaVenda();

	/**
	 * Cadastra a venda no banco de dados
	 * 
	 * @param v
	 *            Objeto contendo os dados da venda
	 * @return Insere um venda no banco
	 * @throws CampoVazioException
	 *             Trata o erro de campo vazio
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	public int InserirVenda(Venda v) throws CampoVazioException, ConexaoException {
		if (v.getValorTotal() == 0) {
			throw new CampoVazioException("Selecione produtos para a venda");
		} else {
			return persistenciaVenda.InserirVenda(v);
		}

	}

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
			throws ConexaoException {
		persistenciaVenda.InserirVendaProduto(IDVenda, IDProduto, Quantidade, ValorProdutos);
	}

	/**
	 * Arraylist de todas as vendas realizadas
	 * 
	 * @return Retorna uma lista com todos os dados das vendas
	 * @throws GeralException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws SQLException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public ArrayList<ListaVenda> listarVenda() throws GeralException, ConexaoException, SQLException {
		return persistenciaVenda.listarVenda();
	}

	/**
	 * ArrayList com os dados complementares de um produto (Descrição, Quantidade)
	 * 
	 * @param ID
	 *            Identifica uma venda a partir do ID
	 * @return retorna um lista com todos os produtos por venda
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */
	public ArrayList<ListaVendaProduto> ListarVendaProduto(int ID) throws ConexaoException {
		return persistenciaVenda.ListarVendaProduto(ID);
	}

}
