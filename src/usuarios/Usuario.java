/**
 * Classe responsavel por criar usuarios
 * */

package usuarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartoes.CartaoBomAmigo;
import cartoes.CartaoCaloteiro;
import cartoes.CartaoFidelidade;
import cartoes.CartaoFreeRider;
import cartoes.CartaoNoob;
import emprestimo.Emprestimo;
import itens.ExcecoesItens;
import itens.Filmes;
import itens.Item;
import itens.JogoEletronico;
import itens.JogoTabuleiro;
import itens.Series;
import itens.Shows;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private Set<Item> itens;
	private Reputacao reputacao;
	private CartaoFidelidade cartao;
	private Set<Emprestimo> emprestimos;
	private ExcecoesItens excecoesItens;

	/**
	 * Construtor de um usuario. Recebe um nome, um numero de telefone,
	 * e um e-mail. Todos em forma de string. Carrega também um conjunto
	 * dos itens que o usuario tem para emprestar.
	 * 
	 * @param nome Representa o nome do usuario
	 * @param telefone Representa o telefone do usuario
	 * @param email Representa o emal do usuario
	 * */
	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.itens = new HashSet<>();
		this.reputacao = new Reputacao(0);
		this.cartao = new CartaoFreeRider();
		this.emprestimos = new HashSet<>();
		this.excecoesItens = new ExcecoesItens();
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

	public Set<Item> getTodosItens() {
		return itens;
	}
	
	public CartaoFidelidade getCartao() {
		atualizaCartao();
		return cartao;
	}
	public double getReputacao() {
		return reputacao.getReputacao();
	}
	
	public Set<Emprestimo> getEmprestando() {
		Set<Emprestimo> emprestando = new HashSet<>();
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getNomeDono().equals(nome) && emprestimo.getTelefoneDono().equals(telefone)) {
				emprestando.add(emprestimo);
			}
		}
		return emprestando;
	}
	
	public Set<Emprestimo> getEmprestado() {
		Set<Emprestimo> emprestado = new HashSet<>();
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getNomeRequerente().equals(nome) && emprestimo.getTelefoneRequerente().equals(telefone)) {
				emprestado.add(emprestimo);
			}
		}
		return emprestado;
	}
	
	public List<Emprestimo> getEmprestimos() {
		return new ArrayList<>(emprestimos);
	}
	
	/**
	 * Invoca metodo para incementar 5% do preco 
	 * do item adicionado para emprestimo na reputacao
	 * 
	 * @param preco Representa preco do item adicionado para emprestimo
	 * */
	public void addReputacaoCinco(double preco) {
		reputacao.acrescimoCinco(preco);
	}
	
	/**
	 * Invoca metodo para incementar 10% do preco 
	 * do item emprestado na reputacao
	 * 
	 * @param preco Representa preco do item emprestado
	 * */
	public void addReputacaoDez(double preco) {
		reputacao.acrescimoDez(preco);
	}
	
	/**
	 * Invoca metodo de diminuir a reputacao em caso
	 * de atraso na entrega do item
	 * 
	 * @param atraso Representa dias de atraso na devolucao do item
	 * @param preco Representa o terco do item
	 * */
	public void diminuirReputacao(int atraso, double preco) {
		reputacao.diminuirReputacao(atraso,preco);
	}
	
	/**
	 * Retorna o item desejado
	 * 
	 * @param nome Represeta o nome do item
	 * 
	 * @return O item desejado
	 * */
	public Item getItem(String nome) {
		for (Item item : itens) {
			if (item.getNome().equals(nome)) {
				return item;
			}
		}
		excecoesItens.itemInexistente();
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
	 * Recupera informações do usuario
	 * 
	 * @param atributo Representa o atributo a ser recuperado
	 * 
	 * @return O atributo desejado em forma de String
	 * */
	public String getInfoUsuario(String atributo) {
		if ("email".equals(atributo.toLowerCase())) {
			return this.email;	
		} 
		else if ("telefone".equals(atributo.toLowerCase())) {
			return this.telefone;
		} 
		else if ("nome".equals(atributo.toLowerCase())) {
			return this.nome;
		}
		else if ("reputacao".equals(atributo.toLowerCase())) {
			return String.valueOf(reputacao.getReputacao());
		}
		else if ("cartao".equals(atributo.toLowerCase())) {
			atualizaCartao();
			return this.cartao.getTipoCartao();
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
		String infoItem = getItem(nomeItem).getAtributo(atributo); 
		excecoesItens.atributoInvalido(infoItem);
		return infoItem;
	}
	
	/**
	 * Remove itens do inventario do usuario
	 * 
	 * @param nomeItem Representa o nome do item
	 * */
	public void removerItem(String nomeItem) {
		Item item = getItem(nomeItem);
		itens.remove(item);
	}
	
	/**
	 * Atualiza atributos do usuario
	 * 
	 * @param atributo Representa o atributo a ser atualizado
	 * @param valor Valor que substituira o antigo
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
	 * @param valor Valor que substituira o antigo
	 * */
	public void atualizarDadosItens(String nomeItem, String atributo, String valor) {
		getItem(nomeItem).atualizarAtributo(atributo, valor);;
		
	}
	
	/**
	 * Cadastra um jogo eletronico
	 * 
	 * @param nomeItem Representa o nome do jogo eletronico
	 * @param preco Representa o preço do item
	 * @param plataforma Representa a plataforma que o jogo funciona
	 * */
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		itens.add(new JogoEletronico(nomeItem, preco, plataforma));
		addReputacaoCinco(preco);
	}
	
	/**
	 * Cadastra um jogo de tabuleiro
	 * 
	 * @param nomeItem Representa o nome do jogo de tabuleiro
	 * @param preco Representa o preco do item
	 * */
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		itens.add(new JogoTabuleiro(nomeItem, preco));
		addReputacaoCinco(preco);
	}
	
	/**
	 * Informa uma peca perdida em um jogo de tabuleiro
	 * 
	 * @param nomeItem Representa o nome do jogo de tabuleiro
	 * @param nomePeca Nome da peca perdida
	 * */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		Item item = getItem(nomeItem); 
		if (item instanceof JogoTabuleiro) {
			JogoTabuleiro jogoTabuleiro = (JogoTabuleiro) item;
			jogoTabuleiro.adicionarPecaPerdida(nomePeca);
		}
	}
	
	/**
	 * Adiciona um filme em BluRay a lista de itens do usuario
	 * 
	 * @param nomeItem Representa o nome do filme em BluRay
	 * @param preco Representa o preco do item
	 * @param duracao Representa a duração do filme
	 * @param lancamento Represetna o ano de Lançamento
	 * @param genero Representa o genero do filme
	 * @param classInd Representa a classificacao indicativa do filme
	 * */
	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, int lancamento, String genero, String classInd) {
		itens.add(new Filmes(nomeItem, preco, duracao, classInd, genero, lancamento));
		addReputacaoCinco(preco);
	}

	/**
	 * Adiciona uma serie em BluRay a lista de itens do usuario
	 * 
	 * @param nomeItem Representa o nome da serie em BluRay
	 * @param preco Representa o preco do item
	 * @param descricao Representa a descricao da serie
	 * @param duracao Representa a duracao do BluRay
	 * @param classInd Representa a classificacao indicativa da srie
	 * @param genero Representa o genero da serie
	 * @param temporada Representa qual a temporada da serie
	 * */
	public void cadastrarBluraySerie(String nomeItem, double preco, String descricao, int duracao, String classInd, String genero, int temporada) {
		itens.add(new Series(nomeItem, preco, duracao, descricao, classInd, genero, temporada));
		addReputacaoCinco(preco);
	}
	
	/**
	 * Cadastra um novo episodio na temporada
	 * 
	 * @param nome Representa nome da serie
	 * @param duracao Representa a duracao do episodio
	 * */
	public void cadastrarBlurayTemporada(String nome, int duracao) {
		Item item = getItem(nome);
		if (item instanceof Series) {
			Series temporada = (Series) item;
			temporada.adicionarTemporada(duracao);			
		}
	}
	
	/**
	 * Adiciona um show em BluRay a lista de itens do usuário
	 * 
	 * @param nomeItem Representa o nome do show em BluRay
	 * @param preco Representa o preco do item
	 * @param duracao Representa a duracao do show
	 * @param faixas Quantidade de faixas que o show possui
	 * @param artista Representa a identificacao do artista
	 * @param classInd Representa a classificacao indicativa do show
	 * */
	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int faixas, String artista, String classInd) {
		itens.add(new Shows(nomeItem, preco, duracao, faixas, artista, classInd));
		addReputacaoCinco(preco);
	}
	
	/**
	 * Metodo que registra o emprestimo
	 * 
	 * @param emprestimo O emprestimo a ser adicionado
	 * */
	public void registrarEmprestimo(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}
	
	/**
	 * Checka o status do item se está emprestado ou nao
	 * 
	 * @param nomeItem Representa nome do item desejado
	 * */
	public void getStatusItem(String nomeItem) {
		excecoesItens.statusItem(getItem(nomeItem).getStatus());
	}
	
	/**
	 * Busca um emprestimo desejado
	 * 
	 * @param dono Representa dono do item
	 * @param requerente Representa requerente do item
	 * @param item Item emprestado
	 * @param dataEmprestimo Data do emprestimo
	 * 
	 * @return Retorna o emprestimo buscado
	 * */
	public Emprestimo pegaEmprestimo(Usuario dono, Usuario requerente, Item item, String dataEmprestimo) {
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDono().equals(dono) && emprestimo.getRequerente().equals(requerente) && emprestimo.getItem().equals(item)
					&& emprestimo.getDataEmprestimo().equals(dataEmprestimo)) {
				return emprestimo;
			}
		}
		return null;
	}
	
	/**
	 * Atualiza o tipo de cartao fidelidade que o usuario
	 * possui com base na sua reputacao
	 * */
	public void atualizaCartao() {
		double valorReputacao = this.reputacao.getReputacao();
		if (valorReputacao >= 0) {
			if (itens.size() == 0) {
				this.cartao = new CartaoFreeRider();
			}
			else if (valorReputacao <= 100 && itens.size() > 0) {
				this.cartao = new CartaoNoob();
			}
			else if (valorReputacao > 100) {
				this.cartao = new CartaoBomAmigo();
			}
		}
		else {
			this.cartao = new CartaoCaloteiro();
		}
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Metodo equals. Checka se um usuario e igual ao
	 * outro se tiverem o mesmo nome e mesmo numero de
	 * telefone
	 * 
	 * @param obj Objeto a ser comparado
	 * 
	 * @return Retorna um boolean informando se e o mesmo ou nao
	 * */
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
	 * Representacao em forma de String do usuario
	 * 
	 * @return String no formato nome, email, telefone
	 * */
	@Override
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}
	
}
