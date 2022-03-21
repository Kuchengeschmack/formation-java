package fr.adaming.modele;

public class Equation {

	private double a;
	private double b;
	private double c;

	private double x1;
	private double x2;

	// 1----- Constructeur et constructeur surchargé

	public Equation() {

	}

	public Equation(double a, double b, double c) {
		this.setA(a); // Le modificateur de a vérifie que a soit non-nul (définition d'une équation du
						// 2nd degré
		this.setB(b);
		this.setC(c);
	}

	// 2----- accesseurs et modificateurs

	public double getA() {
		return this.a;
	}

	public void setA(double a) {
		if (a != 0.0) {
			this.a = a;
		} else {
			System.err.println("Veuillez renseigner une valeur de a non-nulle.");
		}
	}

	public double getB() {
		return this.b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return this.c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getX1() {
		return this.x1;
	}

	public double getX2() {
		return this.x2;
	}

	// 3----- Méthode de calcul des racines

	public boolean calculRacines() {

		// Si les racines sont réelles, renvoyer true, sinon false

		double discriminant = Math.pow(this.b, 2) - 4 * this.a * this.c;

		if (discriminant >= 0) {
			this.x1 = (-this.b - Math.sqrt(discriminant)) / (2 * a);
			this.x2 = (-this.b + Math.sqrt(discriminant)) / (2 * a);
			return true;
		} else {
			System.out.println("Les racines du polynôme sont complexes.");
			return false;
		}
	}

	// 4----- Méthode pour afficher les racines

	public void afficherRacines() {
		// Si le calcul des racines renvoie true, alors les racines sont réelles et on
		// les affiche
		if (this.calculRacines() && a != 0.0) {
			System.out.println("Les racines du polynôme " + this.a + "X² + " + this.b + "X + " + this.c + " sont "
					+ this.x1 + " et " + this.x2);
		}

	}

}
