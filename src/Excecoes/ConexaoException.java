package Excecoes;

import java.sql.SQLException;

public class ConexaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConexaoException() {

	}

	public ConexaoException(SQLException e) {
		super(e);
	}

	public ConexaoException(ConexaoException e) throws ConexaoException {
		throw new ConexaoException();
	}
}
