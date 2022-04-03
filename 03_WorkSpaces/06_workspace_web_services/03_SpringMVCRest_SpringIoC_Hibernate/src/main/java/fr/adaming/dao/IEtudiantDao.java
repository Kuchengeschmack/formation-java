package fr.adaming.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Etudiant;

@Repository
public interface IEtudiantDao extends JpaRepository<Etudiant, Integer> {

}
