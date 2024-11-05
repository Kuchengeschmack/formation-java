import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  // Déclaration d'un attribut qui stocke le paramètre récupéré de la requête afin de l'afficher
  // sur le template
  id:number=0;

  constructor(private ar:ActivatedRoute) { }

  ngOnInit(): void {

    // Récupérer les paramètres de type TemplateParameter (search/:pId) l'URL active (requête envoyée)
   this.ar.params.subscribe((pars)=>{
                                      console.log(pars);

                                      // Récupérer le paramètre pId et le stocker dans l'attribut id du composant
                                      this.id=pars['pId'];
                                    }
                            );
  }

}
