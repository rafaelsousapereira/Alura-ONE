package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criarConexao();

		PreparedStatement statement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM tbproduto");
		statement.execute();
		
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
