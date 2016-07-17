package br.edu.ufabc.progradweb.acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ufabc.progradweb.modelo.Usuario;
import br.edu.ufabc.progradweb.dao.UsuarioDAO;

public class CadastraUsuario implements Acao {
	
	public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception{
		
		String saida;
		saida="";
		
		//Obtem os parametros Usuario e Senha vindos da requisicao(req)
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
	//Passo próprio -> insere nova instancia de usuario e usuarioDAO;				
		Usuario user = new Usuario(usuario, senha);
		UsuarioDAO usuarioDAO =new UsuarioDAO();

		//Validar os dados(ver se usuario ou senha não são vazios
		boolean dadosNull = usuario.equals(null)||senha.equals(null);
		boolean dadosBranco = usuario.equals("")||senha.equals("");		
		if(dadosNull || dadosBranco)
			
		{
			//Se dados vazios: redirecionar para login E informar que os campos 
			//não devem ser vazios
			
					//1) Prepara mensagem de saída e redirecionador
			saida = "Erro no cadastro: Você não pode deixar nenhum campo vazio.";
			req.setAttribute("msg", saida);  
			RequestDispatcher redirecionador = req.getRequestDispatcher("./login.jsp");
			
					//2) Redireciona para login
			redirecionador.forward(req, resp);
		}
		
		
		else {	
		//Verificar se o usuario está cadastrado
			if(usuarioDAO.estaCadastrado(usuario)){
			
		//Se o usuario já estiver cadastrado
				//prepara uma mensagem de saida E (...) 
				saida = "Já existe um usuario com esse login.";
				req.setAttribute("msg", saida);
				
				//(...) redireciona para login
				RequestDispatcher redirecionador = req.getRequestDispatcher("./login.jsp");
				redirecionador.forward(req, resp);
			}
		//caso o usuario não esteja cadastrado, inserir no banco de dados
			else{
				usuarioDAO.cadastra(user);
			//redirecionar para a apagina sucesso.jsp
				//(1)Mensagem de sucesso.
				saida = "Usuario: "+usuario+" cadastrado com sucesso!";
				req.setAttribute("msg", saida);
				
				//(2) Redireciona
				RequestDispatcher redirecionador = req.getRequestDispatcher("/admin/sucesso.jsp");
				redirecionador.forward(req, resp);
			}
				
		
		
		}
	}
}
