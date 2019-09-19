package modeloObservador;

public interface ListaDeCorreo {
	
	public void notificarUsuarios();
	public void suscribir(Usuario usuarioObservador);
	public Mensaje getMensaje();

}
