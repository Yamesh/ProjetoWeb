package br.edu.ufabc.progradweb.acao;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ufabc.progradweb.dao.UsuarioDAO;
import br.edu.ufabc.progradweb.modelo.Usuario;

public class LoginUsuario implements Acao {

	public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception	{
//		System.out.println("Iniciando LoginUsuario"); 							// Para debug
		
		String saida = "erro não definido";
		
		//Obtem a Sessão
		HttpSession session = req.getSession(true);

	
		//Obtem os parametros Usuario e Senha vindos da requisicao(req)
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
	
							/*				ABAIXO: está 
							 * 				Diferente do que a professora colocou na aula: 
							 * 				UsuarioDAO dao = new UsuarioDAO((Connection)req.getAttribute("conexao"));
							 * 				Usuario u = new Usuario();
							 *				u.setUsuario(usuario);
							 * 				u.setSenha(senha);
							 */
		
		//Passo próprio -> insere nova instancia de usuario e usuarioDAO;				
		
		Usuario user = new Usuario(usuario, senha);
		
			//Recupera a conexao da sessao e cria o UsuarioDAO que usa ela
		Connection conexao = (Connection) req.getAttribute("conexao");
		UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
						
	
		//Validar os dados(verificar usuario OU senha vazio)
		if(usuario.equals(null) || senha.equals(null))
		{
			//	Se vazios, retornar para login e senha mostrando mensagem
			//	para dados não vazios
			
			saida = "Erro de Login: Você não pode deixar nenhum campo vazio.";
			req.setAttribute("msg", saida);
			session.setAttribute("usuario", null);				//grava o usuario como NULL para a sessão;
			
			//define para onde será redirecionado
			RequestDispatcher redirecionador = req.getRequestDispatcher("/login.jsp");
			
			//redireciona
			redirecionador.forward(req, resp);
		}
		
		else{	
		
			
//debug			System.out.println("Verificando se "+usuario+" tem permissao de acesso(checaPermissao)");														// Para debug
	//	checar se o usuario tem permissao de acesso, 
			if(usuarioDAO.estaCadastrado(usuario) && usuarioDAO.checaPermissao(user)){
		// 		Se SIM: redirecionar para index.jsp.
				session.setAttribute("usuario", user);				//grava o usuario na sessão;
				System.out.println(usuario+" tem permissao de acesso(checaPermissao)="+usuarioDAO.checaPermissao(user));														// Para debug
				//define para onde será redirecionado
				RequestDispatcher redirecionador = req.getRequestDispatcher("/admin/index.jsp");
				
				//redireciona
				redirecionador.forward(req, resp);
			}
			
			//Se NÃO: redirecionar para login.jsp e apresentar erro de autenticação.
			else{
//debug				System.out.println(usuario+" NAO tem permissao de acesso(checaPermissao="+usuarioDAO.checaPermissao(user)+")");		//PARA DEBUG
		//		Definir mensagem de erro
				saida = "Usuario ou Senha Incorreto(s).";
				req.setAttribute("msg", saida);
				session.setAttribute("usuario", null);				//grava o usuario como NULL para a sessão;
				
		//		//define para onde será redirecionado
				RequestDispatcher redirecionador = req.getRequestDispatcher("./login.jsp");
				
				//redireciona
				redirecionador.forward(req, resp);
			}		
	
			

		}
	}

	
	
}

