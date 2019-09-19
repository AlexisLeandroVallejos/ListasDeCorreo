package modeloObservador;

public class Mensaje {
	private String email;
	private String titulo;
	private String texto;
	
	public Mensaje(String email, String titulo, String texto) {
		this.email = email;
		this.titulo = titulo;
		this.texto = texto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
