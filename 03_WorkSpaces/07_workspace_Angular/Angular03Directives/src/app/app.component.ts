import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  // La propriété utilisée par la directive ngIf
  indice:boolean=true;

  // La propriété utilisée pour la directive ngIf avec le bloc else
  indice2:boolean=false;

  // La propriété utilisée pour la directive de type attribut
  status:boolean=true;

  // La propriété utilisée pour la directive ngFor (ngFoOf)
  etudiants=[
    {"nom":"TOTO", "prenom":"Titi", "age":26},
    {"nom":"FOFO", "prenom":"Fifi", "age":27},
    {"nom":"RORO", "prenom":"Riri", "age":28}
  ];

  choixCouleur(pNom:string):string{

    switch(pNom){
      case "TOTO":
        return "red";

      case "FOFO":
        return "blue";

      default:
        return "green";
    }
  }

  changerStatut(){
    this.status = !this.status;
  }
  
}
