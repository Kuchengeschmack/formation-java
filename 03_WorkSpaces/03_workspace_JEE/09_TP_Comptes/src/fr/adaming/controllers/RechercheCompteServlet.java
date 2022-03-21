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
	private ICompteCourantService compteCourantService = new CompteCourantServiceImpl();
	private ICompteEpargneService compteEpargneService = new CompteEpargneServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession maSession = req.getSession(false);
		Client client = (Client) maSession.getAttribute("clientSession");
		String message = "La recherche est infructueuse !";
		RequestDispatcher rd;

		int id = Integer.parseInt(req.getParameter("pId"));
		String typeCompte = req.getParameter("pTypeCompte");

		if (typeCompte.equals("compteCourant")) {
			CompteCourant compte = new CompteCourant(id);
			compte = compteCourantService.getCompteById(client, compte);

			if (compte != null) {

				req.setAttribute("compte", compte);

			} else {

				req.setAttribute("msg", message);
			}

		} else {
			CompteEpargne compte = new CompteEpargne(id);
			compte = compteEpargneService.getCompteById(client, compte);

			if (compte != null) {

				req.setAttribute("compte", compte);

			} else {

				req.setAttribute("msg", message);

			}

		}

		rd = req.getRequestDispatcher("/recherche_compte.jsp");
		rd.forward(req, resp);

	}

}
