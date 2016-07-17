package br.edu.ufabc.estoque.acao;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.estoque.dao.ItemDAO;
import br.edu.ufabc.estoque.modelo.Item;



public class InsereItem implements Acao {
	
public String executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		// obtem parametros do request
		String nome = req.getParameter("nome");
		double qtde = Double.valueOf(req.getParameter("qtde"));
		double qtdeC = Double.valueOf(req.getParameter("qtdeC"));
		boolean emFalta = Boolean.valueOf(req.getParameter("emFalta"));
		

		// instancia objeto Item
		Item item = new Item(nome,qtde,qtdeC,emFalta);

		ItemDAO dao = new ItemDAO();
		dao.insere(item);

		//Define o texto de saída " _________ com sucesso" que o Controller enviará para sucesso
		String saida = "Item: "+item.getNome()+" inserido com sucesso!";
		return saida;
		
	}
}
