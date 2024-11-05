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
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.CompteEpargneServiceImpl;
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
	private ICompteCourantService compteCourantService; // Typer par l'interface et ne pas oublier d'initaliser
	private ICompteEpargneService compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int verif;
		Client client;
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		RequestDispatcher rd;
		compteCourantService = new CompteCourantServiceImpl();
		compteEpargneService = new CompteEpargneServiceImpl();

		Double solde = Double.parseDouble(req.getParameter("pSolde"));
		String typeCompte = req.getParameter("pTypeCompte");

		HttpSession maSession = req.getSession(false);
		client = (Client) maSession.getAttribute("clientSession");

		if (typeCompte.equals("compteCourant")) {

			CompteCourant compte = new CompteCourant(solde);
			verif = compteCourantService.addCompte(client, compte);

		} else {

			CompteEpargne compte = new CompteEpargne(solde);
			verif = compteEpargneService.addCompte(client, compte);
		}

		if (verif != 0) {

			listeCourant = compteCourantService.getAllCompte(client);
			listeEpargne = compteEpargneService.getAllCompte(client);

			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);

			rd = req.getRequestDispatcher("/accueil.jsp");
		} else {

			String message = "L'ajout a échoué !";
			req.setAttribute("msg", message);

			rd = req.getRequestDispatcher("/ajout_compte.jsp");
		}

		rd.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
