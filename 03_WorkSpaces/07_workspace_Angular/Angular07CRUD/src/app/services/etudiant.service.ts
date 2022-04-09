import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Etudiant } from '../modele/etudiant';

// Déclaration d'une constante comme url du web service
const URL = 'http://localhost:8081/rest/etudiant';

@Injectable({
  providedIn: 'root',
})
export class EtudiantService {
  // Injecter le service Angular HttpClient pour pouvoir envoyer des requêtes HTTP à des serveurs distants
  constructor(private http: HttpClient) {}

  // Les méthodes de la couche services pour appeler le web service restful
  getAllEtudiants(): Observable<Etudiant[]> {
    // Appel de la méthode get de httpClient afin d'envoyer une requête http de type GET
    return this.http.get<Etudiant[]>(URL + '/list'); // cast en tableau d'étudiants
  }

  getEtudiantById(id: number): Observable<Etudiant> {
    return this.http.get<Etudiant>(URL + '/find?pId=' + id);
  }

  addEtudiant(eIn: Etudiant): Observable<Etudiant> {
    return this.http.post<Etudiant>(URL, eIn);
  }

  updateEtudiant(eIn: Etudiant): Observable<Etudiant> {
    return this.http.put<Etudiant>(URL, eIn);
  }

  deleteEtudiant(id: number) {
    return this.http.delete(URL + '/remove/' + id, { observe: 'response' });
  }
}
