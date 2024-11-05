package fr.adaming.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

		// R�cup�rer le contexte de Spring Security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// R�cup�rer le login de l'utilisateur connect�
		String mail = auth.getName();

		// Ajouter le mail r�cup�r� dans le modeleVMC

		modeleMVC.addAttribute("login", mail);

		modeleMVC.addAttribute("msg", "Vous �tes dans l'espace Admin");

		return "accueilAdmin";
	}

	@GetMapping("/public/client")
	public String afficheClient(ModelMap modeleMVC) {

		// R�cup�rer le contexte de Spring Security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// R�cup�rer le login de l'utilisateur connect�
		String mail = auth.getName();

		// Ajouter le mail r�cup�r� dans le modeleVMC

		modeleMVC.addAttribute("login", mail);

		modeleMVC.addAttribute("msg", "Vous �tes dans l'espace Client");

		return "accueilClient";
	}

}
