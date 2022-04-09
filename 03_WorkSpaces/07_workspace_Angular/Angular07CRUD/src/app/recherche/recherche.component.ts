import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Etudiant } from '../modele/etudiant';
import { EtudiantService } from '../services/etudiant.service';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css'],
})
export class RechercheComponent implements OnInit {
  // Déclaration des attributs du composant
  eFind: Etudiant = new Etudiant();
  id: number = 0; // Pour récupérer l'id de la recherche

  indice: boolean = false;
  indice2: boolean = false;

  constructor(private eService: EtudiantService) {}

  ngOnInit(): void {}

  rechercher(): void {
    this.eService.getEtudiantById(this.id).subscribe(
      (data) => {
        if (data != null) {
          this.eFind = data;
          this.indice2 = true;
          this.indice = false;
        } else {
          this.indice2 = false;
          this.indice = true;
        }
      },
      (erreur) => {
        console.log(erreur);
        this.indice2 = false;
        this.indice = true;
      }
    );
  }
}
