package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Etudiant;

@Controller
@RequestMapping("/student")
public class MonController {

	// La méthode pour afficher le formulaire et lui associer un modèle MVC
	// @RequestMapping(value = "display", method = RequestMethod.GET)
	@GetMapping("/display")
	public ModelAndView afficheForm() {
		return new ModelAndView("formulaire", "eleve", new Etudiant()); // Stocke le modèle de la page et le modèle MVC
	}

	// @RequestMapping(value = "/soumettre", method = RequestMethod.POST)
	@PostMapping("/soumettre") // Un raccourci à la ligne ci-dessus
	public String soumettreForm(ModelMap modeleMVC, @ModelAttribute("eleve") Etudiant eIn) {

		// Ajouter l'étudiant eIn dans le modèle MVC à envoyer à resulat

		modeleMVC.addAttribute("etudiant", eIn);

		return "resultat";
	}
}
