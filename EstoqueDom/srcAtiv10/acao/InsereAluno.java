package br.edu.ufabc.progradweb.acao;


import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.progradweb.dao.AlunoDAO;
import br.edu.ufabc.progradweb.modelo.Aluno;

public class InsereAluno implements Acao {
	
public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		// obtem parametros do request
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");

		// instancia objeto Aluno
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setEndereco(endereco);

		// Cria alunoDAO com a conexao anterior, obtida do FiltroDAO
		Connection conexao = (Connection) req.getAttribute("conexao");
		AlunoDAO dao = new AlunoDAO(conexao);


		req.setAttribute("msg", "Aluno: " + aluno.getNome()
		+ " inserido com sucesso!");
		RequestDispatcher rd = req.getRequestDispatcher("/admin/sucesso.jsp");
		rd.forward(req, resp);
		
	}
}
