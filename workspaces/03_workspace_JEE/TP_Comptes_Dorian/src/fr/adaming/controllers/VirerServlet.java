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

	// D�claration des objets service
	private IClientService clientService;
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Initialisation des objets service
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();
		clientService = new ClientServiceImpl();

		// R�cup�ration de la session client (compte d�biteur)
		HttpSession maSession = req.getSession(false);
		Client client = (Client) maSession.getAttribute("clientSession");

		// R�cup�ration des param�tres de la requ�te
		int idClientCrediteur = Integer.parseInt(req.getParameter("pIdClientCrediteur"));
		int idCompteCrediteur;
		int idCompteDebiteur;

		Double montant = Double.parseDouble(req.getParameter("pMontant"));
		String typeCompte = req.getParameter("pTypeCompte");

		// Obtention du client d�biteur afin d'appeler la m�thode "virer"
		Client clientIn = new Client(idClientCrediteur);
		Client clientCrediteur = clientService.getClientById(clientIn); // M�thode � d�velopper

		// D�claration des variables locales
		int verif;
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		List<Client> listeClient;
		RequestDispatcher rd;

		// Action diff�rente selon le type de compte

		if (typeCompte.equals("compteCourant")) {

			// On cr�� des comptes avec les id du d�biteur et du cr�diteur
			idCompteDebiteur = client.getCompteCourant().getId();
			idCompteCrediteur = clientCrediteur.getCompteCourant().getId();
			CompteCourant compteDebiteur = client.getCompteCourant();
			CompteCourant compteCrediteur = new CompteCourant(idCompteCrediteur);

			// Obtention des soldes des comptes
			compteDebiteur = compteCourantService.getCompteById(client, compteDebiteur); // R�cup�rer le solde du compte
			compteCrediteur = compteCourantService.getCompteById(client, compteCrediteur);

			// V�rifier que les comptes ont bien �t� trouv�s
			if (compteDebiteur != null && compteCrediteur != null) {
				verif = compteCourantService.virer(client, clientCrediteur, compteDebiteur, compteCrediteur, montant);
			} else {
				verif = 0;
			}

		} else {

			// On cr�� des comptes avec les id du d�biteur et du cr�diteur
			idCompteDebiteur = client.getCompteEpargne().getId();
			idCompteCrediteur = clientCrediteur.getCompteEpargne().getId();
			CompteEpargne compteDebiteur = client.getCompteEpargne();
			CompteEpargne compteCrediteur = new CompteEpargne(idCompteCrediteur);

			// Obtention des soldes des comptes
			compteDebiteur = compteEpargneService.getCompteById(client, compteDebiteur); // R�cup�rer le solde du compte
			compteCrediteur = compteEpargneService.getCompteById(client, compteCrediteur);

			// V�rifier que les comptes ont bien �t� trouv�s
			if (compteDebiteur != null && compteCrediteur != null) {
				verif = compteEpargneService.virer(client, clientCrediteur, compteDebiteur, compteCrediteur, montant);
			} else {
				verif = 0;
			}
		}

		if (verif != 0) {

			// R�cup�ration des listes de comptes
			listeCourant = compteCourantService.getAllCompte(client);
			listeEpargne = compteEpargneService.getAllCompte(client);
			listeClient = clientService.getAllClient();

			// Attribution des listes de compte � la requ�te
			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);
			req.setAttribute("clients", listeClient);

			// R�cup�ration du support de d�l�gation
			rd = req.getRequestDispatcher("/accueil.jsp");

		} else {

			// Message d'erreur
			String message = "La modification a �chou� !";
			req.setAttribute("msg", message);

			// R�cup�ration du support de d�l�gation
			rd = req.getRequestDispatcher("/retirer.jsp");

		}

		// D�l�gation de la requ�te
		rd.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Appel de la m�thode doPost
		doPost(req, resp);
	}
}
