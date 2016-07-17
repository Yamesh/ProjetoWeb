package br.edu.ufabc.estoque.modelo;

public class Item {

	//Atributos da Classe ========================================================
	
		private long id;
		private String nome;
		private double quantidade;
		private double quantidadeCrítica;
		private boolean emFalta;
		
	
	


//=================================================Construtores===================================================

	public Item(long id, String nome, double quantidade, double quantidadeCrítica, boolean emFalta) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.quantidadeCrítica = quantidadeCrítica;
		this.emFalta = emFalta;
		//ao criar o item, verifica pela quantidade crítica e quantidade normal se ele está em falta
		this.checaQuantidade();
	}


	public Item(String nome, double quantidade, double quantidadeCrítica, boolean emFalta) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.quantidadeCrítica = quantidadeCrítica;
		this.emFalta = emFalta;
		//ao criar o item, verifica pela quantidade crítica e quantidade normal se ele está em falta
		this.checaQuantidade();
	}

	public Item(String nome, double quantidade, double quantidadeCrítica) {
		this(nome, quantidade, quantidadeCrítica, false);
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
	 * Aumenta a Quantidade do item e checa a quantidade para ver se está em falta.
	 * @param valor Esse é o valor que será aumentado. Se estiver ausente, é 1.
	 */
	
	public void aumentaQuantidade(int valor)	{
		quantidade = quantidade+valor;
		this.checaQuantidade();
		}
	
	/**
	 * Reduz a Quantidade do item e checa a quantidade para ver se está em falta.
	 * @param valor Esse é o valor que será aumentado. Se estiver ausente, é 1.
	 */
	
	public void reduzQuantidade(int valor)	{
		quantidade = quantidade-valor;
		this.checaQuantidade();
		}
	
	public void reduzQuantidade(){reduzQuantidade(1);}
	
	//===================== UTILITÁRIOS ===========================================
	
	public void checaQuantidade()	{	
		if(quantidadeCrítica>quantidade) 
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
				"\t"+ quantidadeCrítica+"\t"+ emFalta;
		return descricao;
	}
	
	/**	PARA EXIBIÇÃO
	 * Recupera as informações do item e concatena num texto formatado.
	 * 
	 * @return texto concatenado com as informações do item.
	 */
	public String paraExibicao()	{
		String textoDeSaída = "";
		String formato = "%32s%15s%15s%15s";
		
		if(emFalta){
			textoDeSaída=textoDeSaída.format(formato, nome,quantidade,quantidadeCrítica,"Sim");
		}
		else{
			textoDeSaída=textoDeSaída.format(formato, nome,quantidade,quantidadeCrítica,"Não");
		}
		return textoDeSaída;
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
	public double getQuantidadeCrítica() {
		return quantidadeCrítica;
	}
	public void setQuantidadeCrítica(double quantidadeCrítica) {
		this.quantidadeCrítica = quantidadeCrítica;
	}
	public boolean isEmFalta() {
		return emFalta;
	}
	public void setEmFalta(boolean emFalta) {
		this.emFalta = emFalta;
	}
	
	
	
}
