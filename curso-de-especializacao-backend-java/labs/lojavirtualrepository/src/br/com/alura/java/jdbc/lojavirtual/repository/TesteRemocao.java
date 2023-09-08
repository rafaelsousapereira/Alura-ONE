package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.criarConexao();
		
		Statement statement = connection.createStatement();
		statement.execute("DELETE FROM tbproduto WHERE ID > 2");
		
		Integer linhasAfetadas = statement.getUpdateCount();
		
		System.out.println("Total de linhas afetadas: " + linhasAfetadas);
	}

}
