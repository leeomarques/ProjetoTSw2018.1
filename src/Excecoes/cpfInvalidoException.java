package Excecoes;

import java.sql.SQLException;

public class cpfInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public cpfInvalidoException() {

	}

	public cpfInvalidoException(SQLException e) {
		super(e);
	}

	public cpfInvalidoException(cpfInvalidoException e) throws cpfInvalidoException {
		throw new cpfInvalidoException();
	}

	public cpfInvalidoException(String es) {

	}

}
