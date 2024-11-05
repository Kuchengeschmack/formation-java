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

		// R�cup�rer les valeurs des param�tres
		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");

		// Instancier formateur avec ces valeurs
		Formateur fIn = new Formateur(mail, password);

		// Appel de la m�thode service
		Formateur formateur = fService.isExist(fIn);

		if (formateur != null) {
			// R�cup�rer la session HTTP si elle existe, la cr�er sinon
			HttpSession maSession = req.getSession(); // On r�cup�re la session � partir de la requ�te

			// Ajouter le formateur connect� comme attribut de la session HTTP
			maSession.setAttribute("fSession", formateur);

			// R�cup�rer la liste des �tudiants du formateur connect�
			// La liste va jouer le r�le du mod�le MVC
			List<Etudiant> liste = eService.getAllEtudiant(formateur); // Liste tous les �tudiants du formateur

			// Ajouter la liste comme attribut de la requ�te afin de le transmettre �
			// accueil.jsp pour qu'elle puisse l'afficher
			req.setAttribute("etudiants", liste);

			// R�cup�rer le support de d�l�gation (la jsp login.jsp va jouer le r�le de la
			// vue du Design pattern MVC)
			RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

			// D�l�guer correctement la requ�te
			rd.forward(req, resp);
		} else {
			// La variable message va jouer le r�le du Design Patter MVC
			String message = "L'identifiant ou le mot de passe est erron�";

			// Ajouter le message comme attribut de la requ�te afin de le transmettre �
			// login.jsp
			req.setAttribute("msg", message);

			// R�cup�rer le support de d�l�gation (la jsp login.jsp va jouer le r�le de la
			// vue du Design pattern MVC)
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");

			// D�l�guer correctement la requ�te
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// R�cup�rer la session HTTP
		HttpSession maSession = req.getSession(false);

		// Ajouter le formateur connect� comme attribut de la session HTTP
		Formateur formateur = (Formateur) maSession.getAttribute("fSession");

		// R�cup�rer la liste des �tudiants du formateur connect�
		// La liste va jouer le r�le du mod�le MVC
		List<Etudiant> liste = eService.getAllEtudiant(formateur); // Liste tous les �tudiants du formateur

		// Ajouter la liste comme attribut de la requ�te afin de le transmettre �
		// accueil.jsp pour qu'elle puisse l'afficher
		req.setAttribute("etudiants", liste);

		// R�cup�rer le support de d�l�gation (la jsp login.jsp va jouer le r�le de la
		// vue du Design pattern MVC)
		RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

		// D�l�guer correctement la requ�te
		rd.forward(req, resp);
	}

}
