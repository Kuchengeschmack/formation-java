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
	// D�claration des objets service pour manipuler les comptes
	private IClientService clientService;
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�ration de la session client
		HttpSession maSession = req.getSession(false); // Ne pas la cr�er si elle n'existe pas !
		Client client = (Client) maSession.getAttribute("clientSession");

		// R�cup�ration des param�tres de la requ�te
		int id = Integer.parseInt(req.getParameter("pId"));
		String typeCompte = req.getParameter("pTypeCompte");

		// D�claration des variables locales
		int verif;
		RequestDispatcher rd;

		// Instanciation des objets service
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();
		clientService = new ClientServiceImpl();

		// Action diff�rente selon le type de compte

		if (typeCompte.equals("compteCourant")) {

			// Appel de la m�thode service
			CompteCourant compte = new CompteCourant(id);
			verif = compteCourantService.deleteCompteById(client, compte);

		} else {

			// Appel de la m�thode service
			CompteEpargne compte = new CompteEpargne(id);
			verif = compteEpargneService.deleteCompteById(client, compte);

		}

		if (verif != 0) {

			// R�cup�rer les listes de comptes
			List<CompteCourant> listeCourant = compteCourantService.getAllCompte(client);
			List<CompteEpargne> listeEpargne = compteEpargneService.getAllCompte(client);
			List<Client> listeClient = clientService.getAllClient();

			// Attribuer les listes des comptes � la requ�te
			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);
			req.setAttribute("clients", listeClient);

			// R�cup�rer le support de la d�l�gation
			rd = req.getRequestDispatcher("/accueil.jsp");

		} else {

			String message = "La suppresion a �chou� !";

			// Ajouter le message comme attribut de la requ�te
			req.setAttribute("msg", message);

			// R�cup�rer le support de la d�l�gation
			rd = req.getRequestDispatcher("/suppression_compte.jsp");

		}

		rd.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Appel de la m�thode doPost
		doPost(req, resp);
	}

}
