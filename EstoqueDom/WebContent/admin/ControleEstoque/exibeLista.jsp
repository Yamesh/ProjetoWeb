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
		
	<jsp:useBean id="bd" class="br.edu.ufabc.estoque.dao.ItemDAO" />
	
	<div>
	<form id="formulario" action="../../controller" method="post">	
		<table id="resultado">
		
			<tr style="black">
				<th>ID </th>
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Quantidade <br> Crítica</th>
				<th>Em <br> Falta?</th>
				<th>Alterar</th>
				<th>Acrescentar ou<br>Subtrair</th>
				<th>Excluir</th>
				
			</tr>
	
	
			<c:forEach var="item" items="${bd.lista}">
				<tr  id="row_${item.id}">
					 	<td><input type="radio" name="group1" value="${item.id}"  onClick="copiaDados(value)">${item.id}</td>
					 	<td>${item.nome}</td>
					 	<td>${item.quantidade}</td>
						<td>${item.quantidadeCrítica}</td>
						<td>
	<!-- Antes de exibir o item ele verifica, pelas quantidades, a booleana emFalta -->
							<c:if test="${item.emFalta}">Sim</c:if>
							<c:if test="${!item.emFalta}">Não</c:if>
						</td>
						
						<td>
							<input type="number" id="altera${item.id}" name="altera${item.id}" onChange="copiaDados(${item.id})"/>
						</td>
						<td>
							<select id="operacao${item.id}" name="operacao" onBlur="copiaDados(${item.id})">
							<option value="soma">Acrescenta</option>
							<option value="subtracao">Retira</option>
							</select> 
						</td>	
						<td align="center"><a href="#" id="${item.id}" onclick="removePorId(id)">Excluir</a></td>
					
				</tr>
			</c:forEach>	
		</table>	
		
		</div>
		
		<div class="principal">	
		<form id="formulario" action="../../controller" method="post">
			
			<p>	
			<label>Id: </label>
			<input type="text" id="id" name="id" />		
			</p>
			<input type="hidden" id="nome" name="nome" value="vazio" />
			<input type="hidden" id="qtde" name="qtde"  value="vazio" />
			<input type="hidden" id="qtdeC" name="qtdeC" value="vazio""/>	
			<input type="hidden" name="opcao" value="AlteraItem" id="opcao" />
			<input type="submit" value="Gravar" /> </p>
		
	</form>	
	
<script src="../../scripts/exibidor.js"></script>		
</body>

</html>