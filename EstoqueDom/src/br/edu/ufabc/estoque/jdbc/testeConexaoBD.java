package br.edu.ufabc.estoque.jdbc;

import java.sql.Connection;

public class testeConexaoBD {

	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Connection connection;
		connection = new ConexaoBD().getConnection();
			}
		
	}


