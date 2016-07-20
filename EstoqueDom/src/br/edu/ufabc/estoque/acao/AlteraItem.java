package br.edu.ufabc.estoque.acao;


import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ufabc.estoque.modelo.Item;
import br.edu.ufabc.estoque.modelo.Usuario;
import br.edu.ufabc.estoque.dao.ItemDAO;
import br.edu.ufabc.estoque.dao.ItemDAOcomUsuario;



public class AlteraItem implements Acao {
	
public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
	
	// obtem parametros do request
//	String usuario = req.getParameter("usuario");
	String nome = req.getParameter("nome");
	double qtde = Double.valueOf(req.getParameter("qtde"));
	double qtdeC = Double.valueOf(req.getParameter("qtdeC"));
	boolean emFalta = Boolean.valueOf(req.getParameter("emFalta"));
	String id = req.getParameter("id");
			
	//converte ID para long
	Long longId = Long.parseLong(id);
	
	
	// instancia objeto Item
	Item item = new Item(longId,nome,qtde,qtdeC,emFalta);

	//1 :> Obtem a conexão do FiltroBD;
	Connection conexao = (Connection) req.getAttribute("conexao");
	
	//2 :> obtem nome do usuario da sessão
			HttpSession sessao = req.getSession();
			Object objetoUsuario = sessao.getAttribute("usuario");
			Usuario usuario = (Usuario) objetoUsuario;
			String nomeDeUsuario = usuario.getUsuario();
	
	//3 :> cria ItemDAOcomUsuario
	ItemDAOcomUsuario dao = new ItemDAOcomUsuario(nomeDeUsuario, conexao);
	
	//4 :> Chama a função com usuario
	dao.altera(nomeDeUsuario, item);


	req.setAttribute("msg", "Item: " + item.getNome()
	+ " alterado com sucesso!");
	RequestDispatcher rd = req.getRequestDispatcher("/admin/sucesso.jsp");
	rd.forward(req, resp);

	
	}
}
