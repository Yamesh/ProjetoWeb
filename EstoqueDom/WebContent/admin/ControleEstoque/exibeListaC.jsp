<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- --------------------importações-------------------- -->
<%@ page import="br.edu.ufabc.estoque.modelo.Item" %>
<!-- --------------------/importações-------------------- -->



<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- CSS -->					
<link rel="stylesheet" type="text/css" href="">
<link rel="stylesheet" type="text/css" href="">
<link rel="stylesheet" type="text/css" href="">
<!-- CSS -->
	
	<title>Lista</title>
</head>
<body>

	
	<jsp:useBean id="bd" class="br.edu.ufabc.estoque.dao.ItemDAOcomUsuario" />
	
	<h1>Lista de ItensB</h1>
		
	
	<form action=alteraQuantidades>	
		<table id="resultado">
		
			<tr style="black">
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Quantidade Crítica</th>
				<th>Em Falta?</th>
				<th>Acrescentar</th>
				<th>Diminuir</th>
				<th>Indice</th>
			</tr>
	
	
			<c:forEach var="item" items="${bd.todosOsItens(usuario.usuario)}">
				<c:set var="teste" scope="session" value = "${item.quantidadeCrítica - item.quantidade}" />
				<c:if test="${teste>0}">
					 <tr>
					 	<td>${item.nome}</td>
					 	<td>${item.quantidade}</td>
						<td>${item.quantidadeCrítica}</td>
						<td>
							<input type="number" name="aumenta${item.id}" />
						</td>
						<td>
							<input type="number" name="diminui${item.id}" />
						</td>	
						<td><c:out value="${item.id}" /></td>
					</tr>
				</c:if>
			</c:forEach>	
		</table>	
		
		<input type="hidden" name="opcao" value="AlteraItem" />
		<input type="submit" value="Gravar" /> 
		
	</form>		
</body>

</html>
