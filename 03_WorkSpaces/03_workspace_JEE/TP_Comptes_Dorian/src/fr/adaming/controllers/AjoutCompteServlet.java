package fr.adaming.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteCourantService;
import fr.adaming.service.ICompteEpargneService;

/**
 * Ne prend en charge que l'ajout de comptes courants à ce stade de
 * développement Implémenter l'ajout de comptes Épargne
 * 
 * @author Dorian
 *
 */

@WebServlet(name = "ajouter", urlPatterns = { "/add" })
public class AjoutCompteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Déclaration des objets Service pour manipuler les comptes
	private IClientService clientService;
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Obtention de la session
		HttpSession maSession = req.getSession(false);
		Client client = (Client) maSession.getAttribute("clientSession");

		// Déclaration des variables locales
		int verif;
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		List<Client> listeClient;
		RequestDispatcher rd;

		// Initialisation des objets Service
		clientService = new ClientServiceImpl();
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();

		// Récupération des paramètres de la requête
		Double solde = Double.parseDouble(req.getParameter("pSolde"));
		String typeCompte = req.getParameter("pTypeCompte");

		// Agir selon le type de compte

		if (typeCompte.equals("compteCourant")) {

			CompteCourant compte = new CompteCourant(solde);
			verif = compteCourantService.addCompte(client, compte);

		} else {

			CompteEpargne compte = new CompteEpargne(solde);
			verif = compteEpargneService.addCompte(client, compte);
		}

		if (verif != 0) {

			// Récupération des listes de comptes
			listeCourant = compteCourantService.getAllCompte(client);
			listeEpargne = compteEpargneService.getAllCompte(client);
			listeClient = clientService.getAllClient();

			// Attribution des listes de comptes à la requête
			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);
			req.setAttribute("clients", listeClient);

			// Récupération du support de délégation
			rd = req.getRequestDispatcher("/accueil.jsp");
		} else {

			// Message d'erreur
			String message = "L'ajout a échoué !";
			req.setAttribute("msg", message);

			// Récupération du support de délégation
			rd = req.getRequestDispatcher("/ajout_compte.jsp");
		}

		// Délégation de la requête
		rd.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Appel de doPost
		doPost(req, resp);
	}
}
