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

@WebServlet(name = "modifier", urlPatterns = { "/update" })
public class ModifCompteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CompteCourantServiceImpl compteCourantService;
	private CompteEpargneServiceImpl compteEpargneService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession maSession = req.getSession(false);
		Client client = (Client) maSession.getAttribute("clientSession");

		int id = Integer.parseInt(req.getParameter("pId"));
		Double solde = Double.parseDouble(req.getParameter("pSolde"));

		int verif;
		String typeCompte = req.getParameter("pTypeCompte");
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		RequestDispatcher rd;

		if (typeCompte.equals("compteCourant")) {

			CompteCourant compte = new CompteCourant(id, solde);
			verif = compteCourantService.updateCompte(client, compte);

		} else {

			CompteEpargne compte = new CompteEpargne(id, solde);
			verif = compteEpargneService.updateCompte(client, compte);
		}

		if (verif != 0) {
			listeCourant = compteCourantService.getAllCompte(client);
			listeEpargne = compteEpargneService.getAllCompte(client);

			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);

			rd = req.getRequestDispatcher("/accueil.jsp");

		} else {

			String message = "La modification a échoué !";
			req.setAttribute("msg", message);

			rd = req.getRequestDispatcher("/modif_compte.jsp");

		}

		rd.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

}
