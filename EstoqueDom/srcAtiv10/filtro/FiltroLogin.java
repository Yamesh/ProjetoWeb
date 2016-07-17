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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ufabc.progradweb.modelo.Usuario;

@WebFilter(filterName = "FiltroLogin", urlPatterns={"/admin/*"})
public class FiltroLogin implements Filter{
	
	//Filtra
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException{
		
		HttpSession session = ((HttpServletRequest) req).getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		
		//Usuario não logado
		if(usuario == null)	{
			httpResp.sendRedirect(httpReq.getContextPath()+"/login.jsp");
		}
		else{
			chain.doFilter(req, resp);
		}
		
			
		
		
	}

	@Override
	public void init(FilterConfig a) throws ServletException{
		//empty
	}
	
	@Override
	public void destroy() {
		//empty
	}
	
	
}
