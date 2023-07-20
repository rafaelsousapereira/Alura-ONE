package br.com.bytebanco.banco.teste;

public class TesteString {

	public static void main(String[] args) {
		
		String vazio = " Alura ";
		
		System.out.println(vazio.contains("Alu"));
		
		String outroVazio = vazio.trim();
		System.out.println(outroVazio.isEmpty());
		
		String nome = "Alura";
		
		System.out.println(nome.length());
		
		for (int i = 0; i < nome.length(); i++) {
			System.out.println(nome.charAt(i));
		}
		
//		String sub = nome.substring(1);
//		System.out.println(sub);
		
//		int posicao = nome.indexOf("ur");
//		System.out.println(posicao);
		
//		char c = nome.charAt(3);
//		System.out.println(c);

//		char c = 'A';
//		char d = 'a';
//		String outra = nome.replace(c, d);
		
//		String outra = nome.toLowerCase();
//		System.out.println(outra);
	}

}
