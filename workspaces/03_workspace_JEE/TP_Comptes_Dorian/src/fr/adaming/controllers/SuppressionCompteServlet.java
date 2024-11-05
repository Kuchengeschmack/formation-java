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

@WebServlet(name = "supprimer", urlPatterns = { "/delete" })
public class SuppressionCompteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// Déclaration des objets service pour manipuler les comptes
	private IClientService clientService;
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Récupération de la session client
		HttpSession maSession = req.getSession(false); // Ne pas la créer si elle n'existe pas !
		Client client = (Client) maSession.getAttribute("clientSession");

		// Récupération des paramètres de la requête
		int id = Integer.parseInt(req.getParameter("pId"));
		String typeCompte = req.getParameter("pTypeCompte");

		// Déclaration des variables locales
		int verif;
		RequestDispatcher rd;

		// Instanciation des objets service
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();
		clientService = new ClientServiceImpl();

		// Action différente selon le type de compte

		if (typeCompte.equals("compteCourant")) {

			// Appel de la méthode service
			CompteCourant compte = new CompteCourant(id);
			verif = compteCourantService.deleteCompteById(client, compte);

		} else {

			// Appel de la méthode service
			CompteEpargne compte = new CompteEpargne(id);
			verif = compteEpargneService.deleteCompteById(client, compte);

		}

		if (verif != 0) {

			// Récupérer les listes de comptes
			List<CompteCourant> listeCourant = compteCourantService.getAllCompte(client);
			List<CompteEpargne> listeEpargne = compteEpargneService.getAllCompte(client);
			List<Client> listeClient = clientService.getAllClient();

			// Attribuer les listes des comptes à la requête
			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);
			req.setAttribute("clients", listeClient);

			// Récupérer le support de la délégation
			rd = req.getRequestDispatcher("/accueil.jsp");

		} else {

			String message = "La suppresion a échoué !";

			// Ajouter le message comme attribut de la requête
			req.setAttribute("msg", message);

			// Récupérer le support de la délégation
			rd = req.getRequestDispatcher("/suppression_compte.jsp");

		}

		rd.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Appel de la méthode doPost
		doPost(req, resp);
	}

}
