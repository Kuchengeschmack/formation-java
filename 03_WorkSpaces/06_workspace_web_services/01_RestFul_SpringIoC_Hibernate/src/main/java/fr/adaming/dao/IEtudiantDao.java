package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Etudiant;

public interface IEtudiantDao {

	public Etudiant getEtudiantById(int id);

	public List<Etudiant> getAllEtudiants();

	public Etudiant addEtudiant(Etudiant eIn);

	public void updateEtudiant(Etudiant eIn);

	public int deleteEtudiant(int id);

}
