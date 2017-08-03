package itens;

import java.util.ArrayList;
import java.util.List;

public class Series extends Bluray{

	private int duracao;
	private String genero;
	private String classInd;
	private String descricao;
	private int numTemporadas;
	private List<Bluray> colecao;
	
	public Series(String nome, double preco, int duracao, String descricao, String classificacao, String genero, int temporada) {
		super(nome, preco, duracao);
		this.genero = genero;
		this.descricao = descricao;
		this.classInd = classificacao;
		this.numTemporadas = temporada;
		this.colecao = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numTemporadas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Series other = (Series) obj;
		if (nome == null) {
			if (other.nome!= null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numTemporadas != other.numTemporadas)
			return false;
		return true;
	}		
}
