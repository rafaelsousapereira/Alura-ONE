package br.com.alura.java.jdbc.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.java.jdbc.lojavirtual.model.Categoria;
import br.com.alura.java.jdbc.lojavirtual.model.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();

		System.out.println("Executando a query de listar categorias");

		String sql = "SELECT id, nome FROM tb_categoria";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));

					categorias.add(categoria);
				}
			}
		}

		return categorias;
	}

	public List<Categoria> listarComOsProdutos() throws SQLException {
		Categoria ultima = null;
		List<Categoria> categorias = new ArrayList<>();

		System.out.println("Executando a query de listar categorias");

		String sql = "SELECT C.id, C.nome, P.id, P.nome, P.descricao "
				+ "FROM tb_categoria C "
				+ "INNER JOIN tbproduto P ON C.id = P.categoria_id";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					if (ultima == null || !ultima.getNome().equals(resultSet.getString(2))) {
						Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));

						ultima = categoria;
						categorias.add(categoria);
					}
					
					Produto produto = new Produto(resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
					ultima.adicionar(produto);
				}
			}
		}

		return categorias;
	}
}
