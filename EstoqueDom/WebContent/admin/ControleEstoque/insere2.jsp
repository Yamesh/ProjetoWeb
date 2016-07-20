<meta charset="ISO-8859-1">
	

	<h1>Insira um novo Item</h1>

		<form action="${pageContext.request.contextPath}/controller2" method="post">
	<p>
			<label>Nome:</label>
			<input type="text" name="nome" />
			
			<label>Quantidade:</label>
			<input type="number" name="qtde" />
	
			<label>Quantidade De Segurança:</label>
			<input type="number" name="qtdeC" />	
	 
	</p>	
			<input type="hidden" name="lista" value="estoque" id="lista" />		
			<input type="hidden" name="opcao" value="InsereItemNoIndex" />	
			<input type="hidden" name="usuario" value="${usuario.usuario}" />
	<p>			<input type="submit" value="Gravar" /> </p>
		</form>
