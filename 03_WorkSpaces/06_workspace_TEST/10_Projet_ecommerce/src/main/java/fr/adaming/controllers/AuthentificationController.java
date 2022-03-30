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
		modeleMVC.addAttribute("msg", "Login et/ou mot de passe éroné");

		return "loginPage";

	}

	@GetMapping("/denied")
	public String afficheAccesRefuse() {

		return "accesRefuse";
	}

	@GetMapping("/logout")
	public String afficheAccueilDeco(Model modeleMVC) {

		modeleMVC.addAttribute("msg", "Vous etes bien deconnecté");

		return "redirect:welcome";
	}
}
