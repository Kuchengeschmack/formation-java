package fr.adaming.dao;

import java.util.List;

import fr.adaming.entites.Etudiant;
import fr.adaming.entites.Formateur;

public interface IEtudiantDao {

	public List<Etudiant> getAllEtudiant(Formateur fIn);
	
	public int addEtudiant(Etudiant eIn);
	
	public int updateEtudiant(Etudiant eIn);
	
	public int deleteEtudiantById(Etudiant eIn);
	
	public Etudiant getEtudiantById(Etudiant eIn);
}
