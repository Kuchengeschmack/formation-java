import { Injectable } from '@angular/core';

// Un service est une classe décorée par @Injectable

@Injectable() // Ce décorateur permet de définir un service en Angular et que le moteur de Angular puisse
// instancier un objet de cette classe ({providedIn:'root'})
// <==> @Service de SpringIoC
export class EtudiantService {

  // Déclaration des attributs de mon service
  message:string="La notion des services et l'injection des dépendences en Angular";

  // Le constructeur de mon service
  constructor() { }

  // Les méthodes de mon service
  recupDonnees():string{
    return "-------- Le retour de la méthode de service";
  }
}
