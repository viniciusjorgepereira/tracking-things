package itens;

public class Shows extends Bluray{

	private int faixas;
	private String artista;
	
	public Shows(String nome, double preco, int duracao, int faixas, String artista, String classInd) {
		super(nome, preco, duracao, classInd);
		this.faixas = faixas;
		this.artista = artista;	
	}

	@Override
	public String getAtributo(String atributo) {
		if ("preco".equals(atributo.toLowerCase())) {
			return super.getPrecoString();
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			return this.nome;
			
		} else if ("emprestimo".equals(atributo.toLowerCase())) {
			return super.getStatusString();
			
		} else if ("duracao".equals(atributo.toLowerCase())) {
			return this.duracao + " min";
			
		} else if ("classificacao".equals(atributo.toLowerCase())) {
			return this.classind.getValor();

		} else if ("faixas".equals(atributo.toLowerCase())) {
			return String.valueOf(this.faixas);
			
		} else if ("artista".equals(atributo.toLowerCase())) {
			return this.artista;
			
		}
		return null;
	}
	
	@Override
	public void atualizarAtributo(String atributo, String valor) {
		if ("preco".equals(atributo.toLowerCase())) {
			 this.preco = Double.parseDouble(valor);
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			 this.nome = valor;

		} else if ("duracao".equals(atributo.toLowerCase())) {
			 this.duracao = Integer.parseInt(valor);
			
		} else if ("classificacao".equals(atributo.toLowerCase())) {
			 this.classind = ClassificacaoIndicativa.valueOf(valor.toUpperCase());

		} else if ("faixas".equals(atributo.toLowerCase())) {
			this.faixas = Integer.parseInt(valor);
			
		} else if ("artista".equals(atributo.toLowerCase())) {
			this.artista = valor;
		}
	}
	
	@Override
	public String toString() {
		return "SHOW: "+ nome + ", R$ " + super.getPrecoString() + ", " + super.getStatusString() + ", " + duracao + 
				" min, " + classind.getValor() + ", " + artista + ", " + faixas + " faixas";
	}

}
