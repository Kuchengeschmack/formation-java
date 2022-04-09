import { Component, OnInit } from '@angular/core';
import { Etudiant } from '../modele/etudiant';
import { EtudiantService } from '../services/etudiant.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css'],
})
export class AccueilComponent implements OnInit {
  // Déclaration des attributs du composant qui vont stocker le modèle MVC
  etudiants: Etudiant[] = [];

  // Injecter un objet de type EtudiantService pour pouvoir appeler ses méthodes
  constructor(private eService: EtudiantService) {}

  ngOnInit(): void {
    // Appel de la méthode service pour récupérer la liste
    this.eService.getAllEtudiants().subscribe(
      (data) => {
        this.etudiants = data;
      },
      (erreur) => {
        console.log(erreur);
      }
    );
  }
}
