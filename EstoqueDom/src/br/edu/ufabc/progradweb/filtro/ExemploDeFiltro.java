package br.edu.ufabc.progradweb.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class ExemploDeFiltro implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {

		// colocar o codigo a ser executado antes processar a requisicao
			long tempoInicio = System.currentTimeMillis();
			
		chain.doFilter(request, response);  // passa para o proximo filtro 

		// colocar o codigo a ser executado depois de processar a requisicao
			long tempoFim = System.currentTimeMillis();
			
			String uri = ((HttpServletRequest) request).getRequestURI();
			System.out.println("Tempo da requisição em "+ uri + "foi de: "+
					(tempoFim - tempoInicio));
			
	}

      @Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}