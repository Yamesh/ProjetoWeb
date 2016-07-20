<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- --------------------importa��es-------------------- -->
<%@ page import="br.edu.ufabc.estoque.modelo.Item" %>
<!-- --------------------/importa��es-------------------- -->



<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera��o de Itens</title>
<link rel="stylesheet" type="text/css" href="../../css/Estilo.css">
<link rel="stylesheet" type="text/css" href="../../css/form.css">
<link rel="stylesheet" type="text/css" href="../../css/tabela.css">

</head>
<body>
<h1> Altere um Aluno</h1>
		
	<div class="lista">
		<jsp:useBean id="bd" class="br.edu.ufabc.estoque.dao.ItemDAOcomUsuario" />
		
		<table id="resultado">
		
			<tr style="black">
				<th>ID</th>
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Quantidade Cr�tica</th>
				<th>Em Falta?</th>
				
			</tr>
				<c:forEach var="item" items="${bd.todosOsItens(usuario.usuario)}">
				 <tr>
					 	<td>${item.id}</td>
					 	<td>${item.nome}</td>
					 	<td>${item.quantidade}</td>
						<td>${item.quantidadeCr�tica}</td>
						<td>
							<c:if test="${item.emFalta}">Sim</c:if>
							<c:if test="${!item.emFalta}">N�o</c:if>
						</td>
					</tr>
			</c:forEach>	
		</table>	
	</div>
	
	<br>
	
	<div class="principal">	
		<form action="../../controller" method="post">
			<p>
				<label>Nome:</label>
				<input type="text" name="nome" />
			</p>
			<p>			
				<label>Quantidade:</label>
				<input type="number" name="qtde" />
			</p>			
			<p>
				<label>Quantidade Cr�tica:</label>
				<input type="number" name="qtdeC" />	
			</p>
			<p>
				<label>Em falta?</label>
				<input type="checkbox" name="emFalta" value="true">	
			</p>			
	
<p>			<label>Id: </label>
			<input type="text" name="id" /></p>

<p>			<input type="hidden" name="opcao" value="AlteraItemComUsuario" />
			<input type="submit" value="Gravar" /> </p>
		</form>
	</div>
</body>
</html>