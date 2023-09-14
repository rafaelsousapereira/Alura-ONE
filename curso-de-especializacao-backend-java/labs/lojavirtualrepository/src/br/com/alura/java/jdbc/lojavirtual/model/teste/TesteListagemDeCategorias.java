package br.com.alura.java.jdbc.lojavirtual.model.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.java.jdbc.lojavirtual.dao.CategoriaDAO;
import br.com.alura.java.jdbc.lojavirtual.dao.ProdutoDAO;
import br.com.alura.java.jdbc.lojavirtual.factory.ConnectionFactory;
import br.com.alura.java.jdbc.lojavirtual.model.Categoria;
import br.com.alura.java.jdbc.lojavirtual.model.Produto;

public class TesteListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);

			List<Categoria> listaDeCategorias = categoriaDao.listar();
			listaDeCategorias.stream().forEach(categoria -> {
				
				System.out.println(categoria.getNome());
				
				try {
					for (Produto produto : new ProdutoDAO(connection).buscar(categoria)) {
						System.out.println(categoria.getNome() + " - " + produto.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		}

	}

}
