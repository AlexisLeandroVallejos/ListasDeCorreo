package modeloObservador;

import exceptions.ListaDeCorreoCerradaException;

public class MailSender extends Sender {
	
	private boolean listaEsRestringida;
	private boolean suscripcionEsRestringida;
	
	public MailSender(boolean listaEsRestringida, boolean suscripcionEsRestringida) {
		this.listaEsRestringida = listaEsRestringida;
		this.suscripcionEsRestringida = suscripcionEsRestringida;
	}
	
	@Override
	public void notificarUsuarios(Mensaje mensaje) {
		if(listaEsRestringida) {
			throw new ListaDeCorreoCerradaException();
		}
		if(!listaEsRestringida) {
			super.notificarUsuarios(mensaje);
			usuarios.forEach(usuario -> usuario.actualizar(mensaje));
		}
	}

	@Override
	public void suscribir(Usuario usuarioObservador) {
		if(!usuarios.contains(usuarioObservador) && !listaEsRestringida) {
			usuarios.add(usuarioObservador);
		}
		if(!usuarios.contains(usuarioObservador) && listaEsRestringida) {
			administrador.tramitarSuscripcion(usuarioObservador);
		}
	}
	
	@Override
	public void sendMessage(String telefono, String texto) {
		//No se usa aca.
	}

	public boolean isEsRestringido() {
		return listaEsRestringida;
	}

	public void setEsRestringido(boolean esRestringido) {
		this.listaEsRestringida = esRestringido;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public boolean isSuscripcionEsRestringida() {
		return suscripcionEsRestringida;
	}

	public void setSuscripcionEsRestringida(boolean suscripcionEsRestringida) {
		this.suscripcionEsRestringida = suscripcionEsRestringida;
	}

}
