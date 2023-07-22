package br.com.bytebanco.banco.teste;

import br.com.bytebanco.banco.modelo.ContaCorrente;
import br.com.bytebanco.banco.modelo.ContaPoupanca;

public class TesteArrayReferencias {

	public static void main(String[] args) {
		
		Object[] referencias = new Object[5];
		
		ContaCorrente cc1 = new ContaCorrente(1, 1);
		referencias[0] = cc1;
		
		ContaPoupanca cp2 = new ContaPoupanca(2, 2);
		referencias[1] = cp2;
		
//		Object referenciaGenerica = referencias[1];
//		
//		System.out.println( referencias.getNumero() );
		
		// Destrinchando a chamada: contas[0].getNumero();
		ContaPoupanca ref = (ContaPoupanca) referencias[1]; // type cast
		System.out.println(cp2.getNumero());
		System.out.println(ref.getNumero());
	}

}
