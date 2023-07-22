package br.com.bytebanco.banco.modelo;

public class GuardadorDeContasGenerico {

	private Object[] referencia;
	private int posicaoLivre;
	
	public GuardadorDeContasGenerico() {
		this.referencia = new Object[10];
		this.posicaoLivre = 0;
	}

	public void adiciona(Object ref) {
		this.referencia[this.posicaoLivre] = ref;
		this.posicaoLivre++;
	}

	public int getQuantidadeDeElementos() {
		return this.posicaoLivre;
	}

	public Object getReferencia(int posicao) {
		return this.referencia[posicao];
	}
}
