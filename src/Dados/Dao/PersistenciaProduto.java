package Dados.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dados.IPersistenciaProduto;
import Excecoes.ConexaoException;
import FabricaConexao.FabricaConexao;
import Negocio.ClassesBasicas.Produto;

public class PersistenciaProduto implements IPersistenciaProduto {

	private final FabricaConexao fc;

	public PersistenciaProduto() {
		fc = FabricaConexao.getInstancia();
	}

	/**
	 * Cadastra um produto no banco de dados
	 * 
	 * @param p
	 *            Objeto com todos os dados de um produto
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public void inserirProduto(Produto p) throws ConexaoException {
		Connection c = fc.conectar();
		String sql = "INSERT INTO Produto (descricao, valorProduto, quantidade,idFornecedor) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, p.getDescricaoProduto());
			pstm.setDouble(2, p.getValorProduto());
			pstm.setString(3, p.getQuantidadeProduto());
			pstm.setInt(4, p.getIdFornecedorProduto());

			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}

	}

	/**
	 * Altera os Dados do produto ja cadastrado
	 * 
	 * @param p
	 *            Objeto contendo todos os dados de um produto
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public void alterarProduto(Produto p) throws ConexaoException {
		Connection c = fc.conectar();
		String sql = "UPDATE Produto SET descricao=?, valorProduto=?, quantidade=?, idFornecedor=? WHERE id=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, p.getDescricaoProduto());
			pstm.setDouble(2, p.getValorProduto());
			pstm.setString(3, p.getQuantidadeProduto());
			pstm.setInt(4, p.getIdFornecedorProduto());
			pstm.setInt(5, p.getIdProduto());
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

	/**
	 * Deleta um produto cadastrado do banco de dados
	 * 
	 * @param IDProduto
	 *            Identifica o produto no registro do banco
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public void deletarProduto(int IDProduto) throws ConexaoException {
		Connection c = fc.conectar();
		String sql = "DELETE FROM Produto WHERE id=?";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, IDProduto);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

	/**
	 * Seleciona a partir de um ArrayList todos os dados de um produto junto com o
	 * seu fornecedor
	 * 
	 * @return Retorna os dados do produto a partir de um fornecedor
	 * @throws ConexaoException
	 *             Trata o erro de conexão com o banco de dados
	 */

	@Override
	public ArrayList<Produto> getListaProduto() throws ConexaoException {
		Connection c = fc.conectar();
		ArrayList<Produto> lista = new ArrayList<>();

		String sql = "SELECT p.id, f.id as idFornecedor, f.nomeFantasia, p.descricao, p.valorProduto, p.quantidade FROM Produto as p inner join fornecedor as f on f.id = p.idFornecedor";

		try {
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Produto p = new Produto();
				p.setIdProduto(rs.getInt("id"));
				p.setIdFornecedorProduto(rs.getInt("idFornecedor"));
				p.setNomeFornecedor(rs.getString("nomeFantasia"));
				p.setDescricaoProduto(rs.getString("descricao"));
				p.setValorProduto(rs.getDouble("valorProduto"));
				p.setQuantidadeProduto(rs.getString("quantidade"));
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

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

	@Override
	public Produto getProduto(int IDProduto) throws ConexaoException {
		Connection c = fc.conectar();
		Produto p = null;

		String sql = "SELECT id, idFornecedor, descricao, valorProduto, quantidade FROM Produto WHERE id=?";

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, IDProduto);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				p = new Produto();

				p.setIdProduto(rs.getInt("id"));
				p.setIdFornecedorProduto(rs.getInt("idFornecedor"));
				p.setDescricaoProduto(rs.getString("descricao"));
				p.setValorProduto(rs.getDouble("valorProduto"));
				p.setQuantidadeProduto(rs.getString("quantidade"));

			}
			return p;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}

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

	public ArrayList<Produto> getListaProdutoFornecedor(int idFornecedor) throws ConexaoException {
		Connection c = fc.conectar();
		ArrayList<Produto> lista = new ArrayList<>();

		String sql = "SELECT p.id, p.descricao, p.valorProduto, p.quantidade FROM Produto as p where idFornecedor = ?";

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setInt(1, idFornecedor);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();
				p.setIdProduto(rs.getInt("id"));
				p.setDescricaoProduto(rs.getString("descricao"));
				p.setValorProduto(rs.getDouble("valorProduto"));
				p.setQuantidadeProduto(rs.getString("quantidade"));
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		} finally {
			fc.desconectar(c);
		}
	}
}
