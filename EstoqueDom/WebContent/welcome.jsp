<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProgradWeb</title>
<link rel="stylesheet" type="text/css" href="../estilos/Estilo.css">
</head>
<body>
<jsp:include page="/admin/cabecalho.jsp"/>
	<h1>Tela de Login</h1>
<ul id="menu">	
	<li><a id="mref" href="${pageContext.request.contextPath}/admin/index.jsp">Index Alunos</a></li>
	<li><a id="mref"  href="login.jsp">Login Usuário</a></li>
	<li><a id="mref"  href="cadastraUsuario.jsp">Cadastro de Usuário</a></li>
</ul>	
<br>
<br>
<br>	
<jsp:include page="rodape.jsp"/>
</body>
</html>