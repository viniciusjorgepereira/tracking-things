package principal;


import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
	
	private List<Usuario> usuarios;

	public UsuarioController() {
		this.usuarios = new ArrayList<>();
	}
	
	public String getInfoUsuario(String nome, String email, String telefone) {
		return usuarios.get(buscaUsuario(nome, telefone)).getInfoUsuario(nome, email, telefone);
	}
	
	private int buscaUsuario(String nome, String telefone) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome().equals(nome.toLowerCase())) {
				if (usuarios.get(i).getTelefone().equals(telefone.toLowerCase())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void cadastrarUsuario(String nome, String email, String telefone) {
		usuarios.add(new Usuario(nome,email,telefone));
	}
	
	public void removeUsuario(String nome, String telefone) {
		usuarios.remove(buscaUsuario(nome, telefone));
	}
	
	public String pesquisaUsuario(String nome, String telefone) {
		return usuarios.get(buscaUsuario(nome, telefone)).toString();
	}
	
	public void attUsuario(String nome, String telefone) {
		usuarios.get(buscaUsuario(nome, telefone)).attDados(nome, telefone);
	}
}
