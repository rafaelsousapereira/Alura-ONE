package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.criarConexao();

		String nome = "Mouse";
		String descricao = "Mouse sem fio Logi Tech";

		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO tbproduto (NOME, DESCRICAO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

		statement.setString(1, nome);
		statement.setString(2, descricao);

		statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			System.out.println("ID criado: " + id);
		}
	}

}
