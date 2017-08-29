/**
 * Classe que lança excecoes para usurios invalidos
 * ou ja cadastrados 
 * */

package usuarios;

import java.io.Serializable;

public class ExcecoesUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Lança excecao caso o usuario seja invalido
	 * 
	 * @param contem Informa se o usuario está contido ou não
	 * */
	public void usuarioInvalido(boolean contem) {
		if (!(contem)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}
	
	/**
	 * Lança exceção caso o usuario ja esteja cadastrado
	 * 
	 * @param contem Informa se o usuário esta contido ou não
	 * */
	public void usuarioJaCadastrado(boolean contem) {
		if (contem) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
	}
}
