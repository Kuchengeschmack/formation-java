package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Etudiant;
import fr.adaming.service.IEtudiantService;

//Cette annotation permet de spécifier que cette classe est un web service Restful développé avec Spring MVC Rest

@RestController

@RequestMapping("/etudiant")

public class EtudiantRest {

	// Transformation de l'association UML en Java
	@Autowired
	private IEtudiantService etudiantService;

	@GetMapping(value = "/list", produces = "application/json")
	public List<Etudiant> recupererListe() {
		return etudiantService.getAllEtudiants();
	}
	
	@GetMapping(value = "/find", produces= {"application/json","application/xml"})
	public Etudiant rechercherEtudiant(@RequestParam("pId") int id) {
		return etudiantService.getEtudiantById(id);
	}
}
