package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		CadastroDeProdutos.popularBancoDeDados();

		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		ClienteDAO clienteDAO = new ClienteDAO(entityManager);

		Produto produto = produtoDAO.buscarPorId(1L);
		Cliente cliente = clienteDAO.buscarPorId(1L);

		entityManager.getTransaction().begin();

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));

		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		pedidoDAO.cadastrar(pedido);

		entityManager.getTransaction().commit();

		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("VALOR TOTAL: " + totalVendido);
	}

}
