package fr.adaming.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Etudiant;

@Repository
public interface IEtudiantDao extends JpaRepository<Etudiant, Integer> {

	/*
	 * Récupérer un étudiant par son nom et prénom en utilisant une méthode de
	 * requête L'ordre des valeurs en entrée sont associées aux propriétés de la
	 * méthode dans le même ordre que dans le nom de la méthode C'est ce que l'on
	 * appelle les méthodes de requête
	 */

	public Etudiant findByNomAndPrenom(String pNom, String pPrenom);

	// Écrire la requête JPQL afin de récupérer les étudiants qui ont l'âge
	// supérieur à 18
	@Query("SELECT e FROM Etudiant as e WHERE e.age >:pAge") // Pour écrire une requête JPQL != HQL
	public List<Etudiant> searchEtudiant(@Param("pAge") int age);
}
