package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // Permet de déclarer cette classe comme un controller pour que le conteneur
			// Spring IoC puisse l'instancier
@RequestMapping("/ctrl") // Cette annotation permet de définir l'urlPattern de ce controller
public class MonEntiteTraitement {

	@RequestMapping(value = { "/monde", "/japon" }, method = RequestMethod.GET)
	public ModelAndView disBonjour() {

		// La valeur du modele MVC
		String message = "Bonjour tout le monde !!!";

		// Cette méthode doit retourner un objet de type ModelAndView, il stocker les
		// données à afficher sur la page (modèle MVC) et l'identifiant de la page (le
		// nom de la page jsp sans extension)
		return new ModelAndView("accueil", "msg", message);
	}

	@RequestMapping(value = "/personne", method = RequestMethod.GET)
	public String disBonjourPersonne(Model modeleMVC, @RequestParam("pNom") String nom,
			@RequestParam(value = "pPrenom", required = false) String prenom) {
		// Quand on utilise RequestParam, le paramètre est obligatoire, sinon ERROR 404

		String message = "Bonjour " + nom + " " + prenom;

		// Ajouter le message dans le modèle MVC afin que la jsp l'affiche
		modeleMVC.addAttribute("msg", message);

		return "accueil";
	}
}
