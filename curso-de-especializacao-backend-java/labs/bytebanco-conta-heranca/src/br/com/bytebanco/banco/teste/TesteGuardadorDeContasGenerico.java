package br.com.bytebanco.banco.teste;

import br.com.bytebanco.banco.modelo.Cliente;
import br.com.bytebanco.banco.modelo.Conta;
import br.com.bytebanco.banco.modelo.ContaCorrente;
import br.com.bytebanco.banco.modelo.ContaPoupanca;
import br.com.bytebanco.banco.modelo.GuardadorDeContasGenerico;

public class TesteGuardadorDeContasGenerico {

	public static void main(String[] args) {
		
		GuardadorDeContasGenerico guardador = new GuardadorDeContasGenerico();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Maria");
		guardador.adiciona(cliente);
		
		Conta cc = new ContaCorrente(11, 22);
		guardador.adiciona(cc);
		
		Conta cp = new ContaPoupanca(11, 12);
		guardador.adiciona(cp);

		
		int tamanho = guardador.getQuantidadeDeElementos();
		System.out.println("Quantidade de elementos = " + tamanho);
		
		Cliente ref1 = (Cliente) guardador.getReferencia(0);
		System.out.println(ref1.getNome());
		
		Conta ref2 = (ContaCorrente) guardador.getReferencia(1);
		System.out.println(ref2.getNumero());
		
		Conta ref3 = (ContaPoupanca) guardador.getReferencia(2);
		System.out.println(ref3.getNumero());
	}

}
