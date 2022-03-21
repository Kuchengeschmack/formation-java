package com.inti;

public class Article {
	
	private long reference;
	private String intitule;
	private float prixHT;
	private int quantiteEnStock;
	
	public Article(long reference, String intitule, float prixHT, int quantiteEnStock)
	{
		this.reference = reference;
		this.intitule = intitule;
		this.prixHT = prixHT;
		this.quantiteEnStock = quantiteEnStock;
	}
	
	public long getReference()
	{
		return reference;
	}
	
	public String getIntitule()
	{
		return intitule;
	}
	
	public int getQuantiteEnStock()
	{
		return quantiteEnStock;
	}
	
	public void approvisionner(int nombreUnites)
	{
		quantiteEnStock += nombreUnites;
	}
	
	public boolean vendre(int nombreUnites)
	{
		if(nombreUnites <= this.quantiteEnStock)
		{
			quantiteEnStock -= nombreUnites;
			return true;
		}
		return false;
	}
	
	public float prixHT()
	{
		return prixHT;
	}
	
	public float prixTTC()
	{
		return prixHT/(1-0.20f); //On applique une TVA de 20%
	}
	
	public String toString()
	{
		return intitule + " ; prix : " + this.prixTTC() + ", reference : " + reference;
	}
	
	public boolean equals(Article unArticle)
	{
		return unArticle.reference == reference;
	}

}
