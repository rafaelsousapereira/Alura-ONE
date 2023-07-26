package br.com.bytebanco.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {

	public static void main(String[] args) {
		
		Integer idadeRef = Integer.valueOf(29); // autoboxing
		System.out.println(idadeRef.intValue()); // unboxing
		
		Double dRef = Double.valueOf(2.3); // autoboxing
		System.out.println(dRef.doubleValue()); // unboxing
		
		Boolean bRef = Boolean.FALSE; // autoboxing
		System.out.println(bRef.booleanValue()); // unboxing
		
		Number refNumero = Integer.valueOf(30);
		
		List<Number> lista = new ArrayList<>();
		lista.add(10);
		lista.add(refNumero);
		lista.add(dRef);
		lista.add(idadeRef);
		
		for (Number num : lista) {
			System.out.println(num);	
		}
	}

}
