package Excecoes;

import java.sql.SQLException;

public class GeralException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeralException() {

	}

	public GeralException(String e) {

	}

	public GeralException(SQLException e) {
		super(e);
	}

	public GeralException(GeralException e) throws GeralException {
		throw new GeralException();
	}

}
