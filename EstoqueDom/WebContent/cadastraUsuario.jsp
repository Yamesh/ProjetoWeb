<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- CSS -->					
<link rel="stylesheet" type="text/css" href="css/basico.css">
<link rel="stylesheet" type="text/css" href="css/formularios.css">
<!-- CSS -->

<script type="application/javascript" src="./scripts/loginEcadastro.js"></script>

<title>Cadastro de Usuario</title>
</head>
<body>
	<h1>Cadastro de Usuario</h1>
	
	<form id="formulario" action="loginController" method="post">
		<p>
			<label>Usuário</label>
			<input type="text" name="usuario" id="usuario" />
		</p>
		<p>
			<label>Senha</label>
			<input type="password" name="senha" id="senha" />
		</p>
		<p>
			<label>Confirmacao </label>
			<input type="password" name="confirmacao" id="confirmacao" />
		</p>
			<input type="submit" value="Entrar" />	
			<input type="hidden" name="opcao" value="CadastraUsuario" onclick="validaCampos()"/>	
	</form>
	
	<a href=cadastraUsuario.jsp>Não é cadastrado? Cadastre-se aqui</a>
	
	<jsp:include page="rodape.jsp"/>
</body>
</html>