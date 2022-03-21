package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;
import fr.adaming.service.IEtudiantService;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

	// transformater l'association UML en JAVA
	@Autowired
	private IEtudiantService etudiantService;

	private Formateur formateur;

	@PostConstruct // permet d'executer cette methode juste aprés l'instanciation de
					// EtudiantController afin d'initialiser ces attrbuts
	public void init() {

		this.formateur = new Formateur(1, "a@a", "a");
	}

	@GetMapping("/list")
	public String afficheAccueil(Model modelMVC) {

		// recuperer la liste du formateur connecté
		List<Etudiant> liste = etudiantService.getAllEtudiants(this.formateur);

		// ajouter la liste recupérée comme attribut du model MVC pour que la page
		// accueil puisse l'afficher
		modelMVC.addAttribute("etudiants",liste);
		
		return "accueil";
	}

}
