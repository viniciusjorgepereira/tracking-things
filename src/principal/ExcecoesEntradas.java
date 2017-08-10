/**
 * Classe responsavel por lancar as excecoes no sistema.
 * */

package principal;

public class ExcecoesEntradas {
	
	/**
	 * Valida o nome dos usuarios e o telefone para o ID
	 * 
	 * @param nome O possivel nome do usuario
	 * @param telefone O possivel telefone do usuario
	 * */
	public void dadosInvalidos(String nome, String telefone) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome nao pode ser nulo ou vazio.");
			
		} else if (telefone == null || telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Telefone nao pode ser nulo ou vazio.");
		}
	}
	
	/**
	 * Valida o nome dos usuario, telefone d email para o
	 * cadastro
	 * 
	 * @param nome O possivel nome do usuario
	 * @param telefone O possivel telefone do usuario
	 * @param email O possivel email do usuario
	 * */
	public void dadosInvalidos(String nome, String telefone, String email) {
		dadosInvalidos(nome, telefone);
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Email nao pode ser nulo ou vazio.");
		}
	}
	
	/**
	 * Valida o nome dos usuario, telefone e uma possivel entrada
	 * 
	 * @param nome O possivel nome do usuario
	 * @param telefone O possivel telefone do usuario
	 * @param entrada Possivel entrada feita pelo usuario
	 * @param msg Mensagem de complemento
	 * */
	public void dadosInvalidos(String nome, String telefone, String entrada, String msg) {
		dadosInvalidos(nome, telefone);
		if (entrada == null || entrada.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + " nao pode ser nulo ou vazio.");
		}
	}
	
	/**
	 * Valida entradas feitas no sistema
	 * 
	 * @param nome O possivel nome do usuario
	 * @param telefone O possivel telefone do usuario
	 * @param entrada1 Uma entrada realizada
	 * @param entrada2 Uma outra entrada
	 * @param msg1 Mensagem de complemento 1
	 * @param msg2 Mensagem de complemento 2
	 * */
	public void dadosInvalidos(String nome, String telefone, String entrada1, String entrada2, String msg1, String msg2) {
		dadosInvalidos(nome, telefone, entrada1, msg1);
		if (entrada2 == null || entrada2.trim().isEmpty()) {
			throw new IllegalArgumentException(msg2 + " nao pode ser nulo ou vazio.");
		}

	}
	
	/**
	 * Valida numero double
	 * 
	 * @param numero Numero a ser validado
	 * @param msg Mensagem de complemento
	 * */
	public void numeroInvalido(String msg, double numero) {
		if (numero < 0) {
			throw new IllegalArgumentException(msg + " invalido");
		}
	}
	
	/**
	 * Valida entrada
	 * 
	 * @param msg Mensagem de complemento
	 * @param entrada Entrada a ser validada
	 * */
	public void outrosDadosInvalidos(String msg, String entrada) {
		if (entrada == null || entrada.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + " nao pode ser nulo ou vazio.");
		}
	}

	/**
	 * Valida entrada de atributos
	 * 
	 * @param entrada Entrada a ser validada
	 * @param valor Valor a ser validado
	 * */
	public void valorInvalido(String entrada, String valor) {
		outrosDadosInvalidos(entrada, valor);
		String atributo = entrada.substring(0,1).toUpperCase() + entrada.substring(1);
		
		if ("Preco".equals(atributo) || "Duracao".equals(atributo) || "Lancamento".equals(atributo) 
				|| "Temporada".equals(atributo) || "Episodios".equals(atributo) || "Faixas".equals(atributo)) {
			
			double preco = Double.parseDouble(valor);
			if (preco < 0) {
				throw new IllegalArgumentException(atributo + " invalido");
			}
		}
	}


}
