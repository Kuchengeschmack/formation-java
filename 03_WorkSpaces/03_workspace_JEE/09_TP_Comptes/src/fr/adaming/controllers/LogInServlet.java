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
	private IClientService clientService = new ClientServiceImpl();
	private ICompteCourantService compteCourantService = new CompteCourantServiceImpl();
	private ICompteEpargneService compteEpargneService = new CompteEpargneServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");

		Client client = new Client(mail, password);
		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		RequestDispatcher rd;

		client = clientService.isExist(client);

		if (client != null) {

			HttpSession maSession = req.getSession();
			maSession.setAttribute("clientSession", client);

			listeCourant = compteCourantService.getAllCompte(client);
			listeEpargne = compteEpargneService.getAllCompte(client);

			req.setAttribute("comptesCourant", listeCourant);
			req.setAttribute("comptesEpargne", listeEpargne);

			rd = req.getRequestDispatcher("/accueil.jsp");

		} else {

			String message = "L'identifiant ou le mot de passe est erroné";
			req.setAttribute("msg", message);

			rd = req.getRequestDispatcher("/login.jsp");

		}

		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<CompteCourant> listeCourant;
		List<CompteEpargne> listeEpargne;
		RequestDispatcher rd;

		HttpSession maSession = req.getSession();
		Client client = (Client) maSession.getAttribute("clientSession");

		listeCourant = compteCourantService.getAllCompte(client);
		listeEpargne = compteEpargneService.getAllCompte(client);

		req.setAttribute("comptesCourant", listeCourant);
		req.setAttribute("comptesEpargne", listeEpargne);

		rd = req.getRequestDispatcher("/accueil.jsp");
		rd.forward(req, resp);
	}

}
