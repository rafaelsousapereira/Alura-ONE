package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.criarConexao()) {

			try (PreparedStatement statement = connection.prepareStatement("DELETE FROM tbproduto WHERE ID > ?")) {

				statement.setInt(1, 2);
				statement.execute();

				Integer linhasAfetadas = statement.getUpdateCount();

				System.out.println("Total de linhas afetadas: " + linhasAfetadas);
			}
		}
	}
}
