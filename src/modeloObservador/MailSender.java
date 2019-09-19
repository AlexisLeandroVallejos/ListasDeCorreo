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
			if(mensajeContienePalabrasPeligrosas(mensaje)) {
				administrador.avisoDePalabra();
			}
			usuarios.forEach(usuario -> usuario.actualizar(mensaje));
		}
	}

	public boolean mensajeContienePalabrasPeligrosas(Mensaje mensaje) {
		return mensaje.getTexto().contains(filtroDePalabras.stream().toString());
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
