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

	// Déclaration des objets client
	private IClientService clientService = new ClientServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Récupération des paramètres de la requête
		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		String adresse = req.getParameter("pAdresse");
		int codePostal = Integer.parseInt(req.getParameter("pCodePostal"));
		String ville = req.getParameter("pVille");
		int telephone = Integer.parseInt(req.getParameter("pTelephone"));

		// Déclaration des variables locales
		RequestDispatcher rd;
		String message = "Votre compte a bien été créé !";

		// Instanciation du client
		Client client = new Client(mail, password, nom, prenom, adresse, codePostal, ville, telephone);

		// Vérifier qu'un client avec les mêmes mails et mots de passe n'existe pas déjà

		// Ajout du client par appel de la méthode service
		clientService.ajouterClient(client); // Renvoie une valeur de vérification, à vérifier

		// Message de succès
		req.setAttribute("msg", message);

		// Récupération du support de délégation
		rd = req.getRequestDispatcher("/login.jsp");

		// Délégation de la requête
		rd.forward(req, resp);

	}
}
