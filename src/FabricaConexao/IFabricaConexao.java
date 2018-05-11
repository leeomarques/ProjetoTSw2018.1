package FabricaConexao;

import java.sql.Connection;

import Excecoes.ConexaoException;

public interface IFabricaConexao {

	/**
	 * Estabelece uma conexao com o BD
	 * 
	 * @return A conexao ativa
	 * @throws ConexaoException
	 */
	public Connection conectar() throws ConexaoException;

	/**
	 * Desconecta do BD
	 * 
	 * @param c
	 *            Um objeto de conexao ativo
	 * @throws ConexaoException
	 */
	public void desconectar(Connection c) throws ConexaoException;

}
