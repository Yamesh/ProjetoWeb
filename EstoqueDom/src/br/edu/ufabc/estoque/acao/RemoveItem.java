package br.edu.ufabc.estoque.acao;


import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.estoque.modelo.Item;
import br.edu.ufabc.estoque.dao.ItemDAO;

public class RemoveItem implements Acao {
	
public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
	
	// obtem parametros do request
		String id = req.getParameter("id");
				
	
	//converte ID para long
	Long longId = Long.parseLong(id);
	
	
	// instancia objeto Item
		Item item = new Item(longId,"nome",1,1,false);

		// Cria alunoDAO com a conexao anterior
				//1 :> Obtem a conexão do FiltroBD;
				Connection conexao = (Connection) req.getAttribute("conexao");
				ItemDAO dao = new ItemDAO(conexao);
				dao.remove(item);

				req.setAttribute("msg", "Item: " + item.getNome()
				+ " alterado com sucesso!");
				RequestDispatcher rd = req.getRequestDispatcher("/admin/sucesso.jsp");
				rd.forward(req, resp);
		
	}
}
