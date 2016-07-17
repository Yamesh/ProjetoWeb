package br.edu.ufabc.progradweb.acao;


import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.estoque.dao.ItemDAO;
import br.edu.ufabc.progradweb.dao.AlunoDAO;
import br.edu.ufabc.progradweb.modelo.Aluno;

public class AlteraAluno implements Acao {
	
public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
	
	// obtem parametros do request 
	String nome = req.getParameter("nome");
	String email = req.getParameter("email");
	String endereco = req.getParameter("endereco");
	String id = req.getParameter("id");
	
	//converte ID para long
	Long longId = Long.parseLong(id);
	
	
	// instancia objeto Aluno
	Aluno aluno = new Aluno();
	aluno.setNome(nome);
	aluno.setEmail(email);
	aluno.setEndereco(endereco);
	aluno.setId(longId);
	
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
