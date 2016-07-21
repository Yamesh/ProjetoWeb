<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Controle de Estoque Doméstico</title>

<!-- ------------------------------------------------ CSS ----------------------------------------------- -->					
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/basico2.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/paginaIndex.css">
<!-- ------------------------------------------------ CSS ----------------------------------------------- -->

<!-- --------------------------------------------- SCRIPTS ---------------------------------------------- -->
<script type="application/javascript" src="scripts/index.js"></script>
<!-- --------------------------------------------- SCRIPTS ---------------------------------------------- -->

</head>
<body>
	<p><jsp:include page="/admin/cabecalho.jsp" /></p>

	<div >
	<h1>Funções Principais</h1>
	
	
		<ul class="menu">
			<li><a onClick=listaParaEstoque()>Estoque</a></li>
			<li><a onClick=listaParaCompras()>Compras</a></li>
		</ul>
		
	</div>
	
	<br>
	
	
	<p style="color: blue; margin-top: 40px">${requestScope.msgOperacao}</p>
		
	
	<div class="operacao" id="operacaoInsere">
		<jsp:include page="ControleEstoque/insere2.jsp" />
	</div>
	
	
	<div class="operacao" id="operacaoLista">
		<jsp:include page="ControleEstoque/listaIndex.jsp" />
	</div>
		
	<div id="listaDeCompras" style="display: none">
		<jsp:include page="ControleEstoque/exibeListaC.jsp" />
	</div>
	

	
	
	<div class="mostra" id="rodape">
		<p><jsp:include page="/rodape.jsp" /></p>
	</div>
	
	
</body>
</html>
