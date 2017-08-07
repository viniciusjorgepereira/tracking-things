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

	public Itens getItem(String nome) {
		for (Itens item : itens) {
			if (item.getNome().equals(nome)) {
				return item;
			}
		}
		excecoesItens.itemNotFound();
		return null;
	}
	
	public String getDetalhesItem(String nome) {
		return getItem(nome).toString();
	}
	
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

	public String getInfoItem(String nomeItem, String atributo) {
		return getItem(nomeItem).getAtributo(atributo);
	}
	
	public void removerItem(String nomeItem) {
		Itens item = getItem(nomeItem);
		itens.remove(item);
	}
	
	public void atualizarDadosUsuario(String atributo, String valor) {
		if ("email".equals(atributo.toLowerCase())) {
			this.email = valor;
			
		} else if ("telefone".equals(atributo.toLowerCase())) {
			this.telefone = valor;
		}
	}

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
	
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		excecoesItens.precoInvalido(preco);
		itens.add(new JogoEletronico(nomeItem, preco, plataforma));
	}
	
	public void cadastrarJogoTabuleiro(String nomeItem, double preco) {
		excecoesItens.precoInvalido(preco);
		itens.add(new JogoTabuleiro(nomeItem, preco));
	}
	
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		Itens item = getItem(nomeItem); 
		if (item instanceof JogoTabuleiro) {
			JogoTabuleiro jogoTabuleiro = (JogoTabuleiro) item;
			jogoTabuleiro.adicionarPecaPerdida(nomePeca);
		}
	}
	
	public void cadastrarBlurayFilme(String nomeItem, double preco, int duracao, int lancamento, String genero,
			String classind) {
		excecoesItens.precoInvalido(preco);
		itens.add(new Filmes(nomeItem, preco, duracao, classind, genero, lancamento));
	}

	public void cadastrarBluraySerie(String nomeItem, double preco, String descricao, int duracao, String classInd,
			String genero, int temporada) {
		excecoesItens.precoInvalido(preco);
		itens.add(new Series(nomeItem, preco, duracao, descricao, classInd, genero, temporada));
	}
	
	public void cadastrarBlurayShow(String nomeItem, double preco, int duracao, int faixas, String artista,
			String classInd) {
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

	@Override
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}


}
