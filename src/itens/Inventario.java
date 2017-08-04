package itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Inventario {
	private List<Itens> itensOrdenados;
	
	public Inventario() {
		itensOrdenados = new ArrayList<>();
	}

	public void adicionaItens(ArrayList<Itens> todosItens) {
		itensOrdenados.clear();
		itensOrdenados.addAll(todosItens);
	}
	
	public void ordenaNome() {
		Collections.sort(itensOrdenados, new OrdemAlfabeticaComparator());
	}
	
	public void ordenaValor() {
		Collections.sort(itensOrdenados, new OrdenaPorValorComparator());
	}
	
	public String listarItensOrdenadosPorNome() {
		ordenaNome();
		
		return listaItensString();
	}
	
	public String listarItensOrdenadosPorValor() {
		ordenaValor();
		return listaItensString();
	}
	
	public String listaItensString() {
		String saida = "";
		
		for (Itens iten : itensOrdenados) {
			saida += iten.toString() + "|";
		} 
		
		return saida;
	}
	
}
