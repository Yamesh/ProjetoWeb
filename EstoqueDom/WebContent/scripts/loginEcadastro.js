/**
 * 
 */

function validaCampos() {
//	alert("Iniciando valida campos");
	if(camposVazios())
		{
		alert("Voce nao pode deixar nenhum campo vazio");
		return false;
		}
	if(!senhaConfirmada())
		{
		alert("A senha e a confirmacao da senha nao estao iguais")
		return false;
		}
//	alert("Fim do valida campos");
}


function validaCamposLogin() {
//	alert("Iniciando valida campos");
	if(camposVazios())
		{
		alert("Voce nao pode deixar nenhum campo vazio");
		return false;
		}
	if(!senhaConfirmada())
		{
		alert("A senha e a confirmacao da senha nao estao iguais")
		return false;
		}
//	alert("Fim do valida campos");
}




function senhaConfirmada() {
//	alert("Iniciando senhaConfirmada");
	senha = document.getElementById("senha").value;
	confirmacao = document.getElementById("confirmacao").value;
	
	if(senha==confirmacao)
		{
		return true;
	}
	else
		{
		return false;
	}
}

function camposVazios() {
//	alert("Iniciando camposVazios");
	usuario = document.getElementById("usuario").value;
	senha = document.getElementById("senha").value;
	confirmacao = document.getElementById("confirmacao").value;

	if(usuario==""||senha==""||confirmacao=="")
		{
		return true;
		}
	else{
		if(usuario==null||senha==null||confirmacao==null)
			{
			return true;
			}
		else{
			return false;
		}
	}
		
}

//console.log();