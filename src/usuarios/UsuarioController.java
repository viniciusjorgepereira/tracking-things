package usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import itens.Itens;
import usuarios.IdUsuario;

public class UsuarioController {

	private ExcecoesUsuario excecoes;
	private Map<IdUsuario, Usuario> usuarios;
	

	public UsuarioController() {
		this.usuarios = new HashMap<>();
		this.excecoes = new ExcecoesUsuario();
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
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).removerItem(nomeItem);
	}

	public String pesquisarUsuario(String nome, String telefone) {
		IdUsuario id = new IdUsuario(nome, telefone);
		return usuarios.get(id).toString();
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

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).cadastrarEletronico(nomeItem, preco, plataforma);
	}
	
	
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).cadastrarJogoTabuleiro(nomeItem, preco);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).adicionarPecaPerdida(nomeItem, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).cadastrarBlurayFilme(nomeItem, preco, duracao, anoLancamento, genero, classificacao);			
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).cadastrarBlurayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).cadastrarBluraySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}
	
	public ArrayList<Itens> getTodosItens() {
		ArrayList<Itens> itens = new ArrayList<>();
		
		for (Usuario usuario : usuarios.values()) {
			itens.addAll(usuario.getTodosItens());
		}
		
		return itens;
	}

	public String detalhesItem(String nome, String telefone, String nomeItem) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		return usuarios.get(id).getDetalhesItem(nomeItem);
		
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		return usuarios.get(id).getInfoItem(nomeItem, atributo);
		
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		IdUsuario id = new IdUsuario(nome, telefone);
		excecoes.usuarioInvalido(usuarios.containsKey(id));
		usuarios.get(id).atualizarDadosItens(nomeItem, atributo, valor);
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		IdUsuario idDono = new IdUsuario(nomeDono, telefoneDono);
		IdUsuario idRequerente = new IdUsuario(nomeRequerente, telefoneRequerente);
		
		excecoes.usuarioInvalido(usuarios.containsKey(idRequerente));
		excecoes.usuarioInvalido(usuarios.containsKey(idDono));
		
		usuarios.get(idDono).emprestar(idDono, idRequerente, nomeItem, dataEmprestimo, periodo);
		usuarios.get(idRequerente).receberEmprestimo(idDono, idRequerente, nomeItem, dataEmprestimo, periodo);
		usuarios.get(idDono).atualizarDadosItens(nomeItem, "Status", "true");
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		IdUsuario idDono = new IdUsuario(nomeDono, telefoneDono);
		IdUsuario idRequerente = new IdUsuario(nomeRequerente, telefoneRequerente);
		
		excecoes.usuarioInvalido(usuarios.containsKey(idRequerente));
		excecoes.usuarioInvalido(usuarios.containsKey(idDono));
		
		usuarios.get(idDono).devolverItem(idRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		usuarios.get(idRequerente).devolverItem(idRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		usuarios.get(idDono).atualizarDadosItens(nomeItem, "Status", "false");
		
		
		
		
	}
}
