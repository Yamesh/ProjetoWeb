package br.edu.ufabc.estoque.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.edu.ufabc.progradweb.jdbc.ConexaoBD;


public class FiltroBD implements Filter{

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			try {		
	                   // cria um objeto Connection
				Connection conn = new ConexaoBD().getConnection();
				// anexa o objeto criado na requisicao
				request.setAttribute("conexao", conn);

				chain.doFilter(request, response);

				// fecha a conexao 
				conn.close();
			} catch (SQLException e){
				throw new ServletException("Erro ao gerar a conexão com o banco de dados",e);
			}
		}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
