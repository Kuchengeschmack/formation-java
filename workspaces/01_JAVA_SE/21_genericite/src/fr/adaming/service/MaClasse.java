package fr.adaming.service;

public class MaClasse<T> {

	// Il s'agit d'une classe g�n�rique, T remplace le type de attr
	
	private T attr;
	
	public void modifier(T attr) {
		
		this.attr = attr;
	}
}
