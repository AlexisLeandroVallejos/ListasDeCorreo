package modeloObservador;

public class Mensaje {
	private final String email;
	private final String titulo;
	private final String texto;
	private boolean permitidoSinSpam = true;
	
	public Mensaje(String telefono, String texto) {
		this.email = telefono;
		this.texto = texto;
		this.titulo = null;
	}
	
	public Mensaje(String email, String titulo, String texto) {
		this.email = email;
		this.titulo = titulo;
		this.texto = texto;
	}

	public String getEmail() {
		return email;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

	public boolean isPermitidoSinSpam() {
		return permitidoSinSpam;
	}

	public void setPermitidoSinSpam(boolean permitidoSinSpam) {
		this.permitidoSinSpam = permitidoSinSpam;
	}
}
