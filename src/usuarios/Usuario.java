package usuarios;

import java.util.ArrayList;
import java.util.List;

import itens.Filmes;
import itens.Itens;
import itens.Series;
import itens.Shows;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private List<Itens> itens;

	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.itens = new ArrayList<>();
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

	public String getTelefone() {
		return telefone;
	}

	public String getInfoUsuario(String atributo) {
		String saida = "";
		if ("email".equals(atributo.toLowerCase())) {
			saida += this.email;
		} else if ("telefone".equals(atributo.toLowerCase())) {
			saida += this.telefone;
		} else if ("nome".equals(atributo.toLowerCase())) {
			saida += this.nome;
		}
		return saida;
	}

	public void atualizarDadosUsuario(String atributo, String valor) {
		if ("email".equals(atributo.toLowerCase())) {
			this.email = valor;
		} else if ("telefone".equals(atributo.toLowerCase())) {
			this.telefone = valor;
		}
	}

	public void atualizarDadosItens(String atributo, String valor) {
		
	}
	
	
	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, int lancamento, String genero,
			String classind) {
		itens.add(new Filmes(nomeItem, preco, duracao, genero, lancamento));
	}

	public void cadastrarBluraySerie(String nomeItem, double preco, String descricao, int duracao, String classInd,
			String genero, int temporada) {
		itens.add(new Series(nomeItem, preco, duracao, descricao, classInd, genero, temporada));
	}

	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int faixas, String artista,
			String classInd) {
		itens.add(new Shows(nomeItem, preco, duracao, faixas, artista, classInd));
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
