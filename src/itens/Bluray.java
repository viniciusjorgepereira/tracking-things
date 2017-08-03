package itens;

public abstract class Bluray extends Itens {

	protected int duracao;
	protected boolean emprestimo;
	
	public Bluray(String nome, int duracao, double valor) {
		super(nome, valor);
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Bluray))
			return false;
		Bluray other = (Bluray) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
