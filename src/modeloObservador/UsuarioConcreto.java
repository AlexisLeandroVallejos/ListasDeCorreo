package modeloObservador;

import java.util.ArrayList;
import java.util.List;

public class UsuarioConcreto implements Usuario {
	
	private List<String> emails = new ArrayList<String>();
	private String emailPrincipal;
	private Mensaje mensaje;
	private int contador = 0;

	public UsuarioConcreto(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}
	
	@Override
	public void actualizar(Mensaje mensaje) {
		this.mensaje = mensaje;
		contador++;
	}
	
	public Mensaje getMensaje() {
		return mensaje;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

}
