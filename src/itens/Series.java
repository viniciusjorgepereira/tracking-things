package itens;

import java.util.ArrayList;
import java.util.List;

public class Series extends Bluray{

	private int duracao;
	private int numTemporadas;
	private List<Bluray> colecao;
	
	public Series(String nome, int duracao, double valor) {
		super(nome, duracao, valor);
		this.colecao = new ArrayList<>();
	}
	
	

}
