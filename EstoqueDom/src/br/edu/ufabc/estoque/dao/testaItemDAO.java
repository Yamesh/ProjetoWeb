package br.edu.ufabc.estoque.dao;

import br.edu.ufabc.estoque.modelo.Item;

public class testaItemDAO {

	public static void main(String[] args) {
		
		ItemDAO dao = new ItemDAO();
	//	Item novo = new Item("Nome",2.0,2.0,false);
		
		for(Item it: dao.getLista())
		{
		System.out.println(it.getNome());
		}
	}
	
}
