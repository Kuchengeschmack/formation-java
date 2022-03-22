package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonController {

	@GetMapping("/welcome")
	public String afficheAccueil(Model modeleMVC) {

		modeleMVC.addAttribute("msg", "Accueil de l'application");

		return "accueil";

	}

	@GetMapping("/admin/magasin")
	public String afficheAdmin(ModelMap modeleMVC) {

		modeleMVC.addAttribute("msg", "Vous êtes dans l'espace Admin");

		return "accueilAdmin";
	}

	@GetMapping("/public/client")
	public String afficheClient(ModelMap modeleMVC) {

		modeleMVC.addAttribute("msg", "Vous êtes dans l'espace Client");

		return "accueilClient";
	}

}
