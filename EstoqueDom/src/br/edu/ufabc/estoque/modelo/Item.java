package br.edu.ufabc.estoque.modelo;

public class Item {

	//Atributos da Classe ========================================================
	
		private long id;
		private String nome;
		private double quantidade;
		private double quantidadeCr�tica;
		private boolean emFalta;
		
	
	

/**
 * Construtor total
 * @param id
 * @param nome
 * @param quantidade
 * @param quantidadeCr�tica
 * @param emFalta
 */
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

	
	/**
	 * Construtores
	 * @param nome
	 * @param quantidade
	 * @param quantidadeCr�tica
	 * @param emFalta
	 */
	public Item(String nome, double quantidade, double quantidadeCr�tica, boolean emFalta) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.quantidadeCr�tica = quantidadeCr�tica;
		this.emFalta = emFalta;
		//ao criar o item, verifica pela quantidade cr�tica e quantidade normal se ele est� em falta
		this.checaQuantidade();
	}
	
	/**
	 * Construtor Nulo
	 */
	public Item() {super();}
	
	

	
	//Acrescentar e Remover Quantidades ===========================================
	
	/**
	 * Aumenta a Quantidade do item
	 * @param valor Esse � o valor que ser� aumentado. Se estiver ausente, � 1.
	 */
	
	public void aumentaQuantidade(int valor){quantidade = quantidade+valor;}
	public void aumentaQuantidade(){aumentaQuantidade(1);}
	
	
	/**
	 * Reduza Quantidade do item
	 * @param valor Esse � o valor que ser� aumentado. Se estiver ausente, � 1.
	 */
	
	public void reduzQuantidade(int valor){quantidade = quantidade-valor;}
	public void reduzQuantidade(){reduzQuantidade(1);}
	

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
	
	public void checaQuantidade()
	{	
		if(quantidadeCr�tica>quantidade) 
		{
			setEmFalta(false);
		}
		else
		{
			setEmFalta(true);
		}
	}
	
}
