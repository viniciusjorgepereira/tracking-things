/**
 * Classe que implementa a interface de ordenacao
 * por nome
 * */

package ordenadores;

import java.util.Comparator;

import itens.Item;

public class OrdemAlfabeticaComparator implements Comparator<Item> {

	/**
	 * Ordena itens por nome
	 * 
	 * @param iten1 Item para comparacao
	 * @param iten2 Outro item do mesmo tipo para comparacao
	 * */
	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}
}
