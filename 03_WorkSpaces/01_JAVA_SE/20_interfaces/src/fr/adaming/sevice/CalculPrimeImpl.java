package fr.adaming.sevice;

public class CalculPrimeImpl implements ICalculPrime, IGestionPersonnel {

	@Override
	public void calculerPrimeExterne() {
		// TODO Auto-generated method stub
		// Calcul de prime
		double prime = COEFF1*1000;
		System.out.println("La prime des personnes externes est : " + prime);
	}

	@Override
	public void calculerPrimeInterne() {
		// TODO Auto-generated method stub
		// calcule de prime
		double prime = COEFF2*2000;
		System.out.println("La prime des personnes externes est : " + prime);		
	}

	@Override
	public void attribuerTache() {
		// TODO Auto-generated method stub
		System.out.println("Chaque personne doit réaliser une tâche à la fois.");
	}
	
	

	
}
