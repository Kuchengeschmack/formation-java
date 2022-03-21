package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

public interface IEtudiantDao {
	
	public List<Etudiant> getAllEtudiants(Formateur fIn);
	
	public Etudiant addEtudiant(Etudiant eIn);
	
	public int updateEtudiant(Etudiant eIn);
	
	public boolean deleteEtudiant(Etudiant eIn);
	
	public Etudiant getEtudiantById(Etudiant eIn);

}
