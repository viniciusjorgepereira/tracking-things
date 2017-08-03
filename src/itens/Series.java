package itens;

import java.util.ArrayList;
import java.util.List;

public class Series extends Bluray{

	private int duracao;
	private String descricao;
	private String classInd;
	private String genero;
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
}
