package fr.adaming.entities;

import java.util.List;

public interface IEtudiantDao {

	public Etudiant getEtudiantById(int id);

	public List<Etudiant> getAllEtudiants();

	public Etudiant addEtudiant(Etudiant eIn);

	public void updateEtudiant(Etudiant eIn);

	public int deleteEtudiant(int id);

}
