package br.edu.ufabc.progradweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.progradweb.acao.LogoutUsuario;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			LogoutUsuario logout = new LogoutUsuario();
			logout.executa(req, resp);
	//		RequestDispatcher rd = req.getRequestDispatcher(pagina);
	//		rd.forward(req, resp);
		} catch (Exception e) {
			throw new ServletException("Erro: ", e);
		}
	}
}
