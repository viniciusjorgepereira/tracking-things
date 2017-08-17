package itens;

import java.util.Comparator;

import usuarios.Usuario;

public class OrdenaUsuarioOrdemAlfabetica implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}
