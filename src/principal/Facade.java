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
		 * */
		public Facade() {
			system = new SystemController();			
		}
		
		/**
		 * Metodo que inicia o sistema
		 * */
		public void iniciarSistema() {
		}
		
		/**
		 * Inicio de Caso de uso 1: CRUD dos usuarios
		 */
		public void cadastrarUsuario(String nome, String telefone, String email) {
			system.cadastrarUsuario(nome, telefone, email);
		}
		
		public void removerUsuario(String nome, String telefone) {
			system.removerUsuario(nome, telefone);
		}
		
		public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
			system.atualizarUsuario(nome, telefone, atributo, valor);
		}
		
		public String getInfoUsuario(String nome, String telefone, String atributo) {
			return system.getInfoUsuario(nome, telefone, atributo);
		}
		/**
		 * Fim do caso 1
		 * */
		
		
		/**
		 * Inicio do Caso de uso 2: CRUD dos itens emprestaveis
		 */
		public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
			system.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
		}

		public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
			system.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
		}
		
		public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
			system.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
		}
		
		public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
			system.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		}
		
		public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int nomeroFaixas, String artista, String classificacao) {
			system.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, nomeroFaixas, artista, classificacao);
		}
		
		public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
			system.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		}
		
		public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
			system.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
		}
		
		public void removerItem(String nome, String telefone, String nomeItem) {
			system.removerItem(nome, telefone, nomeItem);
		}
		
		public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
			system.atualizarItem(nome, telefone, nomeItem, atributo, valor);
		}
		
		public String getInfoItem(String nome, String telefone, String nomeItem,String atributo) {
			return system.getInfoItem(nome, telefone, nomeItem, atributo);
		}
		/**
		 * Fim do caso 2
		 * */
		
		
		/**
		 * Inicio de Caso de uso 3: funcionalidades de pesquisa
		 */
		public String listarItensOrdenadosPorNome() {
			return system.listarItensOrdenadosPorNome();
		}
		
		public String listarItensOrdenadosPorValor() {
			return system.listarItensOrdenadosPorValor();
		}
		
		public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
			return system.pesquisarDetalhesItem(nome, telefone, nomeItem);
		}
		/**
		 * Fim do caso 3
		 * */
		
		
		/**
		 * Inicio do Caso de uso 4: criacao de emprestimos
		 */
		public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
			system.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
		}
		
		public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) {
			system.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		}
		/**
		 * Fim do caso 4
		 * */
		
		/**
		 * Metodo que fecha o sistema
		 * */
		public void fecharSistema(){
		}
}
