package br.com.alura.java.jdbc.lojavirtual.repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("rafael");
		comboPooledDataSource.setPassword("password");
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
		return dataSource.getConnection();
	}
	
}
