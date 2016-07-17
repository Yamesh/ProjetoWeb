<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- CSS -->					
<link rel="stylesheet" type="text/css" href="./estilos/Estilo.css">
<link rel="stylesheet" type="text/css" href="Formularios.css">
<!-- CSS -->
<script type="text/javascript" src="./scripts/loginEcadastro.js"></script>
<title>Página de Login</title>
</head>
<body>
	<h1>Login no Sistema</h1>
	
	<p style="color: red">${requestScope.msg}</p>
	
	<form id="formulario" action="loginController" method="post">
		
<p>			<label>Usuário</label>
			<input type="text" name="usuario" id="usuario" /></p>
		
<p>			<label>Senha </label>
			<input type="password" name="senha" id="senha" /></p>
		
<p>			<input type="submit" value="Entrar" onclick="return validaCamposLogin()"/>		
			<input type="hidden" name="opcao" value="LoginUsuario" />
			</p>
	</form>
	
	<a href=cadastraUsuario.jsp>Não é cadastrado? Cadastre-se aqui</a>
	
	<jsp:include page="rodape.jsp"/>
</body>
</html>