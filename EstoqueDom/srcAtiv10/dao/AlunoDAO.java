package br.edu.ufabc.progradweb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufabc.progradweb.jdbc.ConexaoBD;
import br.edu.ufabc.progradweb.modelo.Aluno;

public class AlunoDAO {
		private Connection connection;
		
		public AlunoDAO() {
			this.connection = new ConexaoBD().getConnection();
		}
		
		public AlunoDAO(Connection conexao){
			this.connection = conexao;
		}
		
		public void fechaConexao() {
			try {
				connection.close();
			} catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
//========================================================================			
		public void insere(Aluno aluno) {
			String sql = "insert into alunos (nome,email,endereco) values (?,?,?)";
			
			try {
		PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, aluno.getNome());
				stmt.setString(2, aluno.getEmail());
				stmt.setString(3, aluno.getEndereco());
				
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
//===================================================================		
		public void remove(Aluno aluno) {
			String sql = "delete from alunos where id=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setLong(1, aluno.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
//========================================================================
		public void altera(Aluno aluno) {
			String sql = "update alunos set nome=?, email=?, endereco=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getEndereco());
			stmt.setLong(4, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
//========================================================================
		// faz a busca de aluno(s) pelo nome do aluno
		public List<Aluno> buscaAlunoPeloNome(String nome) {
			System.out.println("Iniciando buscaAlunoPeloNome");
			List<Aluno> alunos = new ArrayList<Aluno>();

			PreparedStatement stmt;
			String sql = "select * from alunos where nome=?";
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, nome);
				ResultSet rs = stmt.executeQuery();
				System.out.println("Tentando localizar estudante");
				while (rs.next()) {
					Aluno aluno = new Aluno();
					aluno.setId(rs.getLong("id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setEndereco(rs.getString("endereco"));
					System.out.println("Estudante "+aluno.getNome()+" encontrado.");
					alunos.add(aluno);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return alunos;
		}
//========================================================================
		// devolve uma lista com todos alunos
		public List<Aluno> getLista() {
			List<Aluno> alunos = new ArrayList<Aluno>();

			PreparedStatement stmt;
			String sql = "select * from alunos order by nome";
			try {
				stmt = connection.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Aluno aluno = new Aluno();
					aluno.setId(rs.getLong("id"));
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setEndereco(rs.getString("endereco"));

					alunos.add(aluno);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("ERRO NA OBTENÇÃO DO ALUNO");
				throw new RuntimeException(e);
		
			}
			return alunos;
		}
	}
		
	
