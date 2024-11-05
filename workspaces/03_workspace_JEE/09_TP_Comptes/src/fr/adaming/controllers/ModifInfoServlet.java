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
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

@WebServlet(name = "modif_infos", urlPatterns = { "/modifInfo" })
public class ModifInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IClientService clientService = new ClientServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 0- Récupérer la session client
		HttpSession maSession = req.getSession(false); // Ne pas la créer si elle n'existe pas !
		Client client = (Client) maSession.getAttribute("clientSession");
		RequestDispatcher rd;
		String message = "Vos informations ont bien été modifiées !";

		// 1- Récupération des paramètres de la requête
		int id = client.getId();
		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		String adresse = req.getParameter("pAdresse");
		int codePostal = Integer.parseInt(req.getParameter("pCodePostal"));
		String ville = req.getParameter("pVille");
		int telephone = Integer.parseInt(req.getParameter("pTelephone"));

		// 2- Instanciation d'un Client
		Client clientIn = new Client(id, mail, password, nom, prenom, adresse, codePostal, ville, telephone);

		// 3- Mise à jour
		clientService.modifierClient(clientIn);

		req.setAttribute("msg", message);

		// Retour au login
		rd = req.getRequestDispatcher("/login.jsp");

		maSession.invalidate();

		rd.forward(req, resp);

	}
}
