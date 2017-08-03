package itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usuarios.Usuario;

public class Inventario {
	private Map<Usuario, Itens> itens;
	private List<Itens> itensOrdenados;
	
	public Inventario() {
		itens = new HashMap<>();
		itensOrdenados = new ArrayList<>();
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
			saida += iten.toString();
		} 
		
		return saida;
	}
	
}
