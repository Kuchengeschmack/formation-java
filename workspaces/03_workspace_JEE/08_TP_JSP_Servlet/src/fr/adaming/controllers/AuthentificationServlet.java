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

import fr.adaming.entites.Etudiant;
import fr.adaming.entites.Formateur;
import fr.adaming.service.EtudiantServiceImpl;
import fr.adaming.service.FormateurServiceImpl;
import fr.adaming.service.IEtudiantService;
import fr.adaming.service.IFormateurService;

@WebServlet(name = "authentification", urlPatterns = { "/auth" })
public class AuthentificationServlet extends HttpServlet {

	// Transformation de l'association UML en Java
	private IFormateurService fService = new FormateurServiceImpl();
	private IEtudiantService eService = new EtudiantServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Récupérer les valeurs des paramètres
		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");

		// Instancier formateur avec ces valeurs
		Formateur fIn = new Formateur(mail, password);

		// Appel de la méthode service
		Formateur formateur = fService.isExist(fIn);

		if (formateur != null) {
			// Récupérer la session HTTP si elle existe, la créer sinon
			HttpSession maSession = req.getSession(); // On récupère la session à partir de la requête

			// Ajouter le formateur connecté comme attribut de la session HTTP
			maSession.setAttribute("fSession", formateur);

			// Récupérer la liste des étudiants du formateur connecté
			// La liste va jouer le rôle du modèle MVC
			List<Etudiant> liste = eService.getAllEtudiant(formateur); // Liste tous les étudiants du formateur

			// Ajouter la liste comme attribut de la requête afin de le transmettre à
			// accueil.jsp pour qu'elle puisse l'afficher
			req.setAttribute("etudiants", liste);

			// Récupérer le support de délégation (la jsp login.jsp va jouer le rôle de la
			// vue du Design pattern MVC)
			RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

			// Déléguer correctement la requête
			rd.forward(req, resp);
		} else {
			// La variable message va jouer le rôle du Design Patter MVC
			String message = "L'identifiant ou le mot de passe est erroné";

			// Ajouter le message comme attribut de la requête afin de le transmettre à
			// login.jsp
			req.setAttribute("msg", message);

			// Récupérer le support de délégation (la jsp login.jsp va jouer le rôle de la
			// vue du Design pattern MVC)
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");

			// Déléguer correctement la requête
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupérer la session HTTP
		HttpSession maSession = req.getSession(false);

		// Ajouter le formateur connecté comme attribut de la session HTTP
		Formateur formateur = (Formateur) maSession.getAttribute("fSession");

		// Récupérer la liste des étudiants du formateur connecté
		// La liste va jouer le rôle du modèle MVC
		List<Etudiant> liste = eService.getAllEtudiant(formateur); // Liste tous les étudiants du formateur

		// Ajouter la liste comme attribut de la requête afin de le transmettre à
		// accueil.jsp pour qu'elle puisse l'afficher
		req.setAttribute("etudiants", liste);

		// Récupérer le support de délégation (la jsp login.jsp va jouer le rôle de la
		// vue du Design pattern MVC)
		RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

		// Déléguer correctement la requête
		rd.forward(req, resp);
	}

}
