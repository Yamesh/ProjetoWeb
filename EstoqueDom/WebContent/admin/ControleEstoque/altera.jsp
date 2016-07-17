<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Itens</title>
<link rel="stylesheet" type="text/css" href="../css/Estilo.css">
<link rel="stylesheet" type="text/css" href="../css/form.css">

</head>
<body>
<h1> Altere um Aluno</h1>
		
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
			<p>
				<label>Em falta?</label>
				<input type="checkbox" name="emFalta" value="true">	
			</p>			
	
<p>			<label>Id: </label>
			<input type="text" name="id" /></p>

<p>			<input type="hidden" name="opcao" value="AlteraItem" />
			<input type="submit" value="Gravar" /> </p>
		</form>
</body>
</html>