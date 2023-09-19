package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		Produto celular = new Produto("Xaomi Redmi", "Muito legal", new BigDecimal("800"), Categoria.CELULARES);

		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

		entityManager.getTransaction().begin();
		produtoDAO.cadastrar(celular);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
