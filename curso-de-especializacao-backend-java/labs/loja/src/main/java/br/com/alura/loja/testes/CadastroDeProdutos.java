package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xaomi Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(celular);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
