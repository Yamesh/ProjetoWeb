package br.edu.ufabc.estoque.dao;

//Pacotes próprios
import br.edu.ufabc.estoque.jdbc.ConexaoBD;
import br.edu.ufabc.estoque.modelo.Item;

//Pacotes para conexão
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ItemDAO {

	
	private Connection connection;
		
	
	/**
	 * Construtor da classe cria uma conexão
	 */
	public ItemDAO() {
			this.connection = new ConexaoBD().getConnection();
		}
		
	public ItemDAO(Connection conexao) {
		this.connection = conexao;
	}
	
	
	/**
	 * Fecha a conexão. 
	 */
	public void fechaConexao() {
			try {
				connection.close();
			} catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
	

	
/*		Criar código para que cada usuário tenha sua própria tabela		
 * 
 * 		
 */
	
//========================================================================			
		public void insere(Item qualquer) {
			
			//determina o statement que será enviado
			String sql = "insert into estoque (nome,qtde,qtdeC,emFalta) values (?,?,?,?)";
			
			try{
			//PREPARAR O STATEMENT
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, qualquer.getNome());
			stmt.setDouble(2, qualquer.getQuantidade());
			stmt.setDouble(3, qualquer.getQuantidadeCrítica());
			stmt.setBoolean(4, qualquer.isEmFalta());
			
			//EXECUTA
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		}
//===================================================================		
		public void remove(Item qualquer) {
			String sql = "delete from estoque where id=?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setLong(1, qualquer.getId());
				
				stmt.execute();
				stmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
//========================================================================
		public void altera(Item qualquer) {
			String sql = "update estoque set nome=?, qtde=?, qtdeC=?, emFalta=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//Serão alterados
			stmt.setString(1, qualquer.getNome());
			stmt.setDouble(2, qualquer.getQuantidade());
			stmt.setDouble(3, qualquer.getQuantidadeCrítica());
			stmt.setBoolean(4, qualquer.isEmFalta());
			
			//Quando id = ...
			stmt.setLong(5, qualquer.getId());
			
			//Execute e feche
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
//========================================================================
		// faz a busca de item(s) pelo nome do item
		public List<Item> acharItemPeloNome(String nome) {
			
			List<Item> itens = new ArrayList<Item>();

			PreparedStatement stmt;
			String sql = "select * from estoque where nome=?";
			try {
				stmt = connection.prepareStatement(sql);
				
				stmt.setString(1, nome);
				
				ResultSet rs = stmt.executeQuery();
				
				//Para cada instancia com esse nome no bd
				while (rs.next()) {
					
					//cria uma referencia de item temporaria
					Item qualquer = new Item();
					
					//usa essa referencia para criar um item com os dados obtidos do BD
					qualquer.setId(rs.getLong("id"));
					qualquer.setNome(rs.getString("nome"));
					qualquer.setQuantidade(rs.getDouble("qtde"));
					qualquer.setQuantidadeCrítica(rs.getDouble("qtdeC"));
					qualquer.setEmFalta(rs.getBoolean("emFalta"));
					
					//adiciona o item criado na lista itens
					itens.add(qualquer);
					
				}
				
				rs.close();
				stmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			//retorna a lista itens
			return itens;
		}
//========================================================================
		// devolve uma lista com todos itens
		public List<Item> getLista() {
			List<Item> itens = new ArrayList<Item>();

			PreparedStatement stmt;
			String sql = "select * from estoque order by nome";
			try {
				stmt = connection.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Item qualquer = new Item();
					qualquer.setId(rs.getLong("id"));
					qualquer.setNome(rs.getString("nome"));
					qualquer.setQuantidade(rs.getDouble("qtde"));
					qualquer.setQuantidadeCrítica(rs.getDouble("qtdeC"));
					qualquer.setEmFalta(rs.getBoolean("emFalta"));

					itens.add(qualquer);
				}
				
				
				rs.close();
				stmt.close();
				
				
			} catch (SQLException e) {
				System.out.println("ERRO NA OBTENÇÃO DO ITEM");
				throw new RuntimeException(e);
		
			}
			
			
			return itens;
		}
	}
		
	
