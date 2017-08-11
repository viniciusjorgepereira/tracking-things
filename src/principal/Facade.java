/**
 * Classe Facade
 * */

package principal;

import easyaccept.EasyAccept;

public class Facade {
		private SystemController system;
		
		public static void main(String[] args) {
			args = new String[] { "principal.Facade", "testes_aceitacao/us1_test.txt", "testes_aceitacao/us2_test.txt",
					"testes_aceitacao/us3_test.txt", "testes_aceitacao/us4_test.txt"};
			EasyAccept.main(args);
		}

		/**
		 * Constroi uma Facade e inicia o Controlador do sistema
		 */
		public Facade() {
			system = new SystemController();			
		}
		
		/**
		 * Metodo que inicia o sistema
		 */
		public void iniciarSistema() {
		}
		
		/**
		 * Invoca metodo de cadastrar usuarios
		 * 
		 * @param nome Representa o nome do usuario
		 * @param telefone Representa o telefone do usuario
		 * @param email Representa o email do usuario
		 */
		public void cadastrarUsuario(String nome, String telefone, String email) {
			system.cadastrarUsuario(nome, telefone, email);
		}
		
		/**
		 * Invoca metodo para remocao de  usuarios
		 * 
		 * @param nome Representa o nome do usuario a ser removido
		 * @param telefone Representa o telefone do usuario a ser removido
		 */
		public void removerUsuario(String nome, String telefone) {
			system.removerUsuario(nome, telefone);
		}
		
		/**
		 * Invoca metodo de atualizar um usuario
		 * 
		 * @param nome Representa o nome do usuario a ser atualizado
		 * @param telefone Representa o telefone do usuario a ser atualizado
		 * @param atributo Representa o atributo a ser atualizado
		 * @param valor Representa o valor que substituira o antigo
		 */
		public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
			system.atualizarUsuario(nome, telefone, atributo, valor);
		}
		
		/**
		 * Resgata informaoes do usuario
		 * 
		 * @param nome Representa o nome do usuario
		 * @param telefone Representa o telefone do usuario
		 * @param atributo Atributo que sera retornado
		 * 
		 * @return O atributo desejado em forma de String
		 */
		public String getInfoUsuario(String nome, String telefone, String atributo) {
			return system.getInfoUsuario(nome, telefone, atributo);
		}
		
		/**
		 * Invoca metodo de cadastrar um jogo eletronico
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item que sera cadastrado
		 * @param preco Representa o preco do item
		 * @param plataforma Plataforma que o jogo funciona
		 */
		public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
			system.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
		}

		/**
		 * Invoca metodo de cadastrar um jogo de tabuleiro
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item que sera cadastrado
		 * @param preco Representa o preco do item
		 */
		public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
			system.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
		}
		
		/**
		 * Invoca metodo de adicionar uma peca perdida ao
		 * jogo de tabuleiro
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item
		 * @param nomePeca Representa o nome da peca perdida
		 */
		public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
			system.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
		}
		
		/**
		 * Invoca metodo de cadastrar um filme em BluRay
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item que sera cadastrado
		 * @param preco Representa o preco do item
		 * @param duracao Duracao total do filme
		 * @param genero Indica o genero do filme
		 * @param classificacao Indica a classificacao indicativa do filme
		 * @param anoLancamento Indica ano de Lancamento do filme
		 */
		public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
			system.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		}
		
		/**
		 * Invoca metodo de cadastrar um show em BluRay
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item que sera cadastrado
		 * @param preco Representa o preco do item
		 * @param duracao Duracao total do filme
		 * @param numeroFaixas A quantidade de faixas presentes
		 * @param artista O artista que produziu o show
		 * @param classificacao Indica a classificacao indicativa do show
		 */
		public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
			system.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		}
		
		/**
		 * Invoca metodo de cadastrar uma serie em BluRay
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item que sera cadastrado
		 * @param preco Representa o preco do item
		 * @param descricao Apresenta uma descricao da serie
		 * @param duracao Duracao total da serie
		 * @param classificacao Indica a classificacao indicativa da serie
		 * @param genero Indica o genero da serie
		 * @param temporada Identifica a temporada da serie
		 */
		public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
			system.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		}
		
		/**
		 * Invoca metodo de adicionar um bluray na serie
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeBlurayTemporada Nome do Bluray a ser adicionado
		 * @param duracao Indica a duracao do bluray adicionado
		 */
		public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
			system.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
		}
		
		/**
		 * Invoca metodo de remover item
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item que sera removido
		 */
		public void removerItem(String nome, String telefone, String nomeItem) {
			system.removerItem(nome, telefone, nomeItem);
		}
		
		/**
		 * Invoca metodo de para atualizar atributo dos itens
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item a ser alterado
		 * @param atributo Indica qual atributo sera alterado
		 * @param valor Valor que substituira o antigo
		 */
		public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
			system.atualizarItem(nome, telefone, nomeItem, atributo, valor);
		}
		
		/**
		 * Recupera informacao dos itens
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item que sera consultado
		 * @param atributo Indica qual atributo sera retornado
		 * 
		 * @return Retorna uma string como atributo consultado
		 */
		public String getInfoItem(String nome, String telefone, String nomeItem,String atributo) {
			return system.getInfoItem(nome, telefone, nomeItem, atributo);
		}
		
		/**
		 * Ordena os itens existentes por nome
		 * 
		 * @return Itens listados por ordem alfabetica
		 */
		public String listarItensOrdenadosPorNome() {
			return system.listarItensOrdenadosPorNome();
		}
		
		/**
		 * Ordena os itens existentes por valor
		 * 
		 * @return Itens listados por ordem de preco
		 */
		public String listarItensOrdenadosPorValor() {
			return system.listarItensOrdenadosPorValor();
		}
		
		/**
		 * Invoca metodo para retornar detalhes do item buscado
		 * 
		 * @param nome Representa o nome do usuario (dono)
		 * @param telefone Representa o telefone do usuario (dono)
		 * @param nomeItem Representa o nome do item a ser consultado
		 * 
		 * @return Uma string com os detalhes do item buscado
		 */
		public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
			return system.pesquisarDetalhesItem(nome, telefone, nomeItem);
		}
		
		/**
		 * Invoca metodo de para atualizar atributo dos itens
		 * 
		 * @param nomeDono Representa o nome do dono do item
		 * @param telefoneDono Representa o telefone do dono do item
		 * @param nomeRequerente Representa o nome do requerente do item
		 * @param telefoneRequerente Representa o telefone do requerente do item
		 * @param nomeItem Representa o nome do item a ser emprestado
		 * @param dataEmprestimo Data em que ocorreu o emprestimo
		 * @param periodo Periodo de dias que o item ficara com o requerente
		 */
		public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
			system.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
		}
		
		/**
		 * Invoca metodo de para atualizar atributo dos itens
		 * 
		 * @param nomeDono Representa o nome do dono do item
		 * @param telefoneDono Representa o telefone do dono do item
		 * @param nomeRequerente Representa o nome do requerente do item
		 * @param telefoneRequerente Representa o telefone do requerente do item
		 * @param nomeItem Representa o nome do item a ser emprestado
		 * @param dataEmprestimo Data em que ocorreu o emprestimo
		 * @param dataDevolucao Data de devolucao do item
		 */
		public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) {
			system.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		}
		
		/**
		 * Metodo que fecha o sistema
		 */
		public void fecharSistema(){
		}
}
