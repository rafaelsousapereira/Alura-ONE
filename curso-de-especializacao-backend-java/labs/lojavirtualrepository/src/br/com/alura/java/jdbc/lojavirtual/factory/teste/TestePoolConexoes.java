package br.com.alura.java.jdbc.lojavirtual.factory.teste;

import java.sql.SQLException;

import br.com.alura.java.jdbc.lojavirtual.factory.ConnectionFactory;

public class TestePoolConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			factory.recuperarConexao();
			System.out.println("Conexao de numero: " + i);
		}
	}

}
