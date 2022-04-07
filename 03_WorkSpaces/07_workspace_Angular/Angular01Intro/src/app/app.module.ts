import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EtudiantComponent } from './etudiant/etudiant.component';

// Le decorator pour définir un module en Angular
@NgModule({
 
  // Cette propriété nous permet de déclarer les éléments de ce module : les composants,
  // les directives, les pipes (les filtres)
  declarations: [
    AppComponent,
    EtudiantComponent
  ],
  
  // Cette propriété nous permet de déclarer les autres modules utilisés dans ce module
  imports: [
    BrowserModule
  ],

  // Cette propriété nous permet de déclarer les services de ce module
  providers: [],

  // Cette propriété nous permet de déclarer le composant principal de notre application
  bootstrap: [AppComponent]
})
export class AppModule { }
// Classe du module principal de mon appplication