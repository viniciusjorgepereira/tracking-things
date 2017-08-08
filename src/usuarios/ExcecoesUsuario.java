/**
 * Classe que lança exceções para usuários inválidos
 * ou já cadastrados 
 * */

package usuarios;

public class ExcecoesUsuario {
	
	/**
	 * Lança exceção caso o usuário seja inválido
	 * 
	 * @param contem Informa se o usuário está contido ou não
	 * */
	public void usuarioInvalido(boolean contem) {
		if (!(contem)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}
	
	/**
	 * Lança exceção caso o usuário já esteja cadastrado
	 * 
	 * @param contem Informa se o usuário está contido ou não
	 * */
	public void usuarioJaCadastrado(boolean contem) {
		if (contem) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
	}
}
