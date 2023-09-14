package br.com.alura.java.jdbc.lojavirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.java.jdbc.lojavirtual.dao.ProdutoDAO;
import br.com.alura.java.jdbc.lojavirtual.model.Produto;
import br.com.alura.java.jdbc.lojavirtual.repository.ConnectionFactory;

public class TesteInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Mouse", "Mouse LogiTech");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(produto);

			List<Produto> listarProduto = produtoDao.listar();
			listarProduto.stream().forEach(listaDeProduto -> System.out.println(listaDeProduto));
		}

	}

}
