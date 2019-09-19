package modeloObservador;

import java.util.ArrayList;
import java.util.List;

import exceptions.UsuarioEsNuloException;

public class ListaDeCorreoConcreto implements ListaDeCorreo {
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Mensaje mensaje;
	private boolean esRestringido = false;
	
	@Override
	public void notificarUsuarios() {
		usuarios.forEach(usuario -> usuario.actualizar());
	}

	@Override
	public void suscribir(Usuario usuarioObservador) {
		if(usuarioObservador == null) {
			throw new UsuarioEsNuloException();
		}
		if(!usuarios.contains(usuarioObservador)) {
			usuarios.add(usuarioObservador);
		}
	}
	
	@Override
	public Mensaje getMensaje() {
		return mensaje;
	}

	public void enviarMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
		this.esRestringido = true;
		notificarUsuarios();
	}

	

	

	


}
