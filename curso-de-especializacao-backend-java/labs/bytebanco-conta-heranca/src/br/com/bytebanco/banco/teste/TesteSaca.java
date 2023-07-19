package br.com.bytebanco.banco.teste;

import br.com.bytebanco.banco.exceptions.SaldoInsuficienteException;
import br.com.bytebanco.banco.modelo.Conta;
import br.com.bytebanco.banco.modelo.ContaCorrente;

public class TesteSaca {

	public static void main(String[] args) {

		Conta conta = new ContaCorrente(123, 321);

		conta.deposita(200.0);
		try {
			conta.saca(210.0);
		} catch (SaldoInsuficienteException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}

		System.out.println(conta.getSaldo());
	}
}
