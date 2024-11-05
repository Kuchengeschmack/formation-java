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
 * Servlet servant � la cr�ation de compte. Elle permet au client de cr�er un
 * compte en renseignant ses information et mail + mdp
 * 
 * @see signUp.jsp
 * @author Dorian
 *
 */

@WebServlet(name = "creationCompte", urlPatterns = { "/signUp" })
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// D�claration des objets client
	private IClientService clientService = new ClientServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�ration des param�tres de la requ�te
		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		String adresse = req.getParameter("pAdresse");
		int codePostal = Integer.parseInt(req.getParameter("pCodePostal"));
		String ville = req.getParameter("pVille");
		int telephone = Integer.parseInt(req.getParameter("pTelephone"));

		// D�claration des variables locales
		RequestDispatcher rd;
		String message = "Votre compte a bien �t� cr�� !";

		// Instanciation du client
		Client client = new Client(mail, password, nom, prenom, adresse, codePostal, ville, telephone);

		// V�rifier qu'un client avec les m�mes mails et mots de passe n'existe pas d�j�

		// Ajout du client par appel de la m�thode service
		clientService.ajouterClient(client); // Renvoie une valeur de v�rification, � v�rifier

		// Message de succ�s
		req.setAttribute("msg", message);

		// R�cup�ration du support de d�l�gation
		rd = req.getRequestDispatcher("/login.jsp");

		// D�l�gation de la requ�te
		rd.forward(req, resp);

	}
}
