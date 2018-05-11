package Excecoes;

import java.sql.SQLException;

public class FuncionarioExistenteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FuncionarioExistenteException() {

	}

	public FuncionarioExistenteException(SQLException e) {
		super(e);
	}

	public FuncionarioExistenteException(FuncionarioExistenteException e) throws FuncionarioExistenteException {
		throw new FuncionarioExistenteException();
	}

}
