package fr.adaming.service;

import java.util.List;

import fr.adaming.modele.Etudiant;

public interface IEtudiantService {

	public void addEtudiantService(Etudiant eIn);

	public int updateEtudiantService(Etudiant eIn);

	public int deleteEtudiantService(int eId);
	
	public List<Etudiant> getAllEtudiantsService();
	
	public Etudiant getEtudiantService(int e_Id);
}
