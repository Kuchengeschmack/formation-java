package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Client;
import fr.adaming.entities.Panier;
import fr.adaming.entities.Produit;
import fr.adaming.service.AdminCategorieServiceImpl;
import fr.adaming.service.BoutiqueServiceImpl;
import fr.adaming.service.IAdminCategorieService;
import fr.adaming.service.IBoutiqueService;

@Controller
@Scope("session") // definir le scope du controlleur comme session (il va instancier une classe/un
					// objet de cette classe pour toute la session et ce sera 1 seul objet pour
					// toute la session http)
public class ClientController {

	// En donnant le panier en attribut de la session il ne disparait pas tant qu'on
	// ne perd pas les cookies et il n'y a plus besoin de le recuperer dans la
	// declaration de chaque fonction ni de le donner dans les fonctions qui n'en
	// n'ont pas besoin uniquement pour le faire suivre
	private Panier panier;

	@PostConstruct // permet d'executer cette methode juste apres l'instanciation de
					// ClientController afin d'initialiser ses attributs
	public void init() {

		// On instencie le panier qui sera modifié tout le long de la navigation
		this.panier = new Panier();
	}

	@GetMapping("/welcome")
	public String afficheAccueil(Model modeleMVC) {
		// On transmet toujours le panier pour avoir les informations sur la quantite
		// modeleMVC.addAttribute("panier", panier);

		return "accueil";
	}

	@GetMapping("/client/displayEspClient")
	public ModelAndView afficheEspaceClient(Model modeleMVC) {
		// On transmet toujours le panier pour avoir les informations sur la quantite
		modeleMVC.addAttribute("panier", panier);

		return new ModelAndView("espaceClient", "Client", new Client());
	}

	@GetMapping("/displayAddClient")
	public ModelAndView afficheCreerClient(Model modeleMVC) {
		// On transmet toujours le panier pour avoir les informations sur la quantite
		modeleMVC.addAttribute("panier", panier);

		return new ModelAndView("creerClient", "Client", new Client());
	}

	@PostMapping("/client/submitAddClient")
	public String submitCreerClient(Model modeleMVC, @ModelAttribute("Client") Client client) {
		// On transmet toujours le panier pour avoir les informations sur la quantite
		modeleMVC.addAttribute("panier", panier);

		// Recuperation du client fournit sur la mage creerClient pour l'ajouter a la bd
		IAdminCategorieService cService = new AdminCategorieServiceImpl();
		if (cService.addClient(client)) {
			return "espaceClient";
		} else {
			modeleMVC.addAttribute("msg", "L'ajout a echoué");
			return "creerClient";

		}
	}

	@GetMapping("/displayProduit")
	public ModelAndView afficheProduit(Model modeleMVC, @RequestParam("pIdProduit") Long idProduit) {
		// @RequestParam nous donne les infos du panier pour ne pas le perdre
		// On recupere l'id du produit dont on a clické sur l'image

		IBoutiqueService bService = new BoutiqueServiceImpl();

		// on cree le produit contenant le mot clef qu'on veut rechercher
		Produit produit = new Produit();
		produit.setIdProduit(idProduit);

		// On appel le service pour recuperer la liste contenant tous les produit
		// correspondant au motClef
		Produit pOut = bService.getProductById(produit);

		// Si la liste contient qqch on renvoit la list
		if (pOut != null) {
			modeleMVC.addAttribute("produit", pOut);
		}
		// Sinon on renvoit sur la page d'affichage le message d'erreur
		else {
			modeleMVC.addAttribute("msg", "Erreur inatendue");
		}

		// On transmet toujours le panier pour avoir les informations sur la quantite
		modeleMVC.addAttribute("panier", panier);

		// On affiche la page de recherche par mot clef qui recoit toutes ces infos

		return new ModelAndView("espaceClient", "Client", new Client());
	}

	@PostMapping("/srcMotClef")
	public String submitProduit(Model modeleMVC, @RequestParam("pMotClef") String motClef) {
		// On recupere le motClef donné par la barre de recherche

		IBoutiqueService bService = new BoutiqueServiceImpl();

		// on cree le produit contenant le mot clef qu'on veut rechercher
		Produit produit = new Produit();
		produit.setMotClef(motClef);

		// On appel le service pour recuperer la liste contenant tous les produit
		// correspondant au motClef
		List<Produit> liste = bService.getAllProducts(produit);

		// Si la liste contient qqch on renvoit la list
		if (liste != null) {
			modeleMVC.addAttribute("produits", liste);
		}
		// Sinon on renvoit sur la page d'affichage le message d'erreur
		else {
			modeleMVC.addAttribute("msg", "Aucun produit n'a ete trouvé");
		}

		// On transmet toujours le panier pour avoir les informations sur la quantite
		modeleMVC.addAttribute("panier", panier);

		// On affiche la page de recherche par mot clef qui recoit toutes ces infos
		// Le client devra ensuite selectionner un produit (ou non) qui appelera a son
		// tour le GetMapping(name="/diplayProduit")
		return "rechercheMotClef";
	}
}
