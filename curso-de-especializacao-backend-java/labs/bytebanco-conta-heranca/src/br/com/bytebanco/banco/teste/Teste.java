package br.com.bytebanco.banco.teste;

import br.com.bytebanco.banco.modelo.ContaCorrente;
import br.com.bytebanco.banco.modelo.ContaPoupanca;

public class Teste {

	public static void main(String[] args) {
		
		Object cc = new ContaCorrente(11, 12);
		Object cp = new ContaPoupanca(22, 23);

		System.out.println(cc);
		System.out.println(cp);
		
//		print(cc);
	}
	
	public static void print(Object ref) {}

}
