package br.edu.ufabc.estoque.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	
		public void executa(HttpServletRequest req, HttpServletResponse resp)
				throws Exception;
	}