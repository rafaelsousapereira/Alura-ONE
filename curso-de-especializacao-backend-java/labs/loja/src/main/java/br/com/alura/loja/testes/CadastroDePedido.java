package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import br.com.alura.loja.vo.RelatorioDeVendasVO;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDadosComClienteProdutoPedido();
	}

	public static void popularBancoDeDadosComClienteProdutoPedido() {
		CadastroDeProdutos.popularBancoDeDados();

		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		ClienteDAO clienteDAO = new ClienteDAO(entityManager);

		Produto produto = produtoDAO.buscarPorId(1L);
		Produto produto2 = produtoDAO.buscarPorId(2L);
		Produto produto3 = produtoDAO.buscarPorId(3L);
		
		Cliente cliente = clienteDAO.buscarPorId(1L);

		entityManager.getTransaction().begin();

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedido.adicionarItem(new ItemPedido(40, pedido, produto2));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(2, pedido2, produto3));

		PedidoDAO pedidoDAO = new PedidoDAO(entityManager);
		pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);

		entityManager.getTransaction().commit();
		
		List<RelatorioDeVendasVO> relatorioDeVendas = pedidoDAO.relatorioDeVendas();
		relatorioDeVendas.stream().forEach(System.out::println);
		
		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("VALOR TOTAL: " + totalVendido);
	}

}
