package principal;

import java.util.HashMap;
import java.util.Map;

public class UsuarioController {

	private IdUsuario id;
	private Map<IdUsuario, Usuario> usuarios;

	public UsuarioController() {
		this.usuarios = new HashMap<>();
	}

	private String chaveMapa(String nome, String telefone) {
		return nome.toLowerCase() + telefone.toLowerCase();
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		id = new IdUsuario(nome, telefone);
		if (usuarios.containsKey(id)) {
			return usuarios.get(id).getInfoUsuario(atributo);
		}
		throw new IllegalArgumentException("Usuario invalido");
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		id = new IdUsuario(nome, telefone);
		if (usuarios.containsKey(id)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		usuarios.put(id, new Usuario(nome, telefone, email));
	}

	public void removerUsuario(String nome, String telefone) {
		id = new IdUsuario(nome, telefone);
		if (!(usuarios.containsKey(id))) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		usuarios.remove(id);
	}

	public String pesquisarUsuario(String nome, String telefone) {
		return usuarios.get(chaveMapa(nome, telefone)).toString();
	}

	private void atualizarChave(IdUsuario id) {
		Usuario novo = usuarios.get(id);
		usuarios.remove(id);
		id = new IdUsuario(novo.getNome(), novo.getTelefone());
		usuarios.put(id, novo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		id = new IdUsuario(nome, telefone);
		if (!(usuarios.containsKey(id))) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		usuarios.get(id).atualizarDados(atributo, valor);
		atualizarChave(id);
	}
}
