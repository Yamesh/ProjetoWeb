package br.edu.ufabc.estoque.acao;


import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.estoque.modelo.Item;
import br.edu.ufabc.estoque.dao.ItemDAO;



public class AlteraItem implements Acao {
	
public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
	
	// obtem parametros do request
	String nome = req.getParameter("nome");
	double qtde = Double.valueOf(req.getParameter("qtde"));
	double qtdeC = Double.valueOf(req.getParameter("qtdeC"));
	boolean emFalta = Boolean.valueOf(req.getParameter("emFalta"));
	String id = req.getParameter("id");
			
	//converte ID para long
	Long longId = Long.parseLong(id);
	
	
	// instancia objeto Item
	Item item = new Item(longId,nome,qtde,qtdeC,emFalta);


	// Cria alunoDAO com a conexao anterior
	//1 :> Obtem a conexão do FiltroBD;
	Connection conexao = (Connection) req.getAttribute("conexao");
	ItemDAO dao = new ItemDAO(conexao);
	dao.altera(item);

	req.setAttribute("msg", "Item: " + item.getNome()
	+ " alterado com sucesso!");
	RequestDispatcher rd = req.getRequestDispatcher("/admin/sucesso.jsp");
	rd.forward(req, resp);

	
	}
}
