<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sucesso!!!</title>

<!-- CSS -->					
<link rel="stylesheet" type="text/css" href="">
<link rel="stylesheet" type="text/css" href="">
<!-- CSS -->

</head>
<body>
<body>

	<p><jsp:include page="/admin/cabecalho.jsp"/></p>
	<h1>Mensagem:</h1>
	<p>${requestScope.msg}</p>
	<p><b>${usuario.usuario}</b>, clique <a href="${pageContext.request.contextPath}/admin/index.jsp">aqui</a> para voltar à sessão.
	</p>

</body>

</body>
</html>