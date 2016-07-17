package br.edu.ufabc.estoque.modelo;

public class Item {

	//Atributos da Classe ========================================================
	
		private long id;
		private String nome;
		private double quantidade;
		private double quantidadeCr�tica;
		private boolean emFalta;
		
	
	


//=================================================Construtores===================================================

	public Item(long id, String nome, double quantidade, double quantidadeCr�tica, boolean emFalta) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.quantidadeCr�tica = quantidadeCr�tica;
		this.emFalta = emFalta;
		//ao criar o item, verifica pela quantidade cr�tica e quantidade normal se ele est� em falta
		this.checaQuantidade();
	}


	public Item(String nome, double quantidade, double quantidadeCr�tica, boolean emFalta) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.quantidadeCr�tica = quantidadeCr�tica;
		this.emFalta = emFalta;
		//ao criar o item, verifica pela quantidade cr�tica e quantidade normal se ele est� em falta
		this.checaQuantidade();
	}

	public Item(String nome, double quantidade, double quantidadeCr�tica) {
		this(nome, quantidade, quantidadeCr�tica, false);
		this.checaQuantidade();
	}
	
	public Item(String nome, double quantidade) {
		this(nome, quantidade, quantidade);
	}
	
	public Item(String nome) {
		this(nome, 1.0);
	}
	
	
	public Item() {
		this("Novo Item");
	}
	
	
	//=====================Acrescentar e Remover Quantidades ===========================================
	
	/**
	 * Aumenta a Quantidade do item e checa a quantidade para ver se est� em falta.
	 * @param valor Esse � o valor que ser� aumentado. Se estiver ausente, � 1.
	 */
	
	public void aumentaQuantidade(int valor)	{
		quantidade = quantidade+valor;
		this.checaQuantidade();
		}
	
	/**
	 * Reduz a Quantidade do item e checa a quantidade para ver se est� em falta.
	 * @param valor Esse � o valor que ser� aumentado. Se estiver ausente, � 1.
	 */
	
	public void reduzQuantidade(int valor)	{
		quantidade = quantidade-valor;
		this.checaQuantidade();
		}
	
	public void reduzQuantidade(){reduzQuantidade(1);}
	
	//===================== UTILIT�RIOS ===========================================
	
	public void checaQuantidade()	{	
		if(quantidadeCr�tica>quantidade) 
		{
			setEmFalta(true);
		}
		else
		{
			setEmFalta(false);
		}
	}
	
	
	public String toString()	{
		String descricao = nome+"\t"+quantidade+
				"\t"+ quantidadeCr�tica+"\t"+ emFalta;
		return descricao;
	}
	
	/**	PARA EXIBI��O
	 * Recupera as informa��es do item e concatena num texto formatado.
	 * 
	 * @return texto concatenado com as informa��es do item.
	 */
	public String paraExibicao()	{
		String textoDeSa�da = "";
		String formato = "%32s%15s%15s%15s";
		
		if(emFalta){
			textoDeSa�da=textoDeSa�da.format(formato, nome,quantidade,quantidadeCr�tica,"Sim");
		}
		else{
			textoDeSa�da=textoDeSa�da.format(formato, nome,quantidade,quantidadeCr�tica,"N�o");
		}
		return textoDeSa�da;
	}

		
	//GETTERS e SETTERS ========================================================
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public double getQuantidadeCr�tica() {
		return quantidadeCr�tica;
	}
	public void setQuantidadeCr�tica(double quantidadeCr�tica) {
		this.quantidadeCr�tica = quantidadeCr�tica;
	}
	public boolean isEmFalta() {
		return emFalta;
	}
	public void setEmFalta(boolean emFalta) {
		this.emFalta = emFalta;
	}
	
	
	
}
