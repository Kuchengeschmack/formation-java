import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  // Déclaration des attributs qui stockent les paramètres de la requête
  nom:string="";
  prenom:string='';

  // Injecter un objet de type ActivatedRoute afin de récupérer les infos de l'URL active
  constructor(private ar:ActivatedRoute) { }

  ngOnInit(): void {

    // Récupérer les paramètres de la requête de type Query parameter (find?pNom=TOTO&pPrenom=Titi)
    // Ce type de paramètres est optionel
    this.ar.queryParams.subscribe((pars)=>{
      console.log(pars);

      // Récupérer les params de la requête et les stocker dans les attributs du composant
      this.nom=pars['pNom'];
      this.prenom=pars['pPrenom'];
    });
  }

}
