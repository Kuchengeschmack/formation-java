package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

public interface IEtudiantService {
	
	public List<Etudiant> getAllEtudiants(Formateur fIn);

	public Etudiant addEtudiant(Formateur fIn, Etudiant eIn);

	public int updateEtudiant(Formateur fIn, Etudiant eIn);

	public boolean deleteEtudiant(Formateur fIn, Etudiant eIn);

	public Etudiant getEtudiantById(Formateur fIn, Etudiant eIn);
}
