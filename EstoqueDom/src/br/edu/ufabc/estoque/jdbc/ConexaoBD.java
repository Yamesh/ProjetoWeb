package br.edu.ufabc.estoque.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
		
		public Connection getConnection() {
			System.out.println("Conectando ao banco de dados");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/estdom";
				return DriverManager.getConnection(url, "root", "ufabc");		
			} 
			catch(SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
				}
		}
}
