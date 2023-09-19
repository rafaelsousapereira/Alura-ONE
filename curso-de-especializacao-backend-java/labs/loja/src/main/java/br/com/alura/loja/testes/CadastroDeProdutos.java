package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");

		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(celulares);
		celulares.setNome("XPTO");
		
		entityManager.flush();
		entityManager.clear();
		
		celulares = entityManager.merge(celulares);
		celulares.setNome("1234");
		entityManager.flush();
		
		entityManager.remove(celulares);
		entityManager.flush();
	}

}
