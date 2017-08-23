/**
 * Classe que ordena item pela quantidade
 * de emprestimos
 * */

package ordenadores;

import java.util.Comparator;

import itens.Item;

public class OrdemPorQuantidadeEmprestimosComparator implements Comparator<Item> {

	/**
	 * Compara a quantidade que dois itens foram
	 * emprestados
	 * 
	 * @param item Um item a ser comparado
	 * @param item Um item a ser comparado
	 * 
	 * @return Maior quantidade de emprestimos realizados
	 * */
	@Override
	public int compare(Item item1, Item item2) {
		return (item2.getQuantidadeEmprestimos() - item1.getQuantidadeEmprestimos());
	}

}
