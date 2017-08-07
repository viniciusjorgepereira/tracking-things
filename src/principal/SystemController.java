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
		usuarios.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		usuarios.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		usuarios.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		usuarios.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		usuarios.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		usuarios.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}
	
	public void adicionaItensInventario() {
		inventario.adicionaItens(usuarios.getTodosItens());
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		usuarios.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		usuarios.atualizarItem(nome, telefone, nomeItem, atributo, valor);
		
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return usuarios.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	public String listarItensOrdenadosPorNome() {
		adicionaItensInventario();
		return inventario.listarItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		adicionaItensInventario();
		return inventario.listarItensOrdenadosPorValor();
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return usuarios.detalhesItem(nome, telefone, nomeItem);
	}
	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		usuarios.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente,
				telefoneRequerente, nomeItem, dataEmprestimo, periodo);
		
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		usuarios.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
				nomeItem, dataEmprestimo, dataDevolucao);
		
	}
	



}
