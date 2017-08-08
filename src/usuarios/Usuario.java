/**
 * Classe responsável por criar usuários
 * */

package usuarios;

import java.util.HashSet;
import java.util.Set;

import emprestimo.Emprestimo;
import emprestimo.ExcecoesEmprestimo;
import itens.ExcecoesItens;
import itens.Filmes;
import itens.Itens;
import itens.JogoEletronico;
import itens.JogoTabuleiro;
import itens.Series;
import itens.Shows;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private Set<Itens> itens;
	private Set<Emprestimo> emprestimos;
	private ExcecoesItens excecoesItens;
	private ExcecoesEmprestimo excecoesEmprestimo;

	/**
	 * Construtor de um usuário. Recebe um nome, um número de telefone,
	 * e um e-mail. Todos em forma de string. Carrega também um conjunto
	 * dos itens que o usuário tem para emprestar.
	 * 
	 * @param nome Representa o nome do usuário
	 * @param telefone Representa o telefone do usuário
	 * @param email Representa o emal do usuário
	 * */
	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.itens = new HashSet<>();
		this.emprestimos = new HashSet<>();
		this.excecoesItens = new ExcecoesItens();
		this.excecoesEmprestimo = new ExcecoesEmprestimo();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public Set<Itens> getTodosItens() {
		return itens;
	}

	/**
	 * Retorna o item desejado
	 * 
	 * @param nome Represeta o nome do item
	 * 
	 * @return O item desejado
	 * */
	public Itens getItem(String nome) {
		for (Itens item : itens) {
			if (item.getNome().equals(nome)) {
				return item;
			}
		}
		excecoesItens.itemNotFound();
		return null;
	}
	
	/**
	 * Retorna em forma de string dos detalhes do item
	 * 
	 * @param nome Represeta o nome do item
	 * 
	 * @return Os detalhes do item em forma de String
	 * */
	public String getDetalhesItem(String nome) {
		return getItem(nome).toString();
	}
	
	/**
	 * Recupera informações do usuário
	 * 
	 * @param atributo Representa o atributo a ser recuperado
	 * 
	 * @return O atributo desejado em forma de String
	 * */
	public String getInfoUsuario(String atributo) {
		if ("email".equals(atributo.toLowerCase())) {
			return this.email;
			
		} else if ("telefone".equals(atributo.toLowerCase())) {
			return this.telefone;
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			return this.nome;
		}
		return "";
	}

	/**
	 * Recupera as infomações do item
	 * 
	 * @param nomeItem Representa o nome do item
	 * @param atributo Representa o atributo a ser retornado
	 * 
	 * @return O atributo desejado em forma de String
	 * */
	public String getInfoItem(String nomeItem, String atributo) {
		return getItem(nomeItem).getAtributo(atributo);
	}
	
	/**
	 * Remove itens do inventário do usuário
	 * 
	 * @param nomeItem Representa o nome do item
	 * */
	public void removerItem(String nomeItem) {
		Itens item = getItem(nomeItem);
		itens.remove(item);
	}
	
	/**
	 * Atualiza atributos do usuário
	 * 
	 * @param atributo Representa o atributo a ser atualizado
	 * @param valor Valor que substituirá o antigo
	 * */
	public void atualizarDadosUsuario(String atributo, String valor) {
		if ("email".equals(atributo.toLowerCase())) {
			this.email = valor;
			
		} else if ("telefone".equals(atributo.toLowerCase())) {
			this.telefone = valor;
		}
	}

	/**
	 * Atualiza atributos dos itens
	 * 
	 * @param nomeItem Representa o nome do item
	 * @param atributo Representa o atributo a ser atualizado
	 * @param valor Valor que substituirá o antigo
	 * */
	public void atualizarDadosItens(String nomeItem, String atributo, String valor) {
		if (atributo.equals("Nome")) {
			getItem(nomeItem).setNome(valor);
			
		} else if (atributo.equals("Preco")) {
			double preco = Double.parseDouble(valor);
			excecoesItens.precoInvalido(preco);
			getItem(nomeItem).setPreco(preco);
			
		} else if (atributo.equals("Status")) {
			boolean status = Boolean.parseBoolean(valor);
			getItem(nomeItem).setStatus(status);
			
		}
		
	}
	
	/**
	 * Cadastra um jogo eletrônico
	 * 
	 * @param nomeItem Representa o nome do jogo eletrônico
	 * @param preco Representa o preço do item
	 * @param plataforma Representa a plataforma que o jogo funciona
	 * */
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		excecoesItens.precoInvalido(preco);
		itens.add(new JogoEletronico(nomeItem, preco, plataforma));
	}
	
	/**
	 * Cadastra um jogo de tabuleiro
	 * 
	 * @param nomeItem Representa o nome do jogo de tabuleiro
	 * @param preco Representa o preço do item
	 * */
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		excecoesItens.precoInvalido(preco);
		itens.add(new JogoTabuleiro(nomeItem, preco));
	}
	
	/**
	 * Informa uma peça perdida em um jogo de tabuleiro
	 * 
	 * @param nomeItem Representa o nome do jogo de tabuleiro
	 * @param nomePeca Nome da peça perdida
	 * */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		Itens item = getItem(nomeItem); 
		if (item instanceof JogoTabuleiro) {
			JogoTabuleiro jogoTabuleiro = (JogoTabuleiro) item;
			jogoTabuleiro.adicionarPecaPerdida(nomePeca);
		}
	}
	
	/**
	 * Adiciona um filme em BluRay a lista de itens do usuário
	 * 
	 * @param nomeItem Representa o nome do filme em BluRay
	 * @param preco Representa o preço do item
	 * @param duracao Representa a duração do filme
	 * @param lancamento Represetna o ano de Lançamento
	 * @param genero Representa o gênero do filme
	 * @param classInd Representa a classificação indicativa do filme
	 * */
	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, int lancamento, String genero, String classind) {
		excecoesItens.precoInvalido(preco);
		itens.add(new Filmes(nomeItem, preco, duracao, classind, genero, lancamento));
	}

	/**
	 * Adiciona uma serie em BluRay a lista de itens do usuário
	 * 
	 * @param nomeItem Representa o nome da serie em BluRay
	 * @param preco Representa o preço do item
	 * @param descricao Representa a descrição da série
	 * @param duracao Representa a duração do BluRay
	 * @param classInd Representa a classificação indicativa da série
	 * @param genero Representa o gênero da série
	 * @param temporada Representa qual a temporada da sére
	 * */
	public void cadastrarBluraySerie(String nomeItem, double preco, String descricao, int duracao, String classInd, String genero, int temporada) {
		excecoesItens.precoInvalido(preco);
		itens.add(new Series(nomeItem, preco, duracao, descricao, classInd, genero, temporada));
	}
	
	/**
	 * Adiciona um show em BluRay a lista de itens do usuário
	 * 
	 * @param nomeItem Representa o nome do show em BluRay
	 * @param preco Representa o preço do item
	 * @param duracao Representa a duração do show
	 * @param faixas Quantidade de faixas que o show possui
	 * @param artista Representa a identificação do artista
	 * @param classInd Representa a classificação indicativa do show
	 * */
	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int faixas, String artista, String classInd) {
		excecoesItens.precoInvalido(preco);
		itens.add(new Shows(nomeItem, preco, duracao, faixas, artista, classInd));
	}
	
	public void emprestar(IdUsuario dono, IdUsuario requerente, String nomeItem, String dataEmprestimo,
			int periodo) {
		excecoesItens.statusItem(getItem(nomeItem).getStatus());
		emprestimos.add(new Emprestimo(dono, requerente, dataEmprestimo, nomeItem, periodo));
	}
	
	public void receberEmprestimo(IdUsuario dono, IdUsuario requerente, String nomeItem, String dataEmprestimo,
			int periodo) {
		emprestimos.add(new Emprestimo(dono, requerente, dataEmprestimo, nomeItem, periodo));
	}
	
	public Emprestimo encontraEmprestimo(IdUsuario requerente, String nomeItem, String dataEmprestimo) {
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getRequerente().equals(requerente) && emprestimo.getNomeItem().equals(nomeItem)
					&& emprestimo.getDataEmprestimo().equals(dataEmprestimo)) {
				return emprestimo;
			}
		}
		
		return null;
	}
	
	public void devolverItem(IdUsuario requerente, String nomeItem, String dataEmprestimo,
			String dataDevolucao) {
		Emprestimo emprestimo = encontraEmprestimo(requerente, nomeItem, dataEmprestimo);
		excecoesEmprestimo.emprestimoInvalido(emprestimo);
		emprestimo.devolucao(dataDevolucao);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	/**
	 * Representação em forma de String do usuário
	 * 
	 * @return String no formato nome, email, telefone
	 * */
	@Override
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}


}
