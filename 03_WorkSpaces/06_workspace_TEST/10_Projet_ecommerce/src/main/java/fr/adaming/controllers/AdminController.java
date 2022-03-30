package fr.adaming.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope("session")

public class AdminController {
	
	@GetMapping("/admin/displayAdmin")
	public String afficherEspaceAdmin() {
		
		return "espaceAdmin";
	}

}
