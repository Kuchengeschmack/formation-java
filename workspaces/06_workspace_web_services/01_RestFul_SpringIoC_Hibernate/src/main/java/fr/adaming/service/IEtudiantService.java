package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Etudiant;

public interface IEtudiantService {

	public Etudiant getEtudiantById(int id);

	public List<Etudiant> getAllEtudiants();

	public Etudiant addEtudiant(Etudiant eIn);

	public void updateEtudiant(Etudiant eIn);

	public int deleteEtudiant(int id);
}
