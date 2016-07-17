<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- --------------------importações-------------------- -->
<%@ page import="br.edu.ufabc.estoque.modelo.Item" %>
<!-- --------------------/importações-------------------- -->

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="../../css/Estilo.css">
	<link rel="stylesheet" type="text/css" href="../../css/tabela.css">
	
	<title>Busca</title>
</head>
<body>

	<h1>Resultados da Busca</h1>
		
	<jsp:useBean id="bd" class="br.edu.ufabc.estoque.dao.ItemDAO" />
		
		
	<table id="resultado">
		<tr style="black">
			<th>Nome</th>
			<th>Quantidade</th>
			<th>Quantidade Crítica</th>
			<th>Em Falta?</th>
		</tr>
	
	<c:if test="${param.opcaoBusca == 'todos'}">
			<c:forEach var="item" items="${bd.lista}">
			<tr>
			 	<td>${item.nome}</td>
			 	<td>${item.quantidade}</td>
				<td>${item.quantidadeCrítica}</td>
				<td>
					<c:if test="${item.emFalta}">Sim, compre mais</c:if>
					<c:if test="${!item.emFalta}">Não</c:if>
				</td>

			</tr>
		</c:forEach>
	</c:if>
	
	<c:if test="${param.opcaoBusca == 'nome'}">
	    <c:forEach var="item" items="${bd.acharItemPeloNome(param.nomeBusca)}">
			
			<tr>
				<td>${item.nome}</td>
			 	<td>${item.quantidade}</td>
				<td>${item.quantidadeCrítica}</td>
				<td>${item.emFalta}</td>
			</tr>	
					
		</c:forEach>		
	</c:if>
	
	</table>
</body>

</html>