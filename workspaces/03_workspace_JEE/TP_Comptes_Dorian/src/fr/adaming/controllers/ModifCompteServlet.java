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

@WebServlet(name = "modifier", urlPatterns = { "/update" })
public class ModifCompteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// D�claration des objets service
	private IClientService clientService;
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�ration de la session client
		HttpSession maSession = req.getSession(false);
		Client client = (Client) maSession.getAttribute("clientSession");

		// R�cup�ration des param�tres de la requ�te
		int id = Integer.parseInt(req.getParameter("pId"));
		Double solde = Double.parseDouble(req.getParameter("pSolde"));
		String typeCompte = req.getParameter("pTypeCompte");

		// D�claration des variables locales
		int verif;
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		List<Client> listeClient;
		RequestDispatcher rd;

		// Initialisation des objets service
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();
		clientService = new ClientServiceImpl();

		// Action diff�rente selon le type de compte

		if (typeCompte.equals("compteCourant")) {

			CompteCourant compte = new CompteCourant(id, solde);
			// Appel de la m�thode service
			verif = compteCourantService.updateCompte(client, compte);

		} else {

			CompteEpargne compte = new CompteEpargne(id, solde);
			// Appel de la m�thode service
			verif = compteEpargneService.updateCompte(client, compte);
		}

		if (verif != 0) {

			// R�cup�ration des listes de comptes
			listeCourant = compteCourantService.getAllCompte(client);
			listeEpargne = compteEpargneService.getAllCompte(client);
			listeClient = clientService.getAllClient();

			// Attribution des listes de comptes � la requ�te
			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);
			req.setAttribute("clients", listeClient);

			// R�cup�ration du support de d�l�gation
			rd = req.getRequestDispatcher("/accueil.jsp");

		} else {

			// Message d'erreur en cas d'�chec de la modification
			String message = "La modification a �chou� !";
			req.setAttribute("msg", message);

			// R�cup�ration du support de d�l�gation
			rd = req.getRequestDispatcher("/modif_compte.jsp");

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
