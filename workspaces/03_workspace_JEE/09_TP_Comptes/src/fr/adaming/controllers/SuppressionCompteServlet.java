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

@WebServlet(name = "supprimer", urlPatterns = { "/delete" })
public class SuppressionCompteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Transformation de l'association UML en Java
	private ICompteCourantService compteCourantService = new CompteCourantServiceImpl();
	private ICompteEpargneService compteEpargneService = new CompteEpargneServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int verif;

		// R�cup�rer les param�tres de la requ�te
		int id = Integer.parseInt(req.getParameter("pId"));

		String typeCompte = req.getParameter("pTypeCompte");

		// R�cup�rer la session http si elle existe d�j�, sinon retourner null
		HttpSession maSession = req.getSession(false); // Ne pas la cr�er si elle n'existe pas !

		// R�cup�rer le client de la session
		Client client = (Client) maSession.getAttribute("clientSession");

		// 2- Instanciation du compte � ajouter
		if (typeCompte.equals("compteCourant")) {
			CompteCourant compte = new CompteCourant(id);

			// Appel de la m�thode service
			verif = compteCourantService.deleteCompteById(client, compte);
		} else {
			CompteEpargne compte = new CompteEpargne(id);

			// Appel de la m�thode service
			verif = compteEpargneService.deleteCompteById(client, compte);
		}

		if (verif != 0) { // Si qqc a bien �t� ajout� dans la base de donn�es
			// R�cup�rer la nouvelle liste
			List<CompteCourant> listeCourant = compteCourantService.getAllCompte(client);
			List<CompteEpargne> listeEpargne = compteEpargneService.getAllCompte(client);

			// Ajouter la nouvelle liste dans la requ�te
			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);

			// R�cup�rer le support de la d�l�gation
			RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

			// D�l�guer la requ�te concr�tement
			rd.forward(req, resp);

		} else {

			String message = "La suppresion a �chou� !";

			// Ajouter le message comme attribut de la requ�te
			req.setAttribute("msg", message);

			// R�cup�rer le support de la d�l�gation
			RequestDispatcher rd = req.getRequestDispatcher("/suppression_compte.jsp");

			rd.forward(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doPost(req, resp);
	}

}
