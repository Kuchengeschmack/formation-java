import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  // Déclaration des attributs
  msg="Bonjour tout le monde !";

  constructor() { }

  ngOnInit(): void {
  }

}
