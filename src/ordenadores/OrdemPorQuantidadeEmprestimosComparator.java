package ordenadores;

import java.util.Comparator;

import itens.Item;

public class OrdemPorQuantidadeEmprestimosComparator implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		return (item2.getQuantidadeEmprestimos() - item1.getQuantidadeEmprestimos());
	}

}
