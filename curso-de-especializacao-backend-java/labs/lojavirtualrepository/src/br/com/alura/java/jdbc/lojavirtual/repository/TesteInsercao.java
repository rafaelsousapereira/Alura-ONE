package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		try (Statement statement = connection.createStatement()) {
			statement.execute("INSERT INTO tbproduto (NOME, DESCRICAO) VALUES ('Mouse', 'Mouse sem fio Logi Tech')",
					Statement.RETURN_GENERATED_KEYS);

			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				while (resultSet.next()) {
					Integer id = resultSet.getInt(1);
					System.out.println("ID criado: " + id);
				}
			}
		}
	}
}
