package itens;

public class JogoEletronico extends Item {
	private Plataforma plataforma;

	public JogoEletronico(String nome, Double preco, String plataforma) {
		super(nome, preco);
		this.plataforma = Plataforma.valueOf(plataforma.toUpperCase());
	}

	@Override
	public String getAtributo(String atributo) {
		if ("preco".equals(atributo.toLowerCase())) {
			return super.getPrecoString();
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			return this.nome;
			
		} else if ("plataforma".equals(atributo.toLowerCase())) {
			return this.plataforma.getValor();
			
		}
		return null;
	}
	
	@Override
	public void atualizarAtributo(String atributo, String valor) {
		if ("preco".equals(atributo.toLowerCase())) {
			this.preco = Double.parseDouble(valor);
			
		} else if ("nome".equals(atributo.toLowerCase())) {
			this.nome = valor;
			
		} else if ("plataforma".equals(atributo.toLowerCase())) {
			this.plataforma = Plataforma.valueOf(valor.toUpperCase());
		}
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
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
		JogoEletronico other = (JogoEletronico) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + this.nome + ", R$ " + super.getPrecoString() + ", " +
				super.getStatusString() + ", " + this.plataforma.getValor();
	}
}
