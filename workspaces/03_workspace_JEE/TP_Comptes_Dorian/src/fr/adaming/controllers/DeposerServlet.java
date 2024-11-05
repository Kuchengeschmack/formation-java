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

@WebServlet(name = "deposer", urlPatterns = { "/depot" })
public class DeposerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Déclaration des objets services pour manipuler les comptes
	private IClientService clientService;
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Récupération de la session client
		HttpSession maSession = req.getSession(false);
		Client client = (Client) maSession.getAttribute("clientSession");

		// Récupération des paramètres de la requête
		int id = Integer.parseInt(req.getParameter("pId"));
		Double montant = Double.parseDouble(req.getParameter("pMontant"));

		// Déclaration des variables locale
		int verif;
		String typeCompte = req.getParameter("pTypeCompte");
		List<Client> listeClient;
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		RequestDispatcher rd;

		// Initialisation des objets Services
		clientService = new ClientServiceImpl();
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();

		// Action selon le type de compte

		if (typeCompte.equals("compteCourant")) {

			CompteCourant compte = new CompteCourant(id);
			compte = compteCourantService.getCompteById(client, compte); // Pour récupérer le solde

			// Vérifier que le compte a bien été trouvé
			if (compte != null) {
				verif = compteCourantService.deposer(client, compte, montant);
			} else {
				verif = 0;
			}

		} else {

			CompteEpargne compte = new CompteEpargne(id);
			compte = compteEpargneService.getCompteById(client, compte); // Pour récupérer le solde du compte

			// Vérfier que le compte a bien été trouvé
			if (compte != null) {
				verif = compteEpargneService.deposer(client, compte, montant);
			} else {
				verif = 0;
			}
		}

		// Si l'opération est réussie
		if (verif != 0) {
			// Chercher la liste des comptes
			listeCourant = compteCourantService.getAllCompte(client);
			listeEpargne = compteEpargneService.getAllCompte(client);
			listeClient = clientService.getAllClient();

			// Passer les listes de comptes comme attributs de la requête
			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);
			req.setAttribute("clients", listeClient);

			// Obtenir le support de délégation
			rd = req.getRequestDispatcher("/accueil.jsp");

		} else {

			// Définir un message d'erreur
			String message = "La modification a échoué !";
			req.setAttribute("msg", message);

			// Obtenir le support de délégation
			rd = req.getRequestDispatcher("/deposer.jsp");

		}

		// Déléguer la requête
		rd.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Appeler le doPost
		doPost(req, resp);
	}

}
