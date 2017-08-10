/**
 * Classe que implementa a interface de ordenacao
 * por valor
 * */

package itens;

import java.util.Comparator;

public class OrdemPorValorComparator implements Comparator<Item> {

	/**
	 * Ordena itens por valor
	 * 
	 * @param iten1 Item para comparacao
	 * @param iten2 Outro item do mesmo tipo para comparacao
	 * */
	@Override
	public int compare(Item iten1, Item iten2) {
		return (int) ((iten1.preco - iten2.preco) * 100);
	}
}
