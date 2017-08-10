/**
 * Classe que implementa a interface de ordenacao
 * por nome
 * */

package itens;

import java.util.Comparator;

public class OrdemAlfabeticaComparator implements Comparator<Item> {

	/**
	 * Ordena itens por nome
	 * 
	 * @param iten1 Item para comparacao
	 * @param iten2 Outro item do mesmo tipo para comparacao
	 * */
	@Override
	public int compare(Item iten1, Item iten2) {
		return iten1.nome.compareTo(iten2.nome);
	}
}
