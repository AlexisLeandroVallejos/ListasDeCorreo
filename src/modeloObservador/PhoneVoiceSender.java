package modeloObservador;

public class PhoneVoiceSender extends Sender {
	
	private static final PhoneVoiceSender INSTANCIA = new PhoneVoiceSender();
	
	private PhoneVoiceSender() {};
	
	public static PhoneVoiceSender getInstancia() {
		return INSTANCIA;
	}
	

	@Override
	public void notificarUsuarios(Mensaje mensaje) {
		//no se usa aca.
	}

	@Override
	public void suscribir(Usuario usuarioObservador) {
		usuarios.add(usuarioObservador);
	}
	
	public void sendMessage(String telefono, String texto) {
		usuarios.forEach(usuario -> usuario.actualizar(new Mensaje(telefono, texto)));
	}

	

}
