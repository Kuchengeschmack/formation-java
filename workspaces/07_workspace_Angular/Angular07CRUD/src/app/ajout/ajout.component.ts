import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Etudiant } from '../modele/etudiant';
import { EtudiantService } from '../services/etudiant.service';

@Component({
  selector: 'app-ajout',
  templateUrl: './ajout.component.html',
  styleUrls: ['./ajout.component.css'],
})
export class AjoutComponent implements OnInit {
  // Déclaration des attributs du composant
  eAdd: Etudiant = new Etudiant();

  // Injection de dépendences
  constructor(private eService: EtudiantService, private router: Router) {}

  ngOnInit(): void {}

  ajouter(): void {
    this.eService.addEtudiant(this.eAdd).subscribe(
      (data) => {
        this.router.navigate(['home']);
      },
      (erreur) => {
        console.log(erreur);
      }
    );
  }
}
