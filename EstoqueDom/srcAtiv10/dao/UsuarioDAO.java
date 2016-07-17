package br.edu.ufabc.progradweb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.edu.ufabc.progradweb.jdbc.ConexaoBD;
import br.edu.ufabc.progradweb.modelo.Usuario;

import br.edu.ufabc.progradweb.cripto.BCrypt;


public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() {
		// cria uma conexao com o BD
		this.connection = new ConexaoBD().getConnection();
	}
	
	public UsuarioDAO(Connection conexao) {
		this.connection = conexao;
	}
	

	//===================================================================	
	// cadastra um usuario
	//===================================================================	
	public void cadastra(Usuario usuario) {
		String sql = "insert into usuarios (usuario,senha) values (?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			// criptografa a senha 
			// salt: eh um texto gerado randomicamente que eh concatenado a senha antes de criptografa-la
			String senha = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
			
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, senha);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//===================================================================	
	// verifica se o usuario tem permissao de acesso
	//===================================================================	
	public boolean checaPermissao(Usuario usuario) {
		System.out.println("Iniciando checaPermissao");												//PARA DEBUG
		boolean temPermissao = false;
		
		// obtem o Usuario cadastrado 
		Usuario usuarioCad = this.getUsuario(usuario.getUsuario());

		System.out.println("Para o usuario "+usuarioCad.getUsuario());												//PARA DEBUG

		if (usuario != null) {
			// checa se a senha inserida eh igual a senha armazenada no BD
			 temPermissao = BCrypt.checkpw(usuario.getSenha(), usuarioCad.getSenha());
		}
		return temPermissao;
	}
	//===================================================================	
	// verifica se o usuario ja esta cadastrado no BD
	//===================================================================	
	public boolean estaCadastrado(String nomeUsuario) {

		PreparedStatement stmt;
		String sql = "select * from usuarios where usuario = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, nomeUsuario);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println(nomeUsuario+" está cadasdtrado como usuário");		// Para debug
				return true;
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println(nomeUsuario+" não está cadasdtrado como usuário");			// Para debug
		return false;
	}
	//===================================================================	
	// pega um Usuario do BD 
	//===================================================================	
	public Usuario getUsuario(String login) {
	//	System.out.println("Iniciando getUsuario");								// Para debug
		Usuario usuario = new Usuario();

		PreparedStatement stmt;
		String sql = "select * from usuarios where usuario = ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuario;
	}
}
	