package principal;

import easyaccept.EasyAccept;

public class FacadeTestUS1 {
	
	public static void main(String[] args) {
		args = new String[] { "principal.FacadeTestUS1", "testes_aceitacao/us1_test.txt" };
		EasyAccept.main(args);
	}

	private UsuarioController sistema;

	public void iniciarSistema() {
		sistema = new UsuarioController();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		sistema.cadastrarUsuario(nome, telefone, email);
	}

	public void removerUsuario(String nome, String telefone) {
		sistema.removerUsuario(nome, telefone);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return sistema.getInfoUsuario(nome, telefone, atributo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		sistema.atualizarUsuario(nome, telefone, atributo, valor);
	}
	
	public void fecharSistema(){
	}
}
