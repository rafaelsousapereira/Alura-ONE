package br.com.bytebanco.banco.teste;

import br.com.bytebanco.banco.modelo.Conta;
import br.com.bytebanco.banco.modelo.ContaCorrente;
import br.com.bytebanco.banco.modelo.GuardadorDeContas;

public class TesteGuardadorDeContas {

	public static void main(String[] args) {
		
		GuardadorDeContas guardador = new GuardadorDeContas();
		
		Conta cc1 = new ContaCorrente(11, 22);
		guardador.adiciona(cc1);
		
		Conta cc2 = new ContaCorrente(12, 23);
		guardador.adiciona(cc2);
		
		int tamanho = guardador.getQuantidadeDeElementos();
		System.out.println(tamanho);
		
		Conta ref = guardador.getReferencia(1);
		System.out.println(ref.getNumero());
	}

}
