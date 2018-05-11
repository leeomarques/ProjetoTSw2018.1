package Excecoes;

import java.sql.SQLException;

public class CampoVazioException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String mensagem;

	public CampoVazioException() {

	}

	public CampoVazioException(SQLException e) {
		super(e);
	}

	public CampoVazioException(String e) {
		this.mensagem = e;
	}
}
