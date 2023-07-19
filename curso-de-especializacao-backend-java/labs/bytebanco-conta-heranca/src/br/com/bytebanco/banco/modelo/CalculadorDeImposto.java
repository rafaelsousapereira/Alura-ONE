package br.com.bytebanco.banco.modelo;

public class CalculadorDeImposto {

	private double totalImposto;

	public void registra(Tributavel tributavel) {
		double valor = tributavel.getValorImposto();
		this.totalImposto += valor;
	}

	public double getValorImposto() {
		return totalImposto;
	}
}
