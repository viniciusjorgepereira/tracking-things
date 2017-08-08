/**
 * Classe que gerencia o fluxo de usuários
 * */

package usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import itens.Item;
import usuarios.IdUsuario;

public class UsuarioController2 {

	private ExcecoesUsuario excecoes;
	private Map<IdUsuario, Usuario> usuarios;
	

	/**
	 * Constroi um controlador de usuário, possuindo um map com o ID do usuário
	 * e  com os dados do usuário
	 * */
	public UsuarioController2() {
		this.usuarios = new HashMap<>();
		this.excecoes = new ExcecoesUsuario();
	}

	/**
	 * Invoca método para recuparar informações do usuário
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param atributo Atributo a ser retornado
	 * 
	 * @return Retorna atributo em forma de String
	 * */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		IdUsuario id = pesquisaId(nome, telefone);
		return usuarios.get(id).getInfoUsuario(atributo);
	}

	/**
	 * Invoca método para cadastrar usuário
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param email Representa o email do usário
	 * */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioJaCadastrado(usuarios.containsKey(id));
		usuarios.put(id, new Usuario(nome, telefone, email));
	}

	/**
	 * Invoca método para remover usuário pelo ID
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * */
	public void removerUsuario(String nome, String telefone) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.remove(id);
	}
	
	/**
	 * Invoca método para remover item
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param nomeItem Representa nome do item a ser removido
	 * */
	public void removerItem(String nome, String telefone, String nomeItem) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).removerItem(nomeItem);
	}

	/**
	 * Busca usuário no sistema
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * 
	 * @return Retorna uma representação do usuário em String
	 * */
	public String pesquisarUsuario(String nome, String telefone) {
		IdUsuario id = pesquisaId(nome, telefone);
		return usuarios.get(id).toString();
	}

	public IdUsuario pesquisaId(String nome, String telefone) {
		for (IdUsuario id : usuarios.keySet()) {
			if (id.getNome().equals(nome) && id.getTelefone().equals(telefone)) {
				return id;
			}
		}
		excecoes.usuarioInvalido(false);
		return null;
	}
	
	/**
	 * Atualiza o ID do usuário
	 * 
	 * @param id Representa o id do usuário
	 * */
	private void atualizarChave(IdUsuario id) {
		Usuario novo = usuarios.get(id);
		usuarios.remove(id);
		IdUsuario novoId = new IdUsuario(novo.getNome(), novo.getTelefone());
		usuarios.put(novoId, novo);
	}

	/**
	 * Atualiza dados do usuário
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param atributo Atributo a ser atualizado
	 * @param valor Valor que substituirá o antigo
	 * */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).atualizarDadosUsuario(atributo, valor);
		atualizarChave(id);
	}

	/**
	 * Invoca método de cadastrar um jogo eletrônico
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param nomeItem Representa o nome do jogo eletrônico
	 * @param preco Representa o preço do item
	 * @param plataforma Representa a plataforma que o jogo funciona
	 * */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarEletronico(nomeItem, preco, plataforma);
	}
	
	/**
	 * Invoca método de cadastrar um jogo de tabuleiro
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param nomeItem Representa o nome do jogo de tabuleiro
	 * @param preco Representa o preço do item
	 * */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarJogoTabuleiro(nomeItem, preco);
	}
	
	/**
	 * Invoca método de cadastrar um jogo eletrônico
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param nomeItem Representa o nome do jogo eletrônico
	 * @param nomePeca Representa o nome da peça perdida
	 * */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).adicionarPecaPerdida(nomeItem, nomePeca);
	}
	
	/**
	 * Invoca método de cadastrar um filme em BluRay
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param nomeItem Representa o nome do filme
	 * @param preco Representa o preço do item
	 * @param duracao Representa a duração do filme
	 * @param genero Representa o gênero do filme
	 * @param classificacao Representa a classificação indicativa do filme
	 * @param anoLancamento Representa o ano de lançamento do filme
	 * */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarBlurayFilme(nomeItem, preco, duracao, anoLancamento, genero, classificacao);			
	}

	/**
	 * Invoca método de cadastrar um show em BluRay
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param nomeItem Representa o nome do show em BluRay
	 * @param preco Representa o preço do item
	 * @param duracao Representa a duração do show
	 * @param numeroFaixas Representa a quantidade de faixas no show
	 * @param artista Representa o artista do show
	 * @param classificacao Representa a classificação indicativa do show
	 * */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarBlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}
	
	/**
	 * Invoca método de cadastrar uma série em BluRay
	 * 
	 * @param nome Representa nome do usuário
	 * @param telefone Representa telefone do usuário
	 * @param nomeItem Representa o nome da série em BluRay
	 * @param preco Representa o preço do item
	 * @param descricao Representa a descrição da série
	 * @param duracao Representa a duraçãodo BluRay
	 * @param artista Representa o artista do show
	 * @param classificacao Representa a classificação indicativa da série
	 * @param genero Representa o gênero da série
	 * @param temporada Indica qual temporada pertence o BluRay
	 * */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarBluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}

	public void cadastrarBlurayTemporada(String nome, String telefone, String nomeTemporada, int duracao) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarBlurayTemporada(nomeTemporada,duracao);
	}
	
	public ArrayList<Item> getTodosItens() {
		ArrayList<Item> itens = new ArrayList<>();
		for (Usuario usuario : usuarios.values()) {
			itens.addAll(usuario.getTodosItens());
		}
		return itens;
	}

	public String detalhesItem(String nome, String telefone, String nomeItem) {
		IdUsuario id = pesquisaId(nome, telefone);
		return usuarios.get(id).getDetalhesItem(nomeItem);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		IdUsuario id = pesquisaId(nome, telefone);
		return usuarios.get(id).getInfoItem(nomeItem, atributo);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).atualizarDadosItens(nomeItem, atributo, valor);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		IdUsuario idDono = pesquisaId(nomeDono, telefoneDono);
		IdUsuario idRequerente = pesquisaId(nomeRequerente, telefoneRequerente);
		
		usuarios.get(idDono).emprestar(idDono, idRequerente, nomeItem, dataEmprestimo, periodo);
		usuarios.get(idRequerente).receberEmprestimo(idDono, idRequerente, nomeItem, dataEmprestimo, periodo);
		usuarios.get(idDono).atualizarDadosItens(nomeItem, "Status", "true");
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		IdUsuario idDono = pesquisaId(nomeDono, telefoneDono);
		IdUsuario idRequerente = pesquisaId(nomeRequerente, telefoneRequerente);
		
		usuarios.get(idDono).devolverItem(idRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		usuarios.get(idRequerente).devolverItem(idRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		usuarios.get(idDono).atualizarDadosItens(nomeItem, "Status", "false");
	}
}
