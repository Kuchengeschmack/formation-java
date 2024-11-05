package fr.adaming.dao;

import java.util.List;

import fr.adaming.modele.Etudiant;

public interface IEtudiantDao {

	public void addEtudiantDao(Etudiant eIn);

	public int updateEtudiantDao(Etudiant eIn);

	public int deleteEtudiantDao(int eId);

	public List<Etudiant> getAllEtudiantsDao();

	public Etudiant getEtudiantDao(int eId);
}
