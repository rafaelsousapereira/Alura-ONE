package br.com.bytebanco.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebanco.banco.modelo.Conta;
import br.com.bytebanco.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {

	public static void main(String[] args) {
		
		ArrayList<Conta> lista = new ArrayList<>();
		
//		Conta cc1 = new ContaCorrente(11, 22);
//		Conta cc2 = new ContaCorrente(11, 22);
//		
//		System.out.println(cc1.ehIgual(cc2));
		
		Conta cc1 = new ContaCorrente(11, 22);
		lista.add(cc1);
		
		Conta cc2 = new ContaCorrente(12, 23);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(12, 23);
		
		boolean existe = lista.contains(cc3);
		System.out.println("Já existe: " + existe);

		for (Conta conta: lista) {
			System.out.println(conta);
		}
	}

}
