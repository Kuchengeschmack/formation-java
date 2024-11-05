package fr.adaming.modele;

public class Equation {

	private double a;
	private double b;
	private double c;

	private double x1;
	private double x2;

	// 1----- Constructeur et constructeur surcharg�

	public Equation() {

	}

	public Equation(double a, double b, double c) {
		this.setA(a); // Le modificateur de a v�rifie que a soit non-nul (d�finition d'une �quation du
						// 2nd degr�
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

	// 3----- M�thode de calcul des racines

	public boolean calculRacines() {

		// Si les racines sont r�elles, renvoyer true, sinon false

		double discriminant = Math.pow(this.b, 2) - 4 * this.a * this.c;

		if (discriminant >= 0) {
			this.x1 = (-this.b - Math.sqrt(discriminant)) / (2 * a);
			this.x2 = (-this.b + Math.sqrt(discriminant)) / (2 * a);
			return true;
		} else {
			System.out.println("Les racines du polyn�me sont complexes.");
			return false;
		}
	}

	// 4----- M�thode pour afficher les racines

	public void afficherRacines() {
		// Si le calcul des racines renvoie true, alors les racines sont r�elles et on
		// les affiche
		if (this.calculRacines() && a != 0.0) {
			System.out.println("Les racines du polyn�me " + this.a + "X� + " + this.b + "X + " + this.c + " sont "
					+ this.x1 + " et " + this.x2);
		}

	}

}
