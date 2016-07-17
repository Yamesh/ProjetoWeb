package br.edu.ufabc.progradweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import br.edu.ufabc.progradweb.acao.Acao;



@WebServlet("/loginController")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//(opcao) recebe a opção da operação(insere, altera, busca, remove)
			String opcao = req.getParameter("opcao");
		
		//Define que classe será chamada, baseado na opcao	
			String nomeDaClasse = "br.edu.ufabc.progradweb.acao." + opcao;
		
			try {
				Class<?> classe = Class.forName(nomeDaClasse);
				Acao acao = (Acao) classe.newInstance();

				acao.executa(req, resp);
			} catch (Exception e) {
				throw new ServletException("Erro: ",e);
			}
		}
	}
	
		
		