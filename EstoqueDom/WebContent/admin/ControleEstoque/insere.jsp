<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		
		<title>Novo Item</title>
		<link rel="stylesheet" type="text/css" href="../css/Estilo.css">
		<link rel="stylesheet" type="text/css" href="../css/form.css">
    
</head>
<body>
	<h1>Insira um novo Item</h1>

		<form action="../controller" method="post">
	<p>
			<label>Nome:</label>
			<input type="text" name="nome" />
	</p>			
	<p>			
			<label>Quantidade:</label>
			<input type="number" name="qtde" />
	</p>			
	<p>
			<label>Quantidade Crítica:</label>
			<input type="number" name="qtdeC" />	
	</p>
	<p>			<label>Em falta?</label>
			<input type="checkbox" name="emFalta" value="true">	
	</p>			
			<input type="hidden" name="opcao" value="InsereItem" />	
	<p>			<input type="submit" value="Gravar" /> </p>
		</form>

		
</body>
</html>