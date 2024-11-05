package fr.adaming.sevice;

public interface ICalculPrime {

	// Par convention, les noms d'interfaces commencent par un "i"
	
	// Les constantes;
	
	public final static double COEFF1 = 32.5; // Les constantes sont finales, statiques et publiques
	// static veut dire qu'elle est partag�e par tous les objets, final veut dire que cette variable ne change pas.
	
	double COEFF2 = 25.4; // L'interface ne contient que des constantes, ici pas d'ambiguit�, on peut se passer d'�crir public final static
	
	// L'interface ne contient que des m�thodes abstraites
	
	public abstract void calculerPrimeExterne();
	public void calculerPrimeInterne(); // L'interface ne contient que des m�thodes abstraites

	// L'interface peut contenir des m�thodes concretes, mais elles doivent �tre des m�thodes par d�faut
	// Il est d�conseill� de red�finir dans la classe la m�thode default
	public default void maMethode() {
		System.out.println("ddd");
	}
}
