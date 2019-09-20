package modeloObservador;

import java.util.ArrayList;
import java.util.List;

public class UsuarioConcreto implements Usuario {
	
	private List<String> emails = new ArrayList<String>();
	private String emailPrincipal;
	private Mensaje mensaje;
	private int contadorDeSpam = 0;

	public UsuarioConcreto(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}
	
	@Override
	public void actualizar(Mensaje mensaje) {
		if(contadorDeSpam < 5 && mensaje.isPermitidoSinSpam()) {
			this.mensaje = mensaje;
			contadorDeSpam++;
		}
		
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public int getContador() {
		return contadorDeSpam;
	}

	public void setContador(int contador) {
		this.contadorDeSpam = contador;
	}

}
