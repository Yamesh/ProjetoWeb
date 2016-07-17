package br.edu.ufabc.estoque.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import br.edu.ufabc.estoque.acao.Acao;
import br.edu.ufabc.estoque.dao.ItemDAO;
import br.edu.ufabc.estoque.modelo.Item;


@WebServlet("/controller")
public class ControllerServlet extends HttpServlet{

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
			String nomeDaClasse = "br.edu.ufabc.estoque.acao." + opcao;
		
		//String com parte do texto a ser impresso
			String textoDeSaida;
			try {
				Class<?> classe = Class.forName(nomeDaClasse);
				Acao acao = (Acao) classe.newInstance();

				textoDeSaida=acao.executa(req, resp);
			
				//escreve uma msg 
				req.setAttribute("msg", textoDeSaida);
				
				//Redireciona para /sucesso.jsp
				RequestDispatcher rd = req.getRequestDispatcher("/sucesso.jsp");
				rd.forward(req, resp);

			
			
			} catch (Exception e) {
				throw new ServletException("Erro: ",e);
			}
		}
	}
	
		
		