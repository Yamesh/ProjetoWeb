<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Controle do Estoque</title>
<link rel="stylesheet" type="text/css" href="../../css/Estilo.css">
<link rel="stylesheet" type="text/css" href="../../css/tabela.css">
</head>
<body>
<h1>Buscar Itens</h1>
		<form action="buscaItem.jsp" method="post">
		<input type="radio" name="opcaoBusca" value="todos" checked="checked">Todos <br>
 		<input type="radio" name="opcaoBusca" value="nome">
 		Item desejado: <input type="text" name="nomeBusca" /><br><br>
 		<input type="submit" value="Buscar" />
 		</form>
</body>
</html>