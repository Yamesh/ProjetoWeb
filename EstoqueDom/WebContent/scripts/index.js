
function listaParaEstoque() {
	document.getElementById("listaDeCompras").style.display = 'none';
	document.getElementById("operacaoInsere").style.display = 'block';
	document.getElementById("operacaoLista").style.display = 'block';
}


function listaParaCompras() {
	document.getElementById("operacaoInsere").style.display = 'none';
	document.getElementById("operacaoLista").style.display = 'none';
	document.getElementById("listaDeCompras").style.display = 'block';
}