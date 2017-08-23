/**
 * Classe que implementa a interface de ordenacao
 * por valor
 * */

package ordenadores;

import java.util.Comparator;

import itens.Item;

public class OrdemPorValorComparator implements Comparator<Item> {

	/**
	 * Ordena itens por valor
	 * 
	 * @param iten1 Item para comparacao
	 * @param item2 Outro item do mesmo tipo para comparacao
	 * 
	 * @return Retorna o menor preco
	 * */
	@Override
	public int compare(Item item1, Item item2) {
		return (int) ((item1.getPreco() - item2.getPreco()) * 100);
	}
}
