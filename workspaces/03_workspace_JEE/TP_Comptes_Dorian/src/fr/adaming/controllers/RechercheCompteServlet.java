package fr.adaming.controllers;

import java.io.IOException;

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
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.ICompteCourantService;
import fr.adaming.service.ICompteEpargneService;

@WebServlet(name = "rechercher", urlPatterns = "/search")
public class RechercheCompteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// D�claration des objets service pour manipuler les comptes
	private ICompteCourantService compteCourantService;
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�ration de la session client
		HttpSession maSession = req.getSession(false);
		Client client = (Client) maSession.getAttribute("clientSession");

		// D�claration des variables locales
		String message = "La recherche est infructueuse !";
		RequestDispatcher rd;

		// Initialisation des objets service
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();

		// R�cup�ration des param�tres de la requ�te
		int id = Integer.parseInt(req.getParameter("pId"));
		String typeCompte = req.getParameter("pTypeCompte");

		// Action selon le type de compte

		if (typeCompte.equals("compteCourant")) {

			// Recherhe du compte selon son id
			CompteCourant compte = new CompteCourant(id);
			compte = compteCourantService.getCompteById(client, compte);

			// V�rifier que le compte a bien �t� trouv�
			if (compte != null) {

				req.setAttribute("compte", compte);

			} else {

				req.setAttribute("msg", message);
			}

		} else {

			// Recherhe du compte selon son id
			CompteEpargne compte = new CompteEpargne(id);
			compte = compteEpargneService.getCompteById(client, compte);

			// V�rifier que le compte a bien �t� trouv�
			if (compte != null) {

				req.setAttribute("compte", compte);

			} else {

				req.setAttribute("msg", message);

			}

		}

		// Obtention du support de d�l�gation
		rd = req.getRequestDispatcher("/recherche_compte.jsp");

		// D�l�gation de la requ�te
		rd.forward(req, resp);

	}

}
