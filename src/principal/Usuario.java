package principal;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	
	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getInfoUsuario(String atributo) {
		if ("email".equals(atributo.toLowerCase())) {
			return this.email;
		}
		else if ("telefone".equals(atributo.toLowerCase())) {
			return this.telefone;
		}
		else if ("nome".equals(atributo.toLowerCase())) {
			return this.nome;
		}
		return "Usuario não cadastrado";
	}
	
	public void atualizarDados(String atributo, String valor) {
		if ("email".equals(atributo.toLowerCase())) {
			setEmail(valor);
		}
		else if ("telefone".equals(atributo.toLowerCase())) {
			setTelefone(valor);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
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
