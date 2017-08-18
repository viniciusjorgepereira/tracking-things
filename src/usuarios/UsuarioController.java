/**
 * Classe que gerencia o fluxo de usuarios
 * */

package usuarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import emprestimo.Emprestimo;
import itens.Item;
import usuarios.IdUsuario;

public class UsuarioController {

	private ExcecoesUsuario excecoes;
	private Map<IdUsuario, Usuario> usuarios;
	

	/**
	 * Constroi um controlador de usuario, possuindo um map com o ID do usuario
	 * e  com os dados do usuario
	 * */
	public UsuarioController() {
		this.usuarios = new HashMap<>();
		this.excecoes = new ExcecoesUsuario();
	}

	/**
	 * Invoca metodo para cadastrar usuario
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param email Representa o email do usuario
	 * */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioJaCadastrado(usuarios.containsKey(id));
		usuarios.put(id, new Usuario(nome, telefone, email));
	}
	
	/**
	 * Invoca metodo para recuparar informacoes do usuario
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param atributo Atributo a ser retornado
	 * 
	 * @return Retorna atributo em forma de String
	 * */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		IdUsuario id = pesquisaId(nome, telefone);
		Usuario usuario = usuarios.get(id);
		usuario.atualizaCartao();
		return usuario.getInfoUsuario(atributo);
	}

	/**
	 * Pesquisa um ID de usuario e retorna o mesmo, Caso nao
	 * encontre, retorna null.
	 * 
	 * @param nome Representa o nome do usuario
	 * @param telefone Representa o telefone do usuario
	 * 
	 * @return O ID de usuario procurado ou null
	 * */
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
	 * Invoca metodo para remover usuario pelo ID
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * */
	public void removerUsuario(String nome, String telefone) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.remove(id);
	}
	
	/**
	 * Invoca metodo para remover item
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param nomeItem Representa nome do item a ser removido
	 * */
	public void removerItem(String nome, String telefone, String nomeItem) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).removerItem(nomeItem);
	}

	/**
	 * Busca usuario no sistema
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * 
	 * @return Retorna uma representacao do usuario em String
	 * */
	public String pesquisarUsuario(String nome, String telefone) {
		IdUsuario id = pesquisaId(nome, telefone);
		return usuarios.get(id).toString();
	}

	/**
	 * Atualiza o ID do usuario
	 * 
	 * @param id Representa o id do usuario
	 * */
	private void atualizarChave(IdUsuario id) {
		Usuario novo = usuarios.get(id);
		usuarios.remove(id);
		IdUsuario novoId = new IdUsuario(novo.getNome(), novo.getTelefone());
		usuarios.put(novoId, novo);
	}

	/**
	 * Atualiza dados do usuario
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param atributo Atributo a ser atualizado
	 * @param valor Valor que substituira o antigo
	 * */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).atualizarDadosUsuario(atributo, valor);
		atualizarChave(id);
	}

	/**
	 * Invoca metodo de cadastrar um jogo eletronico
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param nomeItem Representa o nome do jogo eletronico
	 * @param preco Representa o preco do item
	 * @param plataforma Representa a plataforma que o jogo funciona
	 * */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarEletronico(nomeItem, preco, plataforma);
	}
	
	/**
	 * Invoca metodo de cadastrar um jogo de tabuleiro
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param nomeItem Representa o nome do jogo de tabuleiro
	 * @param preco Representa o preco do item
	 * */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarJogoTabuleiro(nomeItem, preco);
	}
	
	/**
	 * Invoca metodo de cadastrar um jogo eletronico
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param nomeItem Representa o nome do jogo eletronico
	 * @param nomePeca Representa o nome da peca perdida
	 * */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).adicionarPecaPerdida(nomeItem, nomePeca);
	}
	
	/**
	 * Invoca metodo de cadastrar um filme em BluRay
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param nomeItem Representa o nome do filme
	 * @param preco Representa o preco do item
	 * @param duracao Representa a duracao do filme
	 * @param genero Representa o genero do filme
	 * @param classificacao Representa a classificacao indicativa do filme
	 * @param anoLancamento Representa o ano de lancamento do filme
	 * */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarBlurayFilme(nomeItem, preco, duracao, anoLancamento, genero, classificacao);			
	}

	/**
	 * Invoca metodo de cadastrar um show em BluRay
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param nomeItem Representa o nome do show em BluRay
	 * @param preco Representa o preco do item
	 * @param duracao Representa a duracao do show
	 * @param numeroFaixas Representa a quantidade de faixas no show
	 * @param artista Representa o artista do show
	 * @param classificacao Representa a classificacao indicativa do show
	 * */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarBlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}
	
	/**
	 * Invoca metodo de cadastrar uma serie em BluRay
	 * 
	 * @param nome Representa nome do usuario
	 * @param telefone Representa telefone do usuario
	 * @param nomeItem Representa o nome da serie em BluRay
	 * @param preco Representa o preco do item
	 * @param descricao Representa a descricao da serie
	 * @param duracao Representa a duracao do BluRay
	 * @param classificacao Representa a classificacao indicativa da serie
	 * @param genero Representa o genero da serie
	 * @param temporada Indica qual temporada pertence o BluRay
	 * */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarBluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}

	/**
	 * Invoca metodo de cadastrar um episodio novo na temporada
	 * 
	 * @param nome Representa o nome do usuario
	 * @param telefone Representa o telefone do usuario
	 * @param nomeTemporada Representa o nome da serie
	 * @param duracao Representa a duracao da serie (desta temporada)
	 * */
	public void cadastrarBlurayTemporada(String nome, String telefone, String nomeTemporada, int duracao) {
		IdUsuario id =pesquisaId(nome, telefone);
		usuarios.get(id).cadastrarBlurayTemporada(nomeTemporada,duracao);
	}
	
	/**
	 * Retorna um array com todos os itens
	 * 
	 * @return Retorna um array com todos os itens
	 * */
	public ArrayList<Item> getTodosItens() {
		ArrayList<Item> itens = new ArrayList<>();
		for (Usuario usuario : usuarios.values()) {
			itens.addAll(usuario.getTodosItens());
		}
		return itens;
	}

	/**
	 * Invoca o metodo que traz detalhes sobre o Item em forma de String
	 * 
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @param nomeItem Nome do Item buscado
	 * 
	 * @return Retorna uma String com os detalhes do item
	 * */
	public String detalhesItem(String nome, String telefone, String nomeItem) {
		IdUsuario id = pesquisaId(nome, telefone);
		return usuarios.get(id).getDetalhesItem(nomeItem);
	}

	/**
	 * Invoca o metodo que recupera um atributo em forma de String
	 * 
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @param nomeItem Nome do Item buscado
	 * @param atributo Atributo a ser buscado
	 * 
	 * @return Retorna um atributo desejado em forma de string
	 * */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		IdUsuario id = pesquisaId(nome, telefone);
		return usuarios.get(id).getInfoItem(nomeItem, atributo);
	}

	/**
	 * Atualiza um atributo do item
	 * 
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @param nomeItem Nome do Item buscado
	 * @param atributo Atributo a ser alterado
	 * @param valor Valor que substituira o antigo
	 * */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		IdUsuario id = pesquisaId(nome, telefone);
		usuarios.get(id).atualizarDadosItens(nomeItem, atributo, valor);
	}

	/**
	 * Registra emprestimos
	 * 
	 * @param nomeDono Nome do dono
	 * @param telefoneDono Telefone do dono
	 * @param nomeRequerente Nome da pessoa que pega emprestado
	 * @param telefoneRequerente Telefone da pessoa que pega emprestado
	 * @param nomeItem Nome do item
	 * @param dataEmprestimo Representa a data do emprestimo
	 * @param periodo Representa o periodo do emprestimo em dias
	 * */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		IdUsuario idDono = pesquisaId(nomeDono, telefoneDono);
		IdUsuario idRequerente = pesquisaId(nomeRequerente, telefoneRequerente);
		usuarios.get(idRequerente).atualizaCartao();
		usuarios.get(idRequerente).permicaoEmprestimo();
		usuarios.get(idRequerente).periodoEmprestimoValido(periodo);
		Emprestimo emprestimo = usuarios.get(idDono).criarEmprestimo(idDono, idRequerente, nomeItem, dataEmprestimo, periodo);
		usuarios.get(idRequerente).registrarEmprestimo(emprestimo);
	}

	/**
	 * Registra devolucoes de itens no sistema
	 * 
	 * @param nomeDono Nome do dono
	 * @param telefoneDono Telefone do dono
	 * @param nomeRequerente Nome da pessoa que pega emprestado
	 * @param telefoneRequerente Telefone da pessoa que pega emprestado
	 * @param nomeItem Nome do item
	 * @param dataEmprestimo Representa a data do emprestimo
	 * @param dataDevolucao Representa a data de devolucao do item
	 * */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) {
		IdUsuario idDono = pesquisaId(nomeDono, telefoneDono);
		IdUsuario idRequerente = pesquisaId(nomeRequerente, telefoneRequerente);
		int atraso = usuarios.get(idDono).devolverItem(idDono, idRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		usuarios.get(idRequerente).devolverItem(idDono, idRequerente, nomeItem, dataEmprestimo, dataDevolucao);		
		double preco = Double.parseDouble(usuarios.get(idDono).getInfoItem(nomeItem, "preco"));
		if (atraso <= 0) {
			usuarios.get(idRequerente).addReputacaoCinco(preco);
		}
		else if (atraso > 0) {
			usuarios.get(idRequerente).diminuirReputacao(atraso, preco);			
		}
	}

	public String listarCaloteiros() {
		String saida = "Lista de usuarios com reputacao negativa: ";
		List<Usuario> lista = new ArrayList<>(usuarios.values());
		Collections.sort(lista, new OrdemAlfabeticaComparator());
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getReputacao() < 0) {
				saida += lista.get(i).toString() + "|";
			}
		}
		return saida;
	}
	
	public String listarTop10MelhoresUsuarios() {
		List<Usuario> lista = new ArrayList<>(usuarios.values());
		Collections.sort(lista, new MaiorReputacaoComparator());
		return listarTop10(lista);
	}

	public String listarTop10PioresUsuarios() {
		List<Usuario> lista = new ArrayList<>(usuarios.values());
		Collections.sort(lista, new MenorReputacaoComparator());
		return listarTop10(lista);
	}

	private String listarTop10(List<Usuario> lista) {
		String saida = "";
		if (lista.size() < 10) {
			for (int i = 0; i < lista.size(); i++) {
				saida += (i+1) + ": " + lista.get(i).getNome() +" - Reputacao: " + String.format("%.2f", lista.get(i).getReputacao()) + "|";
			}
		}
		else {
			for (int i = 0; i < 10; i++) {
				saida += (i+1) + ": " + lista.get(i).getNome() +" - Reputacao: " + String.format("%.2f", lista.get(i).getReputacao()) + "|";
			}
		}
		return saida;
	}
	
	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono) {
		IdUsuario idDono = pesquisaId(nomeDono, telefoneDono);
		return usuarios.get(idDono).exibirEmprestimosOrdenadosNomeItem();
	}
}
