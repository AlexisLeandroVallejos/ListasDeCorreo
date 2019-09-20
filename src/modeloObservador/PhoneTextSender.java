package modeloObservador;

public class PhoneTextSender extends Sender {
	
	private PhoneTextSender() {};
	
	private static class PhoneTextSenderHolder {
		private static final PhoneTextSender INSTANCIA = new PhoneTextSender();
	}
	
	public static PhoneTextSender getInstancia() {
		return PhoneTextSenderHolder.INSTANCIA;
	}
	
	@Override
	public void notificarUsuarios(Mensaje mensaje) {
		//esto es de mail no se usa.
	}
	
	@Override
	public void suscribir(Usuario usuarioObservador) {
		usuarios.add(usuarioObservador);
	}

	@Override
	public void sendMessage(String telefono, String texto) {
		super.notificarUsuarios(new Mensaje(telefono, texto));
		usuarios.forEach(usuario -> usuario.actualizar(new Mensaje(telefono, texto)));
	}

	

}
