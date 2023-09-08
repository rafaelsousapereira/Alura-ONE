package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criarConexao();
		
		System.out.println("Fechando conexão...");
		
		connection.close();
	}

}