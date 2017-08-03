package usuarios;

public class ExcecoesUsuario {
	
	public void usuarioInvalido(boolean contem) {
		if (!(contem)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}
	
	public void usuarioJaCadastrado(boolean contem) {
		if (contem) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
	}
}
