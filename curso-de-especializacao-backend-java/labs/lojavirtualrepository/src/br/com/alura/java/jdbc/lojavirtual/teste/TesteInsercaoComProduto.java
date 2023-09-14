package br.com.alura.java.jdbc.lojavirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.java.jdbc.lojavirtual.dao.ProdutoDAO;
import br.com.alura.java.jdbc.lojavirtual.model.Produto;
import br.com.alura.java.jdbc.lojavirtual.repository.ConnectionFactory;

public class TesteInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Monitor", "Monitor LG - 23 polegadas");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(produto);
		}

		System.out.println(produto);
	}

}
