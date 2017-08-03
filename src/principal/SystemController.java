package principal;

import itens.Inventario;
import usuarios.UsuarioController;

public class SystemController {
	private UsuarioController usuarios;
	private Inventario inventario;
	
	public SystemController() {
		usuarios = new UsuarioController();
		inventario = new Inventario();
	}
	
	public void cadastrarUsuario(String nome, String telefone, String email) {
		usuarios.cadastrarUsuario(nome, telefone, email);
	}

	public void removerUsuario(String nome, String telefone) {
		usuarios.removerUsuario(nome, telefone);
	}
	
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return usuarios.getInfoUsuario(nome, telefone, atributo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		usuarios.atualizarUsuario(nome, telefone, atributo, valor);
	}
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int nomeroFaixas, String artista, String classificacao) {
		
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return null;
	}

	public String listarItensOrdenadosPorNome() {
		return inventario.listarItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		return null;
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return null;
	}
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
	}
	



}
