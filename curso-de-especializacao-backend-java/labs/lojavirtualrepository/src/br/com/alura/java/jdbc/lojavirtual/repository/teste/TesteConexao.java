package br.com.alura.java.jdbc.lojavirtual.repository.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.java.jdbc.lojavirtual.repository.ConnectionFactory;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try (Connection connection = connectionFactory.recuperarConexao()) {
			System.out.println("Fechando conexão...");
		}
	}

}