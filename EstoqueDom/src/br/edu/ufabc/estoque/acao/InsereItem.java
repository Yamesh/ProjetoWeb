package br.edu.ufabc.estoque.acao;


import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ufabc.estoque.dao.ItemDAO;
import br.edu.ufabc.estoque.dao.ItemDAOcomUsuario;
import br.edu.ufabc.estoque.modelo.Item;
import br.edu.ufabc.estoque.modelo.Usuario;



public class InsereItem implements Acao {
	
public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		// obtem parametros do request

		String nome = req.getParameter("nome");
		double qtde = Double.valueOf(req.getParameter("qtde"));
		double qtdeC = Double.valueOf(req.getParameter("qtdeC"));
		boolean emFalta = Boolean.valueOf(req.getParameter("emFalta"));
		
		// obtem nome do usuario da sessão
		HttpSession sessao = req.getSession();
		Object objetoUsuario = sessao.getAttribute("usuario");
		Usuario usuario = (Usuario) objetoUsuario;
		String nomeDeUsuario = usuario.getUsuario();
		
		// instancia objeto Item
		Item item = new Item(nome,qtde,qtdeC,emFalta);

		// Cria alunoDAO com a conexao anterior
		//1 :> Obtem a conexão do FiltroBD;
		Connection conexao = (Connection) req.getAttribute("conexao");
		ItemDAOcomUsuario dao = new ItemDAOcomUsuario(nomeDeUsuario, conexao);
		dao.insere(nomeDeUsuario, item);

		req.setAttribute("msg", "Item: " + item.getNome()
		+ " inserido com sucesso!");
		RequestDispatcher rd = req.getRequestDispatcher("/admin/sucesso.jsp");
		rd.forward(req, resp);

		
	}
}
