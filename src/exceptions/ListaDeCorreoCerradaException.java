package exceptions;

public class ListaDeCorreoCerradaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListaDeCorreoCerradaException() {
		super("La lista esta cerrada. Solo administradores agregados a ella pueden enviar mensajes.");
	}
}
