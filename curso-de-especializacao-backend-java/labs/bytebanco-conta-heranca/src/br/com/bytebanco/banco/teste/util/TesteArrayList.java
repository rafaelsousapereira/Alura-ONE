package br.com.bytebanco.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebanco.banco.modelo.Conta;
import br.com.bytebanco.banco.modelo.ContaCorrente;

public class TesteArrayList {

	public static void main(String[] args) {
		
		// Generics
		ArrayList<Conta> lista = new ArrayList<>();
		
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Mario");
		
		Conta cc1 = new ContaCorrente(11, 22);
		lista.add(cc1);
		
		Conta cc2 = new ContaCorrente(12, 23);
		lista.add(cc2);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta ref = lista.get(0);
		System.out.println(ref.getNumero());
		
		lista.remove(0);

		System.out.println("Tamanho: " + lista.size());
		
		Conta cc3 = new ContaCorrente(13, 24);
		lista.add(cc3);
		
		Conta cc4 = new ContaCorrente(14, 25);
		lista.add(cc4);
		
		for (int i = 0; i < lista.size(); i++) {
			Object oRef = lista.get(i);
			System.out.println(oRef);
		}
		
		System.out.println("---------------");
		
		for (Conta oRef : lista) {
			System.out.println(oRef);
		}
	}

}
