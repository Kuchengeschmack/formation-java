import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EtudiantService } from '../services/etudiant.service';

@Component({
  selector: 'app-suppression',
  templateUrl: './suppression.component.html',
  styleUrls: ['./suppression.component.css'],
})
export class SuppressionComponent implements OnInit {
  id: number = 0;
  indice = false;

  constructor(private eService: EtudiantService, private router: Router) {}

  ngOnInit(): void {}

  supprimer() {
    this.eService.deleteEtudiant(this.id).subscribe(
      (reponse) => {
        if (reponse.status == 200) {
          this.indice = false;
          this.router.navigate(['home']);
        } else {
          this.indice = true;
        }
      },
      (erreur) => {
        this.indice=true;
        console.log(erreur);
      }
    );
  }
}
