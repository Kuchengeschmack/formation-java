import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // La propriété utilisée pour le databinding de type Interpolation
  message = 'La notion de DATA-BINDING';

  // Les propriétés utilisées pour le data-binding de type property-Binding
  typeBtn:string="submit";

  indice:boolean=false;

  nomBtn="Cliquer";

  valCouleur="red";

  valClass:boolean=false;

  // La méthode utilisée pour le data-binding Event-binding
  maFonction():void{
    console.log("------ Ceci est le message de la méthode maFonction");
  }

  maFonction2():void{
    console.log("------ Le deuxième message");
  }

  // La propriété utilisée dans le two-way data-binding
  msg:string = "Zbrah";
}
