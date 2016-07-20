package br.edu.ufabc.estoque.acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutUsuario implements Acao	{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		HttpSession session = req.getSession(true);
		session.invalidate();
		req.setAttribute("msg", "Sessão finalizada!");
		
		//define para onde será redirecionado
		RequestDispatcher redirecionador = req.getRequestDispatcher("/login.jsp");
		
		//redireciona
		redirecionador.forward(req, resp);
		
	
	}


	
}
