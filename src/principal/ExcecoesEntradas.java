package principal;

public class ExcecoesEntradas {
	
	public void dadosInvalidos(String nome, String telefone) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome nao pode ser nulo ou vazio.");
			
		} else if (telefone == null || telefone.trim().isEmpty()) {
			throw new IllegalArgumentException("Telefone nao pode ser nulo ou vazio.");
		}
	}
	
	public void dadosInvalidos(String nome, String telefone, String email) {
		dadosInvalidos(nome, telefone);
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Email nao pode ser nulo ou vazio.");
		}
	}
	
	public void dadosInvalidos(String nome, String telefone, String entrada, String msg) {
		dadosInvalidos(nome, telefone);
		if (entrada == null || entrada.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + " nao pode ser nulo ou vazio.");
		}
	}
	
	public void dadosInvalidos(String nome, String telefone, String entrada1, String entrada2, String msg1, String msg2) {
		dadosInvalidos(nome, telefone, entrada1, msg1);
		if (entrada2 == null || entrada2.trim().isEmpty()) {
			throw new IllegalArgumentException(msg2 + " nao pode ser nulo ou vazio.");
		}

	}
	
	public void numeroInvalido(String msg, double numero) {
		if (numero < 0) {
			throw new IllegalArgumentException(msg + " invalido");
		}
	}
	
	public void outrosDadosInvalidos(String msg, String entrada) {
		if (entrada == null || entrada.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + " nao pode ser nulo ou vazio.");
		}
	}

	public void valorInvalido(String atributo, String valor) {
		outrosDadosInvalidos(atributo, valor);
		
		if (atributo.equals("Preco")) {
			double preco = Double.parseDouble(valor);
			if (preco < 0) {
				throw new IllegalArgumentException("Preco invalido");
			}
		}
	}


}
