<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/Estilo.css">
</head>
<body>
	<h2>Controle de Estoque</h2>

<ul id="menu">	
	<li><a id="mref" href="insere.jsp" target="output_frame">Inserir Item</a></li>
	<li><a id="mref"  href="remove.jsp" target="output_frame">Remover Item</a></li>
	<li><a id="mref"  href="altera.jsp" target="output_frame">Alterar Item</a></li>
	<li><a id="mref"  href="busca.jsp" target="output_frame">Buscar Itens</a></li>
	<li><a id="mref"  href="exibeLista.jsp" target="output_frame">Exibe Lista</a></li>
</ul>	

<iframe name="output_frame" src="" id="output_frame" width=100% height=300 frameborder=0></iframe>
</body>
</html>