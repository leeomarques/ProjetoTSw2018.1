package Excecoes;

import java.sql.SQLException;

public class cpfExistenteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public cpfExistenteException() {

	}

	public cpfExistenteException(String e) {

	}

	public cpfExistenteException(SQLException e) {

		super(e);
	}

	public cpfExistenteException(cpfExistenteException e) throws cpfExistenteException {
		throw new cpfExistenteException();

	}
}
