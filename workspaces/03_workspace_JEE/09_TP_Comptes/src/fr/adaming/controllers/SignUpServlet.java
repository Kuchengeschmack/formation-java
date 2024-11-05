package fr.adaming.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.adaming.entities.Client;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

/**
 * Servlet servant à la création de compte. Elle permet au client de créer un
 * compte en renseignant ses information et mail + mdp
 * 
 * @see signUp.jsp
 * @author Dorian
 *
 */

@WebServlet(name = "creationCompte", urlPatterns = { "/signUp" })
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IClientService clientService = new ClientServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd;
		String message = "Votre compte a bien été créé !";

		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		String adresse = req.getParameter("pAdresse");
		int codePostal = Integer.parseInt(req.getParameter("pCodePostal"));
		String ville = req.getParameter("pVille");
		int telephone = Integer.parseInt(req.getParameter("pTelephone"));

		Client client = new Client(mail, password, nom, prenom, adresse, codePostal, ville, telephone);

		// 3- Vérifier si le client existe dans la BDD SQL
		clientService.ajouterClient(client);

		req.setAttribute("msg", message);

		rd = req.getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);

	}
}
