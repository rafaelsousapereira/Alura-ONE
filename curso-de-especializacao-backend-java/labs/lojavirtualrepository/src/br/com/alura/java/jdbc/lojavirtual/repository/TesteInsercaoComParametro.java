package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()) {

			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO tbproduto (NOME, DESCRICAO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel("SmartTV", "45 polegadas", statement);
				adicionarVariavel("PC", "PC Gamming", statement);

				connection.commit();
			} catch (RuntimeException e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO!");
				connection.rollback();
			}

		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement)
			throws SQLException {
		statement.setString(1, nome);
		statement.setString(2, descricao);

		if (nome.equals("PC")) {
			throw new RuntimeException("Nao foi possivel adicionar este produto");
		}

		statement.execute();

		try (ResultSet resultSet = statement.getGeneratedKeys()) {

			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				System.out.println("ID criado: " + id);
			}

		}
	}

}
