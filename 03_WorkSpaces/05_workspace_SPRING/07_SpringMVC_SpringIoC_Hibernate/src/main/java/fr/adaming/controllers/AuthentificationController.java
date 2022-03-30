package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthentificationController {

	@GetMapping("/login")
	public String afficheLogin() {

		return "loginPage";
	}

	@GetMapping("/echec")
	public String afficheErreurLogin(Model modeleMVC) {

		modeleMVC.addAttribute("msg", "Le login et/ou le password est erroné.");
		return "loginPage";
	}

	@GetMapping("/denied")
	public String afficheAccesRefuse() {

		return "accesRefuse";
	}

	@GetMapping("/logout")
	public String afficheAccueilDeconnecte(Model modeleMVC) {
		modeleMVC.addAttribute("msg", "Vous êtes bien déconnecté !");

		return "loginPage";
	}
}
