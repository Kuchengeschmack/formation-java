package fr.adaming.modele;

public class B extends A {
    // Le constructeur vide appele le constructeur de la classe m�re par d�faut
	public B() {
         x++ ; 
    }
    public B(String s){ 
             super();
             x--; 
    }
    public B(int i){
            this();	// On appelle le constructeur par d�faut qui appelle le constructeur de la classe m�re
            x = x+i ; 
    }
}

