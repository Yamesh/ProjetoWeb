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
	
	<title>Lista</title>
</head>
<body>

	<h1>Lista de Itens</h1>
		
	<jsp:useBean id="bd" class="br.edu.ufabc.estoque.dao.ItemDAOcomUsuario" />
	
	
	<c:set var="contagem" value="0" />	
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
			<tr>
					 	<td>${item.nome}</td>
					 	<td>${item.quantidade}</td>
						<td>${item.quantidadeCrítica}</td>
						<td>
	<!-- Antes de exibir o item ele verifica, pelas quantidades, a booleana emFalta -->
							<c:if test="${item.emFalta}">Sim</c:if>
							<c:if test="${!item.emFalta}">Não</c:if>
						</td>
						<td>
							<input type="number" name="aumenta${contagem}" />
						</td>
						<td>
							<input type="number" name="diminui${contagem}" />
						</td>	
						<td><c:out value="${contagem}" /></td>
		
	
			</tr>
			<c:set var="contagem" value="${contagem+1}" />
			
			</c:forEach>	
		</table>	
		
		<input type="hidden" name="opcao" value="AlteraItem" />
		<input type="submit" value="Gravar" /> 
		
	</form>		
</body>

</html>