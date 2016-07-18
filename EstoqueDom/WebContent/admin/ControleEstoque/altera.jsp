<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- --------------------importações-------------------- -->
<%@ page import="br.edu.ufabc.estoque.modelo.Item" %>
<!-- --------------------/importações-------------------- -->



<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Itens</title>
<link rel="stylesheet" type="text/css" href="../../css/Estilo.css">
<link rel="stylesheet" type="text/css" href="../../css/form.css">
<link rel="stylesheet" type="text/css" href="../../css/tabela.css">

</head>
<body>
<h1> Altere um Aluno</h1>
		
	<div class="lista">
		<p><jsp:useBean id="bd" class="br.edu.ufabc.estoque.dao.ItemDAO" /></p>
		
		<table id="resultado">
		
			<tr style="black">
				<th>ID</th>
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Quantidade<br>Crítica</th>
				<th>Excluir?</th>
				
			</tr>
				<c:forEach var="item" items="${bd.lista}">
				 <tr  id="row_${item.id}">
					 	<td><input type="radio" name="group1" value="${item.id}"  onClick="copiaDados(value)">${item.id}</td>
					 	<td>${item.nome}</td>
					 	<td>${item.quantidade}</td>
						<td>${item.quantidadeCrítica}</td>
						<td>
							<c:if test="${item.emFalta}">Sim</c:if>
							<c:if test="${!item.emFalta}">Não</c:if>
						</td>
						<td align="center"><a href="#" id="${item.id}" onclick="removePorId(id)">Excluir</a></td>
					</tr>
			</c:forEach>	
		</table>	
	</div>
	
	<br>
	
	<div class="principal">	
		<form id="formulario" action="../../controller" method="post">
			
			<p>	
			<label>Id: </label>
			<input type="text" id="id" name="id" />		
			</p>
			
			<p>
				<label> Nome:</label>
				<input type="text" id="nome" name="nome" />
			</p>
			<p>			
				<label>Quantidade:</label>
				<input type="text" id="qtde" name="qtde" />
			</p>			
			<p>
				<label>Quantidade Crítica:</label>
				<input type="text" id="qtdeC" name="qtdeC" />	
			</p>
	


<p>			<input type="hidden" name="opcao" value="AlteraItem" id="opcao" />
			<input type="submit" value="Gravar" /> </p>
		</form>
	</div>
	
<script type="application/javascript" src="../../scripts/buscador.js"></script>

</body>
</html>