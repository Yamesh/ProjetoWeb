/**
 * 
 */
 
function revelaInvi(){
//	alert("RevelandoInvi...");
		document.getElementById("inv").style.display = 'table-cell';
}  
	
function copiaDados(id){
//	alert("chamandoInvi");
	revelaInvi()
	
//	alert("Copiando");
	document.getElementById('id').value = id;
 	
 	var linhaTabela = document.getElementById("row_"+id);
 	var celulas = linhaTabela.getElementsByTagName("td");
	
 	document.getElementById('nome').value = celulas[0].textContent;
	document.getElementById('email').value = celulas[1].textContent.trim();
 	document.getElementById('endereco').value = celulas[2].textContent;

}

  
function setar(acao){
	
	var campoId = document.getElementById('id').value;
	
	if(campoId == '') 
				{
				alert("Selecione um aluno clicando na coluna \"Alterar/Remover\" da tabela!");
				return false;
				}
	
	document.getElementById('opcao').value = acao;
	
}

function removePorId(id)
	{
//alert("Inicia RemoveId")	
	copiaDados(id);
	
	var nomeASerExcluido = document.getElementById('nome').value;

	if(confirm("Tem certeza que deseja excluir "+nomeASerExcluido+" ID: "+id))
		{
		document.getElementById('opcao').value = "RemoveAluno";
		document.getElementById("formulario").submit();
		alert("Removido");
		}
}
	
