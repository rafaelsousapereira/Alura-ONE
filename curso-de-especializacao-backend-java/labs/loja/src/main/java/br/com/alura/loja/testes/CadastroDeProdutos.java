package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");

		Produto celular = new Produto("Xaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);
		CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

		entityManager.getTransaction().begin();
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
