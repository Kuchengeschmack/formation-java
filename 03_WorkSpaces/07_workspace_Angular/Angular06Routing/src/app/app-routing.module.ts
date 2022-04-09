import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { AjoutComponent } from './ajout/ajout.component';
import { DetailComponent } from './detail/detail.component';
import { ModifComponent } from './modif/modif.component';
import { RechercheComponent } from './recherche/recherche.component';
import { SuppressionComponent } from './suppression/suppression.component';

// La table de routage : la config des correspondances entre des uri et les composants
const routes: Routes = [
  {path:'',redirectTo:'home', pathMatch:'full'},//la redirection en angular
  {path:'home',component:AccueilComponent},//un objt de type route:association url -componenent
  {path:'add',component:AjoutComponent},
  {path:'update',component:ModifComponent},
  {path:'delete',component:SuppressionComponent},
  {path:'find',component:RechercheComponent},
  {path:'search/:pId',component:DetailComponent},//definir une url dynamique
  {path:'**', component:AccueilComponent}//la route pour le catch des url non déclaréés

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
