<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Controle de Estoque Dom�stico</title>
	<link rel="stylesheet" type="text/css" href="../css/Estilo.css">

</head>
<body>
	<p><jsp:include page="/admin/cabecalho.jsp" /></p>

	<h1>Fun��es Principais</h1>


	<ul id="menu">
		<li><a id="mref"
			href="${pageContext.request.contextPath}/admin/ControleEstoque/estoque.jsp"
			target="frame_meio">Estoque</a></li>
		<li><a id="mref"
			href="${pageContext.request.contextPath}/admin/ControleEstoque/exibeListaC.jsp"
			target="frame_meio">Compras</a></li>
	</ul>



	<iframe name="frame_meio" src="" id="frame_meio" width=100% height=600px
		frameborder=0></iframe>

	<p><jsp:include page="/rodape.jsp" /></p>
</body>
</html>