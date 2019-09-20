package modeloObservadorTest;

import org.junit.Assert;
import org.junit.Test;

import modeloObservador.*;

public class PruebaObservadorTest {
	
	@Test
	public void actualizar_UnUsuarioRecibeActualizacionDelMailSender() {
		//creo clases
		UsuarioConcreto usuario = new UsuarioConcreto("tomatelas@yahoo.com");
		MailSender lista = new MailSender(false, false);
		Mensaje mensaje = new Mensaje("salideahi@gmail.com", "Torneo de pingpong", "Te paso la informacion del torneo para mañana");
		
		//envio mensaje.
		lista.suscribir(usuario);
		lista.notificarUsuarios(mensaje);
		Assert.assertEquals("No recibio actualizacion de la lista de correos", usuario.getMensaje(), mensaje);
	}
	
	@Test
	public void actualizar_UnUsuarioRecibeActualizacionDelPhoneTextSender() {
		//creo clases
		UsuarioConcreto usuario = new UsuarioConcreto("tomatelas@yahoo.com");
		Mensaje mensaje = new Mensaje("23456789", "Te paso la informacion del torneo para mañana");
		
		//envio mensaje.
		PhoneTextSender.getInstancia().suscribir(usuario);
		PhoneTextSender.getInstancia().sendMessage(mensaje.getEmail(), mensaje.getTexto());
		Assert.assertTrue("No recibio actualizacion de la lista de correos", usuario.getMensaje().getEmail() == mensaje.getEmail() && usuario.getMensaje().getTexto() == mensaje.getTexto());
	}
	
	@Test
	public void actualizar_UnUsuarioRecibeActualizacionDelPhoneVoiceSender() {
		//creo clases
		UsuarioConcreto usuario = new UsuarioConcreto("tomatelas@yahoo.com");
		Mensaje mensaje = new Mensaje("98765432", "Te paso la informacion del torneo para mañana".toUpperCase());
		
		//envio mensaje.
		PhoneVoiceSender.getInstancia().suscribir(usuario);
		PhoneVoiceSender.getInstancia().sendMessage(mensaje.getEmail(), mensaje.getTexto());
		Assert.assertTrue("No recibio actualizacion de la lista de correos", usuario.getMensaje().getEmail() == mensaje.getEmail() && usuario.getMensaje().getTexto() == mensaje.getTexto());
	}
	
	@Test
	public void actualizar_UnUsuarioNoRecibeActualizacionSiSpamea() {
		//creo clases
		UsuarioConcreto usuario = new UsuarioConcreto("tomatelas@yahoo.com");
		MailSender lista = new MailSender(false, false);
		Mensaje mensaje = new Mensaje("salideahi@gmail.com", "Torneo de pingpong", "Te paso la informacion del torneo para mañana");
		
		//envio mensaje.
		lista.suscribir(usuario);
		lista.notificarUsuarios(mensaje);
		lista.notificarUsuarios(mensaje);
		lista.notificarUsuarios(mensaje);
		lista.notificarUsuarios(mensaje);
		lista.notificarUsuarios(mensaje);
		
		//envio nuevo mensaje
		Mensaje mensaje2 = new Mensaje("salideahi@gmail.com", "Torneo de pingpong", "Esquina Av.Rivadavia y Entre Rios");
		lista.notificarUsuarios(mensaje2);
		Assert.assertNotEquals("No recibio actualizacion de la lista de correos", usuario.getMensaje(), mensaje2);
	}

}
