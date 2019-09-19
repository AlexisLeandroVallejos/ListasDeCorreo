package modeloObservador;

import java.util.ArrayList;
import java.util.List;

public abstract class Sender {
	
	protected Administrador administrador;
	protected List<Usuario> usuarios = new ArrayList<Usuario>();
	protected List<String> filtroDePalabras = new ArrayList<String>();
	
	public abstract void notificarUsuarios(Mensaje mensaje);
	public abstract void suscribir(Usuario usuarioObservador);
	public abstract void sendMessage(String telefono, String texto);
	
	public void agregarPalabra(String palabra) {
		filtroDePalabras.add(palabra);
	}
	
	public void quitarPalabra(String palabra) {
		filtroDePalabras.remove(palabra);
	}

}
