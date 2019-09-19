package modeloObservador;

import java.util.ArrayList;
import java.util.List;

public class UsuarioConcreto implements Usuario {
	
	private List<String> emails = new ArrayList<String>();
	private String emailPrincipal;
	private ListaDeCorreo listaDeCorreo;
	
	public UsuarioConcreto(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}
	
	@Override
	public Mensaje actualizar() {
		return listaDeCorreo.getMensaje();
	}

	@Override
	public void setListaDeCorreo(ListaDeCorreo lista) {
		this.listaDeCorreo = lista;
	}

}
