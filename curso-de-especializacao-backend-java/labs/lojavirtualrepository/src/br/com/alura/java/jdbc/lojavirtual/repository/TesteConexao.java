package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
				"rafael", "password");
		System.out.println("Fechando conexão...");
		
		connection.close();
	}

}
