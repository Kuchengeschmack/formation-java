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

@WebServlet(name = "authentification", urlPatterns = { "/auth" })
public class LogInServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Déclaration des objet service pour manipuler les comptes et les clients
	private IClientService clientService;
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Instanciation des objets service
		clientService = new ClientServiceImpl();
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();

		// Récupération des paramètres de la requête
		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");

		Client clientIn = new Client(mail, password);
		Client client = clientService.isExist(clientIn);

		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		List<Client> listeClient;
		RequestDispatcher rd;

		if (client != null) {

			// La session est créée seulement si le client existe dans la base de données
			HttpSession maSession = req.getSession();
			maSession.setAttribute("clientSession", client);

			// Récupération des listes des comptes
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

			// Message d'erreur au cas où le client n'est pas trouvé dans la base de données
			String message = "L'identifiant ou le mot de passe est erroné";
			req.setAttribute("msg", message);

			// Récupération du support de délégation
			rd = req.getRequestDispatcher("/login.jsp");

		}

		// Délégation de la requête
		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Le doGet est appelé lorsque l'on veut afficher les listes de comptes

		// Déclaration des variables locales
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		List<Client> listeClient;
		RequestDispatcher rd;

		// Récupération de la session
		HttpSession maSession = req.getSession();
		Client client = (Client) maSession.getAttribute("clientSession");

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

		// Délégation de la requête
		rd.forward(req, resp);
	}

}
