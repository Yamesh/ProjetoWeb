/**
 * 
 */
 

function copiaDados(id){

	
//	alert("Copiando id="+id);
	
	document.getElementById('id').value = id;
//	alert("id = "+id);
	
 	var linhaTabela = document.getElementById("row_"+id);
 	var celulas = linhaTabela.getElementsByTagName("td");
 	
//	alert("Linha ="+linhaTabela);
/*	alert("0="+celulas[0].textContent+" 1="+celulas[1].textContent+
 			" 2="+celulas[2].textContent+" 3="+celulas[3].textContent+
 			" 4="+celulas[4].textContent+" 5="+celulas[5].textContent);
*/
 	document.getElementById('nome').value = celulas[1].textContent;
	document.getElementById('qtde').value = celulas[2].textContent;
 	document.getElementById('qtdeC').value = celulas[3].textContent;
 	
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
//alert("Copia Dados")		
	var nomeASerExcluido = document.getElementById('nome').value;

	if(confirm("Tem certeza que deseja excluir "+nomeASerExcluido+" ID: "+id))
		{
		
//		alert("Confirmado. Nome="+nomeASerExcluido+" id="+id);
		
		document.getElementById('opcao').value ="RemoveItem";
//		alert("Opcao setada para "+document.getElementById('opcao').value);
		
		document.getElementById('formulario').submit();
		alert("Removido");
		}
}
	
console.log();
