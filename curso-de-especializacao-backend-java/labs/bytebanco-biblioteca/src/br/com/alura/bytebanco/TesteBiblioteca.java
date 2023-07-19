package br.com.alura.bytebanco;

import br.com.bytebanco.banco.modelo.Conta;
import br.com.bytebanco.banco.modelo.ContaCorrente;

public class TesteBiblioteca {

	public static void main(String[] args) {
		
		Conta conta = new ContaCorrente(123, 321);
		conta.deposita(1000.0);
		
		System.out.println(conta.getSaldo());
	}

}
