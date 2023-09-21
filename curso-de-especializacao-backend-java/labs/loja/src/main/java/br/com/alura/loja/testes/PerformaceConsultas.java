package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.util.JPAUtil;

public class PerformaceConsultas {

	public static void main(String[] args) {

		CadastroDePedido.popularBancoDeDadosComClienteProdutoPedido();
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		Pedido pedido = entityManager.find(Pedido.class, 1L);
		System.out.println(pedido.getData());
		System.out.println(pedido.getItens().size());

	}

}
