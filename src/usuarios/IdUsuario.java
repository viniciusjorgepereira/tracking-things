/**
 * Classe que representa o ID de cada usuario, composta pelo
 * nome e pelo numero de telefone
 * */

package usuarios;

import java.io.Serializable;

public class IdUsuario implements Serializable{
	
	private String nome;
	private String telefone;
	
	/**
	 * Constrói uma ID para o usuario
	 * 
	 * @param nome Indica o nome do usuario
	 * @param telefone Indica o telefone do usuario
	 * */

	public IdUsuario(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Metodo equals. Checka se o IdUsuario e igual ao
	 * outro se tiverem o mesmo nome e mesmo numero de
	 * telefone
	 * 
	 * @param obj Objeto a ser comparado
	 * 
	 * @return Retorna um boolean informando se e o mesmo ou nao
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdUsuario other = (IdUsuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}
