package br.com.alura.java.jdbc.lojavirtual.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.java.jdbc.lojavirtual.model.Produto;
import br.com.alura.java.jdbc.lojavirtual.repository.ConnectionFactory;

public class TesteInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Forno", "Mini forno Arno");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

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

		System.out.println(produto);
	}

}
