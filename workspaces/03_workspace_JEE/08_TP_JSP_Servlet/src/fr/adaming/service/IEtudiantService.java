package fr.adaming.service;

import java.util.List;

import fr.adaming.entites.Etudiant;
import fr.adaming.entites.Formateur;

public interface IEtudiantService {

	public List<Etudiant> getAllEtudiant(Formateur fIn);
	
	public int addEtudiant(Formateur fIn, Etudiant eIn);
	
	public int updateEtudiant(Formateur fIn, Etudiant eIn);
	
	public int deleteEtudiantById(Formateur fIn, Etudiant eIn);
	
	public Etudiant getEtudiantById(Formateur fIn, Etudiant eIn);
}
