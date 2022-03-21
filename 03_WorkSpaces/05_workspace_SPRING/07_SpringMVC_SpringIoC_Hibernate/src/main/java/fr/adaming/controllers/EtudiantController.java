package fr.adaming.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;
import fr.adaming.service.IEtudiantService;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

	// Transformer l'association UML en Java
	@Autowired
	private IEtudiantService etudiantService;

	private Formateur formateur;

	@PostConstruct // Permet d'exécuter cette méthode juste après l'instanciation de
					// EtudiantController afin d'initialiser ses attributs
	public void init() {

		this.formateur = new Formateur(1, "a@a", "a");
	}

	@InitBinder // cette annotation permet de definir la methode à appeler lors
	// d'une conversion des données
	public void initBinding(WebDataBinder binder) {
// l'objet de type WebDataBinder permet de lier les params de la requete
// aux attribut de l'objet java

// specifier le format String de la date à converir en objet de type
// java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

// forcer la methode de conversion à lever une exception de type
// ParseException si la date recue ne coressepond pas au pattern demande
		sdf.setLenient(false);

// la methode registerCustomEditor() permet de configuer la conversion
// du paramettre de la requete reçue au type de l'attribut concernés
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));

	}

	@GetMapping("/list")
	public String afficheAccueil(Model modelMVC) {

		// Récupérer la liste du formateur connecté
		List<Etudiant> liste = etudiantService.getAllEtudiant(this.formateur);

		// Ajouter la liste récupérée comme attribut du model MVC pour que la page
		// accueil puisse l'afficher
		modelMVC.addAttribute("etudiants", liste);

		return "accueil";
	}

	// ================== 2: La fonctionalité ajout
	// a: La méthode en GET pour afficher le formulaire et lui associer un model MVC
	@GetMapping("/displayAdd")
	public ModelAndView afficheAjout() {

		// L'objet ModelAndView contient l'identifiant de la page et l'étudiant associé
		// au formulaire
		return new ModelAndView("ajout", "eAdd", new Etudiant());
	}

	// b: La méthode en POST pour soumettre (traiter) le formulaire de l'ajout
	@PostMapping("/submitAdd")
	public String soumettreAjout(ModelMap modelMVC, @ModelAttribute("eAdd") Etudiant etudiant) {

		// Appel de la méthode service afin d'ajouter l'étudiant dans la BD
		Etudiant eOut = etudiantService.addEtudiant(this.formateur, etudiant);

		if (eOut == null) {
			return "redirect:displayAdd";
		} else {
			return "redirect:list";
		}

	}

	// ================== 3: La fonctionalité modifier
	// a: La méthode en GET pour afficher le formulaire et lui associer un model MVC
	@GetMapping("/displayUpdate")
	public ModelAndView afficheModif() {

		// L'objet ModelAndView contient l'identifiant de la page et l'étudiant associé
		// au formulaire
		return new ModelAndView("modif", "eUpdate", new Etudiant());
	}

	// b: La méthode en POST pour soumettre (traiter) le formulaire de l'ajout
	@PostMapping("/submitUpdate")
	public String soumettreUpdate(@ModelAttribute("eUpdate") Etudiant etudiant, RedirectAttributes rda) {

		// Appel de la méthode service afin d'ajouter l'étudiant dans la BD
		int verif = etudiantService.updateEtudiant(this.formateur, etudiant);

		if (verif == 0) {
			// Ajouter un message d'erreur dans le modelMVC
			rda.addFlashAttribute("msg", "La modification a échoué !");
			return "redirect:displayUpdate";
		} else {
			return "redirect:list";
		}

	}

	// ================== 4: La fonctionalité supprimer
	// a: La méthode en GET pour afficher le formulaire et lui associer un model MVC
	@GetMapping("/displayDelete")
	public String afficheSuppression() {

		// Pas besoin de créer un étudiant
		// On prend un formulaire classique dans suppression.jsp
		return "suppression";
	}

	// b: La méthode en POST pour soumettre (traiter) le formulaire de l'ajout
	@GetMapping("/submitDelete")
	public String soumettreDelete(ModelMap modelMVC, @RequestParam("pId") int id) {

		Etudiant eDelete = new Etudiant();
		eDelete.setId(id);

		// Appel de la méthode service
		boolean verif = etudiantService.deleteEtudiant(this.formateur, eDelete);

		if (!verif) {
			// Ajouter un message d'erreur dans le modele MVC
			modelMVC.addAttribute("msg", "La suppression a échoué !");
			return "suppression";
		} else {
			return "redirect:list";
		}

	}

	// ================== 5: La fonctionalité rechercher par Id
	// a: La méthode en GET pour afficher le formulaire et lui associer un model MVC
	@GetMapping("/displaySearch")
	public ModelAndView afficheRecherche() {

		// L'objet ModelAndView contient l'identifiant de la page et l'étudiant associé
		// au formulaire
		return new ModelAndView("recherche", "eSearch", new Etudiant());
	}

	// b: La méthode en POST pour soumettre (traiter) le formulaire de l'ajout
	@PostMapping("/submitSearch")
	public String soumettreSearch(ModelMap modelMVC, @ModelAttribute("eSearch") Etudiant etudiant) {

		// Appel de la méthode service afin d'ajouter l'étudiant dans la BD
		Etudiant eOut = etudiantService.getEtudiantById(this.formateur, etudiant);
		modelMVC.addAttribute("etudiant", eOut);

		return "recherche";

	}

}
