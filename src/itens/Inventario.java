/**
 * Classe que armazena os itens, Capaz de armazenar,
 * adicionar, ordenar e listar um array de itens registrados
 * */

package itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Inventario {
	private List<Item> itensOrdenados;
	
	/**
	 * Constroi um inventario com um array vazio para todos os
	 * itens
	 * */
	public Inventario() {
		itensOrdenados = new ArrayList<>();
	}

	/**
	 * Metodo que adiciona itens no array.
	 * 
	 * @param todosItens Array com todos os itens registrados
	 * */
	public void adicionaItens(ArrayList<Item> todosItens) {
		itensOrdenados.clear();
		itensOrdenados.addAll(todosItens);
	}
	
	/**
	 * Metodo que ordena os itens por nome
	 * */
	public void ordenaNome() {
		Collections.sort(itensOrdenados, new OrdemAlfabeticaComparator());
	}
	
	/**
	 * Metodo que ordena os itens por valor
	 * */
	public void ordenaValor() {
		Collections.sort(itensOrdenados, new OrdemPorValorComparator());
	}
	
	/**
	 * Metodo que lista itens ordenados pelo nome
	 * 
	 * @return Uma String com as informacoes de todos os itens ordenados por nome
	 * */
	public String listarItensOrdenadosPorNome() {
		ordenaNome();
		return listaItensString();
	}
	
	/**
	 * Metodo que lista itens ordenados pelo valor
	 * 
	 * @return Uma String com as informacoes de todos os itens ordenados por valor
	 * */
	public String listarItensOrdenadosPorValor() {
		ordenaValor();
		return listaItensString();
	}
	
	/**
	 * Metodo que lista itens
	 * 
	 * @return Uma String com as informacoes de todos os itens
	 * */
	public String listaItensString() {
		String saida = "";
		for (Item item : itensOrdenados) {
			saida += item.toString() + "|";
		} 
		return saida;
	}
}
