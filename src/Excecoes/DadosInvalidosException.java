
package Excecoes;

public class DadosInvalidosException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DadosInvalidosException() {
		super();
	}

	public DadosInvalidosException(Exception e) {
		super(e);
	}

	public DadosInvalidosException(String e) {
		super(e);
	}
}
