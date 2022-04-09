import { Component, OnInit } from '@angular/core';
import { EtudiantService } from './services/etudiant.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit { // implements OnInit pour initaliser les composants injectées
  
  // Déclaration exsplicite des attributs du composant
  titre:string="";
  msg:string="";

  // Ajouter le service comme argument du constructeur pour réaliser l'injection de dépendences
  // <==> @Autowired de SpringIoC
  constructor(private etudiantService: EtudiantService){}

  // Redéfinition de la méthode ngOnInit, elle est exécutée après chaque instanciation de ce composant
  // On l'utilise pour intialisaer les attributs de ce dernier
  // Elle est équivalent à la méthode annotée par @Postconstrcut de JAVA
  ngOnInit(): void{

    // Récupérer la valeur de l'attribut message de etudiantService
    this.titre=this.etudiantService.message;

    // Appel de la méthode du service et stockage de son retour dans l'attribut msg du composant
    this.msg = this.etudiantService.recupDonnees();
  }
}
