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

@WebServlet(name = "virement", urlPatterns = { "/send" })
public class VirerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Déclaration des objets service
	private IClientService clientService;
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Initialisation des objets service
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();
		clientService = new ClientServiceImpl();

		// Récupération de la session client (compte débiteur)
		HttpSession maSession = req.getSession(false);
		Client client = (Client) maSession.getAttribute("clientSession");

		// Récupération des paramètres de la requête
		int idClientCrediteur = Integer.parseInt(req.getParameter("pIdClientCrediteur"));
		int idCompteCrediteur;
		int idCompteDebiteur;

		Double montant = Double.parseDouble(req.getParameter("pMontant"));
		String typeCompte = req.getParameter("pTypeCompte");

		// Obtention du client débiteur afin d'appeler la méthode "virer"
		Client clientIn = new Client(idClientCrediteur);
		Client clientCrediteur = clientService.getClientById(clientIn); // Méthode à développer

		// Déclaration des variables locales
		int verif;
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		List<Client> listeClient;
		RequestDispatcher rd;

		// Action différente selon le type de compte

		if (typeCompte.equals("compteCourant")) {

			// On créé des comptes avec les id du débiteur et du créditeur
			idCompteDebiteur = client.getCompteCourant().getId();
			idCompteCrediteur = clientCrediteur.getCompteCourant().getId();
			CompteCourant compteDebiteur = client.getCompteCourant();
			CompteCourant compteCrediteur = new CompteCourant(idCompteCrediteur);

			// Obtention des soldes des comptes
			compteDebiteur = compteCourantService.getCompteById(client, compteDebiteur); // Récupérer le solde du compte
			compteCrediteur = compteCourantService.getCompteById(client, compteCrediteur);

			// Vérifier que les comptes ont bien été trouvés
			if (compteDebiteur != null && compteCrediteur != null) {
				verif = compteCourantService.virer(client, clientCrediteur, compteDebiteur, compteCrediteur, montant);
			} else {
				verif = 0;
			}

		} else {

			// On créé des comptes avec les id du débiteur et du créditeur
			idCompteDebiteur = client.getCompteEpargne().getId();
			idCompteCrediteur = clientCrediteur.getCompteEpargne().getId();
			CompteEpargne compteDebiteur = client.getCompteEpargne();
			CompteEpargne compteCrediteur = new CompteEpargne(idCompteCrediteur);

			// Obtention des soldes des comptes
			compteDebiteur = compteEpargneService.getCompteById(client, compteDebiteur); // Récupérer le solde du compte
			compteCrediteur = compteEpargneService.getCompteById(client, compteCrediteur);

			// Vérifier que les comptes ont bien été trouvés
			if (compteDebiteur != null && compteCrediteur != null) {
				verif = compteEpargneService.virer(client, clientCrediteur, compteDebiteur, compteCrediteur, montant);
			} else {
				verif = 0;
			}
		}

		if (verif != 0) {

			// Récupération des listes de comptes
			listeCourant = compteCourantService.getAllCompte(client);
			listeEpargne = compteEpargneService.getAllCompte(client);
			listeClient = clientService.getAllClient();

			// Attribution des listes de compte à la requête
			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);
			req.setAttribute("clients", listeClient);

			// Récupération du support de délégation
			rd = req.getRequestDispatcher("/accueil.jsp");

		} else {

			// Message d'erreur
			String message = "La modification a échoué !";
			req.setAttribute("msg", message);

			// Récupération du support de délégation
			rd = req.getRequestDispatcher("/retirer.jsp");

		}

		// Délégation de la requête
		rd.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Appel de la méthode doPost
		doPost(req, resp);
	}
}
