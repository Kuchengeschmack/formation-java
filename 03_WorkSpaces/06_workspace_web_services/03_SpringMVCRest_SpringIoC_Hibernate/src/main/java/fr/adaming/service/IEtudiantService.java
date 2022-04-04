package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Etudiant;

public interface IEtudiantService {

	public List<Etudiant> getAllEtudiants();

	public Etudiant addEtudiant(Etudiant eIn);

	public Etudiant updateEtudiant(Etudiant eIn);

	public void deleteEtudiantById(int id);

	public Etudiant getEtudiantById(int id);

	public Etudiant getEtudiantByNomAndPrenom(String nom, String prenom);

	public List<Etudiant> getEtudiantByAge(int age);
}
