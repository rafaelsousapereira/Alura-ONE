package br.com.alura.java.jdbc.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.java.jdbc.lojavirtual.model.Categoria;
import br.com.alura.java.jdbc.lojavirtual.model.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO tbproduto (NOME, DESCRICAO) VALUES (?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());

			pstm.execute();

			try (ResultSet resultSet = pstm.getGeneratedKeys()) {
				while (resultSet.next()) {
					produto.setId(resultSet.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		
		List<Produto> produtos = new ArrayList<>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM tbproduto";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public List<Produto> buscar(Categoria categoria) throws SQLException {
		
		List<Produto> produtos = new ArrayList<>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM tbproduto WHERE categoria_id = ?";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, categoria.getId());
			pstm.execute();

			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					Produto produto = new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
					produtos.add(produto);
				}
			}
		}
		
		return produtos;
	}
}
