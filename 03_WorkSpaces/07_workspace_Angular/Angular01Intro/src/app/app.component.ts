import { Component } from '@angular/core';

// Ce decorator (annotation) permet de définir un composant en Angular
@Component({

  // Le nom de la balise associée à ce composant, on l'utilise pour spécifier l'endroit où
  // on veut afficher la vue associée à ce composant
  selector: 'app-root',

  // Cette propriété nous permet de définir les vues (templates) associées à ce composant
  templateUrl: './app.component.html',

  // Cette propriété nous permet de définir les feuilles de style à appliquer sur les vues
  // de ce composant
  styleUrls: ['./app.component.css']
})

// Cette classe joue le rôle d'un composant Angular (<==> du controlleur en Java) :
// pour traiter la requête (construire le modèle MVC et choisir la bonne vue à afficher)
export class AppComponent {
 
  // Les attributs du composant stockent le modèle MVC
  titre = 'Cours Angular';

  message = 'Bonjour tout le monde !';

  // Une méthode du composant
  afficher(){
    console.log("--------- Youpi, je suis là !")
  }
}
