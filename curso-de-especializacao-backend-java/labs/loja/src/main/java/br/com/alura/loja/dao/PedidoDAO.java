package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;

public class PedidoDAO {

	private EntityManager entityManager;

	public PedidoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Pedido pedido) {
		this.entityManager.persist(pedido);
	}

	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return entityManager.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

	public List<Object[]> relatorioDeVendas() {
		String jpql = "SELECT produto.nome, " + "SUM(item.quantidade), " + "MAX(pedido.data) " + "FROM Pedido pedido "
				+ "JOIN pedido.itens item " + "JOIN item.produto produto " + "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		return entityManager.createQuery(jpql, Object[].class).getResultList();
	}
}
