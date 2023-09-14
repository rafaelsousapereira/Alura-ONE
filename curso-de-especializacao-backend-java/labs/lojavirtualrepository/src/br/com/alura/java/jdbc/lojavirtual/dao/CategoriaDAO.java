package br.com.alura.java.jdbc.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.java.jdbc.lojavirtual.model.Categoria;

public class CategoriaDAO {

	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT id, nome FROM tb_categoria";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			
			try (ResultSet resultSet = pstm.getResultSet()) {
				while (resultSet.next()) {
					Categoria categoria = new Categoria(resultSet.getInt(1), resultSet.getString(2));
					
					categorias.add(categoria);
				}
			}
		}
		
		return categorias;
	}
}
