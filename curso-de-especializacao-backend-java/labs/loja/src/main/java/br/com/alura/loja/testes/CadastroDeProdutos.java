package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		cadastrarProduto();

		EntityManager entityManager = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

		Produto produto = produtoDAO.buscarPorId(1l);
		System.out.println(produto.getPreco());

//		Buscar todos
		List<Produto> todosOsProdutos = produtoDAO.buscarTodos();
		todosOsProdutos.stream().forEach(p -> System.out.println(p.getDescricao()));

//		Buscar por nome
		List<Produto> buscarPorNome = produtoDAO.buscarPorNome("Xaomi Redmi");
		buscarPorNome.stream().forEach(p -> System.out.println(p.getNome()));

//		Buscar por nome da categoria
		List<Produto> buscarPorNomeDaCategoria = produtoDAO.buscarPorNomeDaCategoria("CELULARES");
		buscarPorNomeDaCategoria.stream().forEach(p -> System.out.println(p.getNome()));

//		Buscar por preco do produto com nome
		BigDecimal buscarPrecoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("Xaomi Redmi");
		System.out.println("Preco do Produto: " + buscarPrecoDoProduto);
	}

	public static void cadastrarProduto() {
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
