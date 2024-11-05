package fr.adaming.sevice;

public interface ICalculPrime {

	// Par convention, les noms d'interfaces commencent par un "i"
	
	// Les constantes;
	
	public final static double COEFF1 = 32.5; // Les constantes sont finales, statiques et publiques
	// static veut dire qu'elle est partagée par tous les objets, final veut dire que cette variable ne change pas.
	
	double COEFF2 = 25.4; // L'interface ne contient que des constantes, ici pas d'ambiguité, on peut se passer d'écrir public final static
	
	// L'interface ne contient que des méthodes abstraites
	
	public abstract void calculerPrimeExterne();
	public void calculerPrimeInterne(); // L'interface ne contient que des méthodes abstraites

	// L'interface peut contenir des méthodes concretes, mais elles doivent être des méthodes par défaut
	// Il est déconseillé de redéfinir dans la classe la méthode default
	public default void maMethode() {
		System.out.println("ddd");
	}
}
