/**
 * Classe que armazena os itens, Capaz de armazenar,
 * adicionar, ordenar e listar um array de itens registrados
 * */

package ordenadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import itens.Item;


public class OrdenadorDeItens {
	private List<Item> itensOrdenados;
	
	/**
	 * Constroi um inventario com um array vazio para todos os
	 * itens
	 * */
	public OrdenadorDeItens() {
		itensOrdenados = new ArrayList<>();
	}

	/**
	 * Metodo que adiciona itens no array.
	 * 
	 * @param todosItens Array com todos os itens registrados
	 * */
	public void adicionaItens(List<Item> todosItens) {
		itensOrdenados = new ArrayList<>(todosItens);
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

	/**
	 * Metodo que invoca um outro que lista itens ordenados
	 * pela quantidade de emprestimos
	 * 
	 * @return Uma string com as informacoes dos emprestimos ordenados
	 * */
	public String listarItensOrdenadosPorQuantidadeEmprestimos() {
		ordenaQuantidadeEmprestimos();
		return listaItensQuantidadeEmprestimosString();
	}

	/**
	 * Metodo que lista itens ordenados pela quantidade
	 * de emprestimos
	 * 
	 * @return Uma string com as informacoes dos emprestimos ordenados
	 * */
	private String listaItensQuantidadeEmprestimosString() {
		String saida = "";
		int posicao = 1;
		for (Item item : itensOrdenados) {
			if (item.getQuantidadeEmprestimos() > 0) {
				saida += posicao + ") " + item.getQuantidadeEmprestimos() + " emprestimos - " + item.toString() + "|";
				posicao++;
			}
		} 
		return saida;
	}

	/**
	 * Metodo que invoca um outro para ordenar Emprestimos
	 * pela quantidade de vezes que foram emprestados
	 * */
	private void ordenaQuantidadeEmprestimos() {
		Collections.sort(itensOrdenados, new OrdemPorQuantidadeEmprestimosComparator());
		
	}
}
