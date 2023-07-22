package br.com.bytebanco.banco.teste;

import br.com.bytebanco.banco.modelo.ContaCorrente;

public class TesteArrayReferencias {

	public static void main(String[] args) {
		
		ContaCorrente[] contas = new ContaCorrente[5];
		
		ContaCorrente cc1 = new ContaCorrente(1, 1);
		contas[0] = cc1;
		
		ContaCorrente cc2 = new ContaCorrente(2, 2);
		contas[1] = cc2;
		
		System.out.println( contas[0].getNumero() );
		
		// Destrinchando a chamada: contas[0].getNumero();
		ContaCorrente ref = contas[0];
		System.out.println(ref.getNumero());
	}

}
