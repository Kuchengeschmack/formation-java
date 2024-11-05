package fr.adaming.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;
import fr.adaming.service.IEtudiantService;
import fr.adaming.service.IFormateurService;

@Controller
@RequestMapping("/etudiant")
@Scope("session") // D�finir le scope (la port�e) du controlleur comme "session"; il va instancier
					// un seul objet de cette classe pour toute la session HTTP
public class EtudiantController {

	// Transformer l'association UML en Java
	@Autowired
	private IEtudiantService etudiantService;

	@Autowired
	private IFormateurService formateurService;

	private Formateur formateur;

	@PostConstruct // Permet d'ex�cuter cette m�thode juste apr�s l'instanciation de
					// EtudiantController afin d'initialiser ses attributs
	public void init() {

		// R�cup�rer le contexte de Spring Security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// R�cup�rer l'email du formateur connect�
		String mail = auth.getName();

		this.formateur = formateurService.getFormateurByMail(mail);

		// this.formateur = new Formateur(1, "a@a", "a");
	}

	@InitBinder // cette annotation permet de definir la methode � appeler lors
	// d'une conversion des donn�es
	public void initBinding(WebDataBinder binder) {
// l'objet de type WebDataBinder permet de lier les params de la requete
// aux attribut de l'objet java

// specifier le format String de la date � converir en objet de type
// java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

// forcer la methode de conversion � lever une exception de type
// ParseException si la date recue ne coressepond pas au pattern demande
		sdf.setLenient(false);

// la methode registerCustomEditor() permet de configuer la conversion
// du paramettre de la requete re�ue au type de l'attribut concern�s
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));

	}

	@GetMapping("/list")
	public String afficheAccueil(Model modelMVC) {

		// R�cup�rer la liste du formateur connect�
		List<Etudiant> liste = etudiantService.getAllEtudiant(this.formateur);

		// Ajouter la liste r�cup�r�e comme attribut du model MVC pour que la page
		// accueil puisse l'afficher
		modelMVC.addAttribute("etudiants", liste);

		return "accueil";
	}

	// ================== 2: La fonctionalit� ajout
	// a: La m�thode en GET pour afficher le formulaire et lui associer un model MVC
	@GetMapping("/displayAdd")
	public ModelAndView afficheAjout() {

		// L'objet ModelAndView contient l'identifiant de la page et l'�tudiant associ�
		// au formulaire
		return new ModelAndView("ajout", "eAdd", new Etudiant());
	}

	// b: La m�thode en POST pour soumettre (traiter) le formulaire de l'ajout
	@PostMapping("/submitAdd")
	public String soumettreAjout(ModelMap modelMVC, @ModelAttribute("eAdd") Etudiant etudiant) {

		// Appel de la m�thode service afin d'ajouter l'�tudiant dans la BD
		Etudiant eOut = etudiantService.addEtudiant(this.formateur, etudiant);

		if (eOut == null) {
			return "redirect:displayAdd";
		} else {
			return "redirect:list";
		}

	}

	// ================== 3: La fonctionalit� modifier
	// a: La m�thode en GET pour afficher le formulaire et lui associer un model MVC
	@GetMapping("/displayUpdate")
	public ModelAndView afficheModif() {

		// L'objet ModelAndView contient l'identifiant de la page et l'�tudiant associ�
		// au formulaire
		return new ModelAndView("modif", "eUpdate", new Etudiant());
	}

	// b: La m�thode en POST pour soumettre (traiter) le formulaire de l'ajout
	@PostMapping("/submitUpdate")
	public String soumettreUpdate(@ModelAttribute("eUpdate") Etudiant etudiant, RedirectAttributes rda) {

		// Appel de la m�thode service afin d'ajouter l'�tudiant dans la BD
		int verif = etudiantService.updateEtudiant(this.formateur, etudiant);

		if (verif == 0) {
			// Ajouter un message d'erreur dans le modelMVC
			rda.addFlashAttribute("msg", "La modification a �chou� !");
			return "redirect:displayUpdate";
		} else {
			return "redirect:list";
		}

	}

	@RequestMapping(value = "/updateLink", method = RequestMethod.GET)
	public String modifLink(Model modeleMVC, @RequestParam("pId") int id) {

		Etudiant eModif = new Etudiant();
		eModif.setId(id);
		Etudiant eOut = etudiantService.getEtudiantById(this.formateur, eModif);

		modeleMVC.addAttribute("eUpdate", eOut); // Pas besoin d'utiliser l'attribut value dans le jsp, path suffit

		return "modif";

	}

	// ================== 4: La fonctionalit� supprimer
	// a: La m�thode en GET pour afficher le formulaire et lui associer un model MVC
	@GetMapping("/displayDelete")
	public String afficheSuppression() {

		// Pas besoin de cr�er un �tudiant
		// On prend un formulaire classique dans suppression.jsp
		return "suppression";
	}

	// b: La m�thode en POST pour soumettre (traiter) le formulaire de l'ajout
	@GetMapping("/submitDelete")
	public String soumettreDelete(ModelMap modelMVC, @RequestParam("pId") int id) {

		Etudiant eDelete = new Etudiant();
		eDelete.setId(id);

		// Appel de la m�thode service
		boolean verif = etudiantService.deleteEtudiant(this.formateur, eDelete);

		if (!verif) {
			// Ajouter un message d'erreur dans le modele MVC
			modelMVC.addAttribute("msg", "La suppression a �chou� !");
			return "suppression";
		} else {
			return "redirect:list";
		}

	}

	// ================== 5: La fonctionalit� rechercher par Id
	// a: La m�thode en GET pour afficher le formulaire et lui associer un model MVC
	@GetMapping("/displaySearch")
	public ModelAndView afficheRecherche() {

		// L'objet ModelAndView contient l'identifiant de la page et l'�tudiant associ�
		// au formulaire
		return new ModelAndView("recherche", "eSearch", new Etudiant());
	}

	// b: La m�thode en POST pour soumettre (traiter) le formulaire de l'ajout
	@PostMapping("/submitSearch")
	public String soumettreSearch(ModelMap modelMVC, @ModelAttribute("eSearch") Etudiant etudiant) {

		// Appel de la m�thode service afin d'ajouter l'�tudiant dans la BD
		Etudiant eOut = etudiantService.getEtudiantById(this.formateur, etudiant);

		if (eOut != null) {
			modelMVC.addAttribute("etudiant", eOut);
		} else {
			modelMVC.addAttribute("msg", "La recherche a �chou� !");
		}

		return "recherche";

	}

}
