package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Etudiant;
import fr.adaming.service.IEtudiantService;

//Cette annotation permet de spécifier que cette classe est un web service Restful développé avec Spring MVC Rest

@RestController

@RequestMapping("/etudiant")
@CrossOrigin("http://localhost:4200")
public class EtudiantRest {

	// Transformation de l'association UML en Java
	@Autowired
	private IEtudiantService etudiantService;

	@GetMapping(value = "/list", produces = "application/json")
	public List<Etudiant> recupererListe() {
		return etudiantService.getAllEtudiants();
	}

	@GetMapping(value = "/find", produces = { "application/json", "application/xml" })
	public Etudiant rechercherEtudiant(@RequestParam("pId") int id) {
		return etudiantService.getEtudiantById(id);
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public Etudiant ajouterEtudiant(@RequestBody Etudiant eIn) {

		return etudiantService.addEtudiant(eIn);
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public Etudiant updateEtudiant(@RequestBody Etudiant eIn) {

		return etudiantService.updateEtudiant(eIn);
	}

	@DeleteMapping(value = "/remove/{pId}")
	public void supprimerEtudiant(@PathVariable("pId") int id) {

		etudiantService.deleteEtudiantById(id);
	}

	@GetMapping(value = "/get/{pNom}/{pPrenom}")
	public Etudiant getEtudiantByNomAndPrenom(@PathVariable("pNom") String nom,
			@PathVariable("pPrenom") String prenom) {

		return etudiantService.getEtudiantByNomEtPrenom(nom, prenom);
	}

	@GetMapping(value = "/search/{pAge}")
	public List<Etudiant> getEtudiantsByAge(@PathVariable("pAge") int age) {
		return etudiantService.getByAge(age);
	}
}
