import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { AjoutComponent } from './ajout/ajout.component';
import { ModifComponent } from './modif/modif.component';
import { RechercheComponent } from './recherche/recherche.component';
import { SuppressionComponent } from './suppression/suppression.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  { path: 'home', component: AccueilComponent },
  { path: 'add', component: AjoutComponent },
  { path: 'update', component: ModifComponent },
  { path: 'delete', component: SuppressionComponent },
  { path: 'find', component: RechercheComponent },

  { path: '**', component: AccueilComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
