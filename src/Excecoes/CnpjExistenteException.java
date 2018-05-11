package Excecoes;

import java.sql.SQLException;

public class CnpjExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CnpjExistenteException() {

	}

	public CnpjExistenteException(SQLException e) {
		super(e);
	}
}
