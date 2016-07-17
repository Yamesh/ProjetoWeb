<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remoção de Itens</title>
<link rel="stylesheet" type="text/css" href="../css/Estilo.css">

</head>
<body>
<h1>Remova um item</h1>
<form action="../controller" method="post">
ID: <input type="text" name="id" />
<input type="submit" value="Remover" />
<input type="hidden" name="opcao" value="RemoveItem" />
</form>

</body>
</html>