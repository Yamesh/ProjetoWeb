<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- --------------------importações-------------------- -->
<%@ page import="br.edu.ufabc.estoque.modelo.Item" %>
<!-- --------------------/importações-------------------- -->

<h1>Lista de Itens</h1>
	<div class="lista">
		<jsp:useBean id="bd" class="br.edu.ufabc.estoque.dao.ItemDAOcomUsuario" />
		
		<table id="resultado">
		
			<tr style="black">
				<th>ID</th>
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Quantidade<br>de Segurança</th>
				<th>Em Falta?</th>
				
			</tr>
				<c:forEach var="item" items="${bd.todosOsItens(usuario.usuario)}">
				 <tr>
					 	<td>${item.id}</td>
					 	<td>${item.nome}</td>
					 	<td>${item.quantidade}</td>
						<td>${item.quantidadeCrítica}</td>
						<td>
							<c:if test="${item.emFalta}">Sim</c:if>
							<c:if test="${!item.emFalta}">Não</c:if>
						</td>
					</tr>
			</c:forEach>	
		</table>	
	</div>
	
	<br>
	
	<div class=principal>
		<form action="${pageContext.request.contextPath}/controller2" method="post">
			ID: <input type="text" name="id" /> <input type="submit"
				value="Remover" /> <input type="hidden" name="opcao"
				value="RemoveItemNoIndex" />
		</form>
	</div>
</body>
</html>