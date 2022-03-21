package fr.adaming.modele;

public class B extends A {
    // Le constructeur vide appele le constructeur de la classe mère par défaut
	public B() {
         x++ ; 
    }
    public B(String s){ 
             super();
             x--; 
    }
    public B(int i){
            this();	// On appelle le constructeur par défaut qui appelle le constructeur de la classe mère
            x = x+i ; 
    }
}

