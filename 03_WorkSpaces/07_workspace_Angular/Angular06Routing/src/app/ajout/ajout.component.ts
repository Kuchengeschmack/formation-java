import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ajout',
  templateUrl: './ajout.component.html',
  styleUrls: ['./ajout.component.css']
})
export class AjoutComponent implements OnInit {

  // Déclaration des attributs
  msg="Vous pouvez ajouter des étudiants !"

  // Injecter un objet de type Router pour pouvoir naviguer vers d'autres composants
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  ajouter(){

    // La navigation impérative (via une méthode du composant)
    // Appel de la méthode navigat() de router pour naviguer vers un autre composant
    this.router.navigate(['home']);

    // Appel de la méthode navigateByURL() de router pour naviguer vers un autre composant
    // this.router.navigateByUrl("/home");

  }

}
