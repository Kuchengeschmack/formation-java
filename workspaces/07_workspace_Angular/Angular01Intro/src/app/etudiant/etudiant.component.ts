import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.css']
})
export class EtudiantComponent implements OnInit {

  // Déclaration des attributs du composant, ils stockent le model MVC
  nom:string="TOTO";
  prenom:string="Titi";
  age:number=29;

  fullName:string="";

  // Déclaration du constructeur de la classe
  constructor() { }

  // Cette méthode héritée de l'interface OnInit,
  // elle sert à initialiser les valeurs des attributs du composant
  // elle est exécutée juste après l'instanciation du composant
  ngOnInit(): void {
  }

  // Les méthodes du composant
  afficherNomComplet():void{
    this.fullName=this.nom + " " + this.prenom;
  }

}
