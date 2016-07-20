package br.edu.ufabc.estoque.modelo;

public class Usuario {
	private String usuario;
	private String senha;
	
	public Usuario(){
		usuario=null;
		senha=null;
	}
	
	public Usuario(String user, String senha){
		this.usuario = user;
		this.senha = senha;
	}
	
		
	public String getUsuario(){
		return usuario;
	}
	
	public String getSenha(){
		return senha;
	}
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
}
