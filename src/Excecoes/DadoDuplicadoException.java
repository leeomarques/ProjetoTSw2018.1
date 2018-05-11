
package Excecoes;

public class DadoDuplicadoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DadoDuplicadoException() {
		super();
	}

	public DadoDuplicadoException(Exception e) {
		super(e);
	}

	public DadoDuplicadoException(String e) {
		super(e);
	}

}
