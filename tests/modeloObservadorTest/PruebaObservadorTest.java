package modeloObservadorTest;

import org.junit.Assert;
import org.junit.Test;

import modeloObservador.*;

public class PruebaObservadorTest {
	
	@Test
	public void actualizar_UnUsuarioRecibeActualizacionDeLaListaDeCorreos() {
		//creo clases
		UsuarioConcreto usuario = new UsuarioConcreto("tomatelas@yahoo.com");
		MailSender lista = new MailSender(false, false);
		Mensaje mensaje = new Mensaje("salideahi@gmail.com", "Torneo de pingpong", "Te paso la informacion del torneo para mañana");
		
		//envio mensaje.
		lista.suscribir(usuario);
		lista.notificarUsuarios(mensaje);
		Assert.assertEquals("No recibio actualizacion de la lista de correos", usuario.getMensaje(), mensaje);
	}

}
