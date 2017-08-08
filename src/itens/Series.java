package itens;

import java.util.ArrayList;
import java.util.List;

public class Series extends Bluray{
	
	private int episodios;
	private Genero genero;
	private String descricao;
	private int numTemporadas;
	
	public Series(String nome, double preco, int duracao, String descricao, String classificacao, String genero, int temporada) {
		super(nome, preco, duracao, classificacao);
		this.descricao = descricao;
		this.numTemporadas = temporada;
		this.genero = Genero.valueOf(genero);
	}

	public void adicionarTemporada(int duracao) {
		this.episodios += 1;
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
	
	@Override
	public String toString() {
		return "SERIE: " + nome + ", R$ " + super.getPrecoString() + ", " + super.getStatusString() + ", " + duracao + 
				" min, " + classInd + ", " + genero.getValor() + ", Temporada " + numTemporadas;
	}
}
