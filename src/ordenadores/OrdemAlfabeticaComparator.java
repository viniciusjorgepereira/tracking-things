/**
 * Classe que implementa a interface de ordenacao
 * por nome do item
 * */

package ordenadores;

import java.util.Comparator;

import itens.Item;

public class OrdemAlfabeticaComparator implements Comparator<Item> {

	/**
	 * Ordena itens por nome
	 * 
	 * @param item1 Item para comparacao
	 * @param item2 Outro item do mesmo tipo para comparacao
	 * 
	 * @return Retorna nome de menor letra
	 * */
	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}
}
