package br.edu.ufabc.estoque.acao;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.estoque.modelo.Item;
import br.edu.ufabc.estoque.dao.ItemDAO;



public class AlteraItem implements Acao {
	
public String executa(HttpServletRequest req, HttpServletResponse resp)
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


		ItemDAO dao = new ItemDAO();
		dao.altera(item);

	//Define o texto de saída " alterado com sucesso" que o Controller enviará para sucesso
	String saida = "Item: "+item.getNome()+" alterado com sucesso!";
	return saida;
	
	}
}
