/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dados.IPersistenciaVenda;
import Excecoes.ConexaoException;
import FabricaConexao.FabricaConexao;
import FabricaConexao.IFabricaConexao;
import Negocio.ClassesBasicas.ListaVenda;
import Negocio.ClassesBasicas.ListaVendaProduto;
import Negocio.ClassesBasicas.Venda;

/**
 *
 * @author Júnior
 */
public class PersistenciaVenda implements IPersistenciaVenda {

	public IFabricaConexao f;

	public PersistenciaVenda() {
		f = FabricaConexao.getInstancia();
	}

	/**
	 * Cadastra a venda no banco de dados
	 * 
	 * @param v
	 *            Objeto contendo os dados da venda
	 * @return retorna um venda a partir do seu ID
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public int InserirVenda(Venda v) throws ConexaoException {
		int IDVenda = 0;
		try {
			Connection c = f.conectar();

			String sql = "INSERT INTO Venda (IDFuncionario, IDCliente, ValorTotal) VALUES (?,?,?)";

			try {
				PreparedStatement pstm = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				pstm.setInt(1, v.getIDFuncionario());
				pstm.setInt(2, v.getIDCliente());
				pstm.setDouble(3, v.getValorTotal());
				pstm.executeUpdate();

				ResultSet rs = pstm.getGeneratedKeys();
				if (rs.next()) {
					IDVenda = rs.getInt(1);
				}
			} catch (SQLException e) {
				throw new ConexaoException(e);
			} finally {
				f.desconectar(c);
			}
		} catch (ConexaoException ex) {
			throw new ConexaoException(ex);
		}

		return IDVenda;
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

	@Override
	public void InserirVendaProduto(int IDVenda, int IDProduto, int Quantidade, double ValorProdutos)
			throws ConexaoException {
		try {
			Connection c = f.conectar();
			try {
				String sqlInsert = "INSERT INTO VendaProduto (IDVenda, IDProduto, Quantidade, ValorProdutos) VALUES (?,?,?,?)";
				PreparedStatement pstm = c.prepareStatement(sqlInsert);
				pstm.setInt(1, IDVenda);
				pstm.setInt(2, IDProduto);
				pstm.setInt(3, Quantidade);
				pstm.setDouble(4, ValorProdutos);
				pstm.executeUpdate();

				String sqlUpdate = "UPDATE Produto SET Quantidade = Quantidade - ? WHERE ID = ?";
				PreparedStatement pstm2 = c.prepareStatement(sqlUpdate);
				pstm2.setInt(1, Quantidade);
				pstm2.setInt(2, IDProduto);
				pstm2.executeUpdate();

			} catch (SQLException e) {
				throw new ConexaoException(e);
			} finally {
				f.desconectar(c);
			}
		} catch (ConexaoException e) {
			throw new ConexaoException(e);
		}
	}

	/**
	 * Arraylist de todas as vendas realizadas
	 * 
	 * @return Retorna uma lista com todos os dados das vendas
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 * @throws SQLException
	 *             Trata o erro de conexão com o banco de dados
	 */
	@Override
	public ArrayList<ListaVenda> listarVenda() throws ConexaoException, SQLException {
		Connection c = f.conectar();
		ArrayList<ListaVenda> lista = new ArrayList<>();

		String sql = "SELECT IDVenda, C.Nome AS NomeCliente, F.Nome AS NomeFuncionario, valorTotal FROM Venda V "
				+ "INNER JOIN Cliente C ON V.IDCliente = C.ID " + "INNER JOIN Funcionario F ON V.IDFuncionario = F.ID";

		try {
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				ListaVenda lv = new ListaVenda(rs.getInt("IDVenda"), rs.getString("NomeCliente"),
						rs.getString("NomeFuncionario"), rs.getDouble("valorTotal"));
				lista.add(lv);
			}
			return lista;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			f.desconectar(c);
		}
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

	@Override
	public ArrayList<ListaVendaProduto> ListarVendaProduto(int ID) throws ConexaoException {
		ArrayList<ListaVendaProduto> listaVendaProduto = new ArrayList<>();

		FabricaConexao con = FabricaConexao.getInstancia();
		Connection conexao = null;
		try {
			conexao = con.conectar();
			Statement st = conexao.createStatement();
			String query = "SELECT P.DESCRICAO, VP.quantidade, VP.ValorProdutos" + " FROM VENDAPRODUTO AS VP "
					+ "LEFT JOIN PRODUTO AS P ON VP.IDPRODUTO = P.ID " + " WHERE VP.IDVENDA = " + ID;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ListaVendaProduto ListVenda = new ListaVendaProduto(rs.getString("P.DESCRICAO"),
						rs.getInt("VP.quantidade"), rs.getDouble("VP.ValorProdutos"));
				listaVendaProduto.add(ListVenda);
			}

		} catch (SQLException e) {
			throw new ConexaoException();
		} finally {
			if (conexao != null) {
				try {
					con.desconectar(conexao);
				} catch (ConexaoException ex) {
					throw new ConexaoException();
				}
			}
		}
		return listaVendaProduto;
	}

}
