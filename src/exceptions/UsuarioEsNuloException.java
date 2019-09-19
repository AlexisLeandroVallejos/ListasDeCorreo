package exceptions;

public class UsuarioEsNuloException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioEsNuloException() {
		super("El usuario ingresado es nulo.");
	}
}
