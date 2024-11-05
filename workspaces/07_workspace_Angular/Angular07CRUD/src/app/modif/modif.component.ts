import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Etudiant } from '../modele/etudiant';
import { EtudiantService } from '../services/etudiant.service';

@Component({
  selector: 'app-modif',
  templateUrl: './modif.component.html',
  styleUrls: ['./modif.component.css'],
})
export class ModifComponent implements OnInit {
  // Déclaration des attributs du composant
  eModif: Etudiant = new Etudiant();

  indice: boolean = false;

  constructor(private eService: EtudiantService, private router: Router) {}

  ngOnInit(): void {}

  modifier(): void {
    this.eService.updateEtudiant(this.eModif).subscribe(
      (data) => {
        console.log(data);
        if (data != null) {
          this.indice = false;
          this.router.navigate(['home']);
        } else {
          this.indice = true;
        }
      },
      (erreur) => {
        console.log(erreur);
        this.indice = true;
      }
    );
  }
}
