package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Categorie;
import fr.adaming.service.IAdminCategorieService;
import fr.adaming.service.IBoutiqueService;

@Controller
@RequestMapping(value = "/adminProdCat")
@Scope("session")
public class AdminProdCategorieController {

	@Autowired
	private IBoutiqueService boutiqueService;

	@Autowired
	private IAdminCategorieService adminCategorieProduitService;

	@GetMapping("/listCategorie")
	public String afficheCategorie(Model modelMVC, Categorie categorie,
			@RequestParam("picture") CommonsMultipartFile file) {

		if (file != null) {
			categorie.setPhoto(file.getBytes());
		}

		List<Categorie> listeCategorie = boutiqueService.getAllCategories();

		modelMVC.addAttribute("categorie", listeCategorie);

		return "adminProdCategorie";

	}

	// =================== Fonctionnalité Ajout =======

	@GetMapping("/ajoutCategorie")

	public ModelAndView CategorieAjout() {

		return new ModelAndView("adminProdCategorie", "cAdd", new Categorie());

	}

	@PostMapping("/submitAddCategorie")
	public String soumettreCategorieAjout(ModelMap modelMVC, @ModelAttribute("cAdd") Categorie categorie,
			@RequestParam("picture") CommonsMultipartFile file) {

		if (file != null) {
			categorie.setPhoto(file.getBytes());
		}
		adminCategorieProduitService.addCategory(categorie);

		return "redirect:listCategorie";
	}

	// =============Fonctionnalité Modif =============

	@GetMapping("/modifCategorie")
	public ModelAndView CategorieModif() {

		return new ModelAndView("modifCategorie", "cUpdate", new Categorie());

	}

	@PostMapping("/submitModifCategorie")
	public String soumettreCategorieModif(ModelMap modelMVC, @ModelAttribute("cModif") Categorie categorie,
			@RequestParam("picture") CommonsMultipartFile file) {

		if (file != null) {
			categorie.setPhoto(file.getBytes());
		}
		adminCategorieProduitService.updateCategory(categorie);

		return "redirect:listCategorie";
	}

	// ================Fonctionnalité rechercher============

	@GetMapping("/rechercheCategorie")
	public String categorieRecherche(ModelMap modelMVC) {

		modelMVC.addAttribute("cSearch", new Categorie());

		return "adminCategorie";

	}

	@PostMapping("/submitRechercheProd")
	public String soumettreCategorieRecherche(ModelMap modelMVC, @ModelAttribute("cSearch") Categorie categorie,
			@RequestParam("picture") CommonsMultipartFile file, Long idCategorie) {

		if (file != null) {
			categorie.setPhoto(file.getBytes());
		}

		Categorie cOut = adminCategorieProduitService.getCategoryById(categorie);

		if (cOut != null) {
			modelMVC.addAttribute("categorie", cOut);
			modelMVC.addAttribute("cSearch", new Categorie());
		} else {
			modelMVC.addAttribute("msg", "La recherche a échoué !");

			modelMVC.addAttribute("cSearch", new Categorie());
		}

		return "adminCategorie";

	}

	// ===============Fonctionnalité Supprimer ======

	@GetMapping("/displayDelete")
	public String afficheSuppression() {

		return "suppression";
	}

	@PostMapping("/submitSuppCategorie")
	public String soumettreCategorieSupp(ModelMap modelMVC, @ModelAttribute("cSupp") Categorie categorie,
			@RequestParam("picture") CommonsMultipartFile file) {

		if (file != null) {
			categorie.setPhoto(file.getBytes());
		}
		adminCategorieProduitService.deleteCategory(categorie);

		return "redirect:listCategorie";
	}

	@RequestMapping(value = "/updateLink", method = RequestMethod.GET)
	public String modifLink(Model modeleMVC, @RequestParam("pId") Long idCategorie, Categorie categorie,
			@RequestParam("picture") CommonsMultipartFile file) {

		if (file != null) {
			categorie.setPhoto(file.getBytes());
		}

		Categorie cModif = new Categorie();
		cModif.setIdCategorie(idCategorie);

		// Appel la méthode service afin de rechercher l'etudiant dans la BD
		Categorie cOut = adminCategorieProduitService.getCategoryById(cModif);
		modeleMVC.addAttribute("cUpdate", cOut);

		return "modifCategorie";
	}

	// permet de recup le tableau de byte
	// permet de recup le tableau de byte
	// recup la photo
	@RequestMapping(value = "photoCategorie", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCategorie(Long idcategorie) throws IOException {

		Categorie categorie = new Categorie(idcategorie);

		categorie = boutiqueService.getCategoryById(categorie);
		return IOUtils.toByteArray(new ByteArrayInputStream(categorie.getPhoto()));

	}

	// sauvegarder la cat dans le formulaire à partir de l'ordi
	@RequestMapping(value = "/saveCat")
	public String saveCat(Categorie categorie, Model modelMVC, MultipartFile file) throws IOException {
		modelMVC.addAttribute("categorie", new Categorie());
//		modelMVC.addAttribute("categorie", boutiqueService.consulterCategories());

		if (!file.isEmpty()) {
			categorie.setPhoto(file.getBytes());
			// categorie.setNomPhoto(file.getOriginalFilename());
		}
		adminCategorieProduitService.addCategory(categorie);
		return "categorie";
	}

//	@Override
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//		ModelAndView MVC = new ModelAndView();
//		MVC.addObject("exception", ex.getMessage());
//		//def la view
//		MVC.setViewName("categorie");
//		return null;
//		//return MVC.ModelAndView();
//	}

}
