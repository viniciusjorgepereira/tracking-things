package usuarios;

import java.util.HashMap;
import java.util.Map;

import usuarios.IdUsuario;

public class UsuarioController {

	private ExcecoesUsuario excecoes;
	private Map<IdUsuario, Usuario> usuarios;

	public UsuarioController() {
		this.usuarios = new HashMap<>();
		this.excecoes = new ExcecoesUsuario();
	}

	private String chaveMapa(String nome, String telefone) {
		return nome.toLowerCase() + telefone.toLowerCase();
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		return usuarios.get(id).getInfoUsuario(atributo);
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioJaCadastrado(usuarios.containsKey(id));
		usuarios.put(id, new Usuario(nome, telefone, email));
	}

	public void removerUsuario(String nome, String telefone) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.remove(id);
	}

	public String pesquisarUsuario(String nome, String telefone) {
		return usuarios.get(chaveMapa(nome, telefone)).toString();
	}

	private void atualizarChave(IdUsuario id) {
		Usuario novo = usuarios.get(id);
		usuarios.remove(id);
		IdUsuario novoId = new IdUsuario(novo.getNome(), novo.getTelefone());
		usuarios.put(novoId, novo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).atualizarDadosUsuario(atributo, valor);
		atualizarChave(id);
	}
}
