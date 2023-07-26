package br.com.bytebanco.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {

	public static void main(String[] args) {
		
		Integer idadeRef = Integer.valueOf(29);
		System.out.println(idadeRef.doubleValue());
		
		System.out.println(Integer.MAX_VALUE);
		
		String s = args[0];
//		int numero = Integer.valueOf(s);
		int numero = Integer.parseInt(s);
		System.out.println(numero);
		
		List<Integer> numeros = new ArrayList<>();
		numeros.add(29); // Autoboxing
		
		// Autoboxing
		Integer ref = Integer.valueOf("3");
		ref++;
		System.out.println(ref);
		
		// Unboxing
		int valor = ref.intValue();
		valor = valor + 1;
		System.out.println(valor);
	}

}
