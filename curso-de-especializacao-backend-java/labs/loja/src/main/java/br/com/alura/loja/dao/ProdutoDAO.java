package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDAO {

	private EntityManager entityManager;

	public ProdutoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Produto produto) {
		this.entityManager.persist(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return entityManager.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return entityManager.createQuery(jpql, Produto.class).getResultList();
	}

}
