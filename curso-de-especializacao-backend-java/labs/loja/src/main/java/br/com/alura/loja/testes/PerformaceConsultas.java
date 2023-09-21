package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.util.JPAUtil;

public class PerformaceConsultas {

	public static void main(String[] args) {

		CadastroDePedido.popularBancoDeDadosComClienteProdutoPedido();
		EntityManager entityManager = JPAUtil.getEntityManager();

		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		Pedido pedido = pedidoDAO.buscarPedidoComCliente(1L);

		entityManager.close();

		System.out.println(pedido.getCliente().getNome());

	}

}
