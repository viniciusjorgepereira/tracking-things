package cartoes;

public interface CartaoFidelidade {;
	
	public abstract String getTipoCartao();
	
	public abstract boolean permicaoEmprestimo();
	
	public abstract int diasMaximoEmprestimo();

}
