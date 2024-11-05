import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EtudiantService } from './services/etudiant.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  // Déclaration des services de module
  providers: [EtudiantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
