package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
				"rafael", "password");

		Statement statement = connection.createStatement();
		statement.execute("SELECT ID, NOME, DESCRICAO FROM tbproduto");
		
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			Integer id = resultSet.getInt("ID");
			String nome = resultSet.getString("NOME");
			String descricao = resultSet.getString("DESCRICAO");
			
			System.out.println("ID: " + id + ", Nome: " + nome + ", Descricao: " + descricao);
		}
		
		connection.close();
	}

}
