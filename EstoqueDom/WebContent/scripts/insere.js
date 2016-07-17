/**
 * 
 */

function validaCampos() {
		var nome = document.getElementById('nome').value;
		if (nome == "" || null) {
			alert("O campo Nome não pode ser vazio!");
			return false;
		}
// Valida o email
		//não pode ser vazio e deve conter @
		var email = document.getElementById('email').value;
		//verifica vazio
		if(email == "" || null) {
			alert("O campo email não pode ser vazio!");
			return false;
		}
		//verifica @
		if(email.indexOf("@") < 1) {
			alert("O campo email deve conter o símbolo @");
			return false;
		}		
//Valida o endereço que deve ter no máximo 200 caracteres
		var endereco = document.getElementById('endereco').value;
		if(endereco.lenght>20) {
			alert("O campo endereço deve ter no máximo 200 caracteres");
			return false;
		}
}