package FabricaConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Excecoes.ConexaoException;

public class FabricaConexao implements IFabricaConexao {

	private static FabricaConexao instancia;
//	private final String driver;
	private final String url;
	private final String usu;
	private final String sen;

	private FabricaConexao() {
		ResourceBundle rb = ResourceBundle.getBundle("FabricaConexao.InfoBanco");
//		driver = rb.getString("driver");
		url = rb.getString("url");
		usu = rb.getString("usuario");
		sen = rb.getString("senha");
	}

	public static FabricaConexao getInstancia() {
		if (instancia == null) {
			instancia = new FabricaConexao();
		}
		return instancia;
	}

	/**
	 * Estabelece uma conexao com o BD
	 * 
	 * @return A conexao ativa
	 * @throws ConexaoException
	 */
	@Override
	public Connection conectar() throws ConexaoException {
		try {
			Connection c = DriverManager.getConnection(url, usu, sen);
			return c;
		} catch (SQLException e) {
			throw new ConexaoException(e);
		}
	}

	/**
	 * Desconecta do BD
	 * 
	 * @param c
	 *            Um objeto de conexao ativo
	 * @throws ConexaoException
	 */
	@Override
	public void desconectar(Connection c) throws ConexaoException {
		try {
			c.close();
		} catch (SQLException e) {
			throw new ConexaoException(e);
		}
	}

}
