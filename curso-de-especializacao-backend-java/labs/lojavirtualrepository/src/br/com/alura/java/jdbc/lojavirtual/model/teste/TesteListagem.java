package br.com.alura.java.jdbc.lojavirtual.model.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.java.jdbc.lojavirtual.factory.ConnectionFactory;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			try (PreparedStatement statement = connection
					.prepareStatement("SELECT ID, NOME, DESCRICAO FROM tbproduto")) {
				statement.execute();

				try (ResultSet resultSet = statement.getResultSet()) {
					while (resultSet.next()) {
						Integer id = resultSet.getInt("ID");
						String nome = resultSet.getString("NOME");
						String descricao = resultSet.getString("DESCRICAO");

						System.out.println("Produto: Id: " + id + ", Nome: " + nome + ", Descricao: " + descricao);
					}
				}
			}
		}
	}
}
