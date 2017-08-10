/**
 * Classe que Gerencia o sistema
 * */

package principal;

import itens.Inventario;
import usuarios.UsuarioController;

public class SystemController {
	private UsuarioController usuarios;
	private Inventario inventario;
	private ExcecoesEntradas excecoes;
	
	/**
	 * Constroi o Gerenciador do Sistema, gerando um controlador de
	 * usuários e o inventário
	 * */
	public SystemController() {
		usuarios = new UsuarioController();
		inventario = new Inventario();
		excecoes = new ExcecoesEntradas();
	}
	
	/**
	 * Invoca método de cadastrar usuários
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param email Representa o email do usuário
	 * */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		excecoes.dadosInvalidos(nome, telefone, email);
		usuarios.cadastrarUsuario(nome, telefone, email);
	}

	/**
	 * Invoca método para remover usuário
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * */
	public void removerUsuario(String nome, String telefone) {
		excecoes.dadosInvalidos(nome, telefone);
		usuarios.removerUsuario(nome, telefone);
	}
	
	/**
	 * Invoca método para resgatar atributos do usuário
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param atributo Representa atributo a ser resgatado
	 * 
	 * @return Retorna em forma de String o atributo desejado
	 * */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		excecoes.dadosInvalidos(nome, telefone, atributo, "Atributo");
		return usuarios.getInfoUsuario(nome, telefone, atributo);
	}

	/**
	 * Atualiza dados do usuário
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param atributo Representa o atributo a ser alterado
	 * @param valor Valor que substituirá o antigo
	 * */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		excecoes.dadosInvalidos(nome, telefone, atributo, valor, "Atributo", "Valor");
		usuarios.atualizarUsuario(nome, telefone, atributo, valor);
	}
	
	/**
	 * Cadastra jogo eletrônico
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do jogo eletrônico
	 * @param preco Representa o preço do item
	 * @param plataforma Representa a plataforma que o jogo funciona
	 * */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		excecoes.dadosInvalidos(nome, telefone, nomeItem, plataforma, "Nome do Item", "Plataforma");
		excecoes.numeroInvalido("Preco", preco);
		usuarios.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra jogo de tabuleiro
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do jogo de tabuleiro
	 * @param preco Representa o preço do item
	 * */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		excecoes.dadosInvalidos(nome, telefone, nomeItem, "Nome do item");
		excecoes.numeroInvalido("Preco", preco);
		usuarios.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	/**
	 * Adiciona peca perdida ao jogo de tabuleiro
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do jogo de tabuleiro
	 * @param nomePeca Representa o nome da peca perdida
	 * */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		excecoes.dadosInvalidos(nome, telefone, nomeItem, nomePeca, "Nome do item", "Nome da peça");
		usuarios.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	/**
	 * Cadastra um filme em BluRay
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do filme
	 * @param preco Representa o preco do filme
	 * @param duracao Representa a duracao do filme
	 * @param genero Representa o genero do filme
	 * @param classificacao Representa a classificacao indicativa
	 * @param anoLancamento Representa o ano de lancamento do filme
	 * */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		excecoes.dadosInvalidos(nomeItem, telefone, nomeItem, genero, "Nome do item", "Genero");
		excecoes.numeroInvalido("Preco", preco);
		excecoes.numeroInvalido("Duração", duracao);
		excecoes.outrosDadosInvalidos("Classificação", classificacao);
		
		usuarios.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		
	}

	/**
	 * Cadastra um show em BluRay
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do show
	 * @param preco Representa o preco do show (item)
	 * @param duracao Representa a duracao do show
	 * @param numeroFaixas Representa o numero total de faixas de um show
	 * @param artista Representa o artista que apresenta o show
	 * @param classificacao Representa a classificacao indicativa
	 * */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		excecoes.dadosInvalidos(nomeItem, telefone, nomeItem, artista, "Nome do item", "Nome do Artista");
		excecoes.numeroInvalido("Preco", preco);
		excecoes.numeroInvalido("Duração", duracao);
		excecoes.numeroInvalido("Numero de faixas", numeroFaixas);
		excecoes.outrosDadosInvalidos("Classificação", classificacao);
		
		usuarios.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		
	}

	/**
	 * Cadastra uma serie em BluRay
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome da serie
	 * @param preco Representa o preco da serie (item)
	 * @param descricao Apresenta uma descricao sobre a serie
	 * @param duracao Representa a duracao da serie
	 * @param classificacao Representa a classificacao indicativa
	 * @param genero Representa o genero da serie
	 * @param temporada Representa qual a temporada da serie
	 * */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		excecoes.dadosInvalidos(nomeItem, telefone, nomeItem, descricao, "Nome do item", "Descrição");
		excecoes.numeroInvalido("Preco", preco);
		excecoes.numeroInvalido("Duração", duracao);
		excecoes.numeroInvalido("Temporada", temporada);
		excecoes.outrosDadosInvalidos("Classificação", classificacao);
		excecoes.outrosDadosInvalidos("Genero", genero);
		
		usuarios.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}
	
	/**
	 * Adiciona itens ao inventario
	 * */
	public void adicionaItensInventario() {
		inventario.adicionaItens(usuarios.getTodosItens());
	}

	/**
	 * Adiciona um BluRay na temporada
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeBluRayTemporada Representa qual a temporada da serie
	 * @param duracao A duracao do episodio inserido
	 * */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		excecoes.dadosInvalidos(nomeBlurayTemporada, telefone, nomeBlurayTemporada, "Nome do Blu-Ray");
		excecoes.numeroInvalido("Duração", duracao);
		
		usuarios.cadastrarBlurayTemporada(nome, telefone, nomeBlurayTemporada, duracao);
	}

	/**
	 * Remove um item do sistema
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do item a ser removido
	 * */
	public void removerItem(String nome, String telefone, String nomeItem) {
		excecoes.dadosInvalidos(nome, telefone, nomeItem, "Nome do Item");
		usuarios.removerItem(nome, telefone, nomeItem);
	}

	/**
	 * Atualiza dados de um item
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do item a ser atualizado
	 * @param atributo Representa o atributo a ser atualizado
	 * @param valor Representa o valor que será setado
	 * */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		excecoes.dadosInvalidos(nome, telefone, nomeItem, atributo, "Nome do item", "Atributo");
		excecoes.valorInvalido(atributo, valor);
		
		usuarios.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	/**
	 * Traz informacoes sobre o item
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do item a ser consultado
	 * @param atributo Representa o atributo a ser consultado
	 * 
	 * @return Retorna uma string com o dado consultado
	 * */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		excecoes.dadosInvalidos(nomeItem, telefone, nomeItem, atributo, "Nome do item", "Atributo");
		return usuarios.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	/**
	 * Lista os itens ordenados por nome
	 * 
	 * @return Retorna uma string com os itens ordenados por nome
	 * */
	public String listarItensOrdenadosPorNome() {
		adicionaItensInventario();
		return inventario.listarItensOrdenadosPorNome();
	}

	/**
	 * Lista os itens ordenados por valor
	 * 
	 * @return Retorna uma string com os itens ordenados por valor
	 * */
	public String listarItensOrdenadosPorValor() {
		adicionaItensInventario();
		return inventario.listarItensOrdenadosPorValor();
	}

	/**
	 * Retorna todas as informacoes sobre o item
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param nomeItem Representa o nome do item a ser consultado
	 * 
	 * @return Retorna uma string com os dados do item consultado
	 * */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		excecoes.dadosInvalidos(nome, telefone, nomeItem, "Nome do item");
		return usuarios.detalhesItem(nome, telefone, nomeItem);
	}
	
	/**
	 * Registra um empréstimo
	 * 
	 * @param nomeDono Representa o nome do dono do item
	 * @param telefoneDono Representa o telefone do dono
	 * @param nomeRequerente Representa o nome do Requerente
	 * @param telefoneRequerente Representa o telefone do requerente
	 * @param nomeItem Nome do item a ser emprestado
	 * @param dataEmprestimo A data que o emprestimo foi feito
	 * @param periodo Período que o emprestimo irá durar
	 * */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		excecoes.dadosInvalidos(nomeDono, telefoneDono, nomeItem, dataEmprestimo, "Nome do item", "Data de Emprestimo");
		excecoes.dadosInvalidos(nomeRequerente, telefoneRequerente);
		
		usuarios.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);	
	}

	/**
	 * Registra uma devolucao
	 * 
	 * @param nomeDono Representa o nome do dono do item
	 * @param telefoneDono Representa o telefone do dono
	 * @param nomeRequerente Representa o nome do Requerente
	 * @param telefoneRequerente Representa o telefone do requerente
	 * @param nomeItem Nome do item a ser emprestado
	 * @param dataEmprestimo A data que o emprestimo foi feito
	 * @param dataDevolucao A data que o item foi devolvido de fato
	 * */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) {
		excecoes.dadosInvalidos(nomeDono, telefoneDono, nomeItem, dataEmprestimo, "Nome do item", "Data de Emprestimo");
		excecoes.dadosInvalidos(nomeRequerente, telefoneRequerente);
		excecoes.outrosDadosInvalidos("Data de Devolução", dataDevolucao);
		
		usuarios.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
	}
}
