package principal;

import java.util.HashMap;
import java.util.Map;

public class UsuarioController {

	private Map<String, Usuario> usuarios;

	public UsuarioController() {
		this.usuarios = new HashMap<>();
	}

	private String chaveMapa(String nome, String telefone) {
		return nome.toLowerCase() + telefone.toLowerCase();
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		if (usuarios.containsKey(chaveMapa(nome, telefone))) {
			return usuarios.get(chaveMapa(nome, telefone)).getInfoUsuario(atributo);
		}
		throw new IllegalArgumentException("Usuario invalido");
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		if (usuarios.containsKey(chaveMapa(nome, telefone))) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		usuarios.put(chaveMapa(nome, telefone), new Usuario(nome, telefone, email));
	}

	public void removerUsuario(String nome, String telefone) {
		if (!(usuarios.containsKey(chaveMapa(nome, telefone)))) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		usuarios.remove(chaveMapa(nome, telefone));
	}

	public String pesquisarUsuario(String nome, String telefone) {
		return usuarios.get(chaveMapa(nome, telefone)).toString();
	}

	private void atualizarChave(Usuario novo) {
		usuarios.put(chaveMapa(novo.getNome(), novo.getTelefone()), novo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		if (!(usuarios.containsKey(chaveMapa(nome, telefone)))) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		usuarios.get(chaveMapa(nome, telefone)).atualizarDados(atributo, valor);
		Usuario novo = usuarios.get(chaveMapa(nome, telefone));
		usuarios.remove(chaveMapa(nome, telefone));
		atualizarChave(novo);
	}
}
