package Excecoes;

import java.sql.SQLException;

public class CnpjInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CnpjInvalidoException() {

	}

	public CnpjInvalidoException(SQLException e) {
		super(e);
	}
}
