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
import fr.adaming.service.IEtudiantService;

@WebServlet(name = "ajouter", urlPatterns = { "/add" })
public class AjoutServlet extends HttpServlet {

	// Transformation de l'association UML en Java
	private IEtudiantService eService = new EtudiantServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�rer les param�tres de la requ�te
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		int age = Integer.parseInt(req.getParameter("pAge"));

		// Instancier un Etudiant avec ces valeurs
		Etudiant eIn = new Etudiant(nom, prenom, age);

		// R�cup�rer la session http si elle existe d�j�, sinon retourner null
		HttpSession maSession = req.getSession(false); // Ne pas la cr�er si elle n'existe pas !

		// R�cup�rer le formateur de la session
		Formateur formateur = (Formateur) maSession.getAttribute("fSession");

		// Appel de la m�thode service
		int verif = eService.addEtudiant(formateur, eIn);

		if (verif != 0) { // Si qqc a bien �t� ajout� dans la base de donn�es
			// R�cup�rer la nouvelle liste
			List<Etudiant> liste = eService.getAllEtudiant(formateur);

			// Ajouter la nouvelle liste dans la requ�te
			req.setAttribute("etudiants", liste);

			// R�cup�rer le support de la d�l�gation
			RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

			// D�l�guer la requ�te concr�tement
			rd.forward(req, resp);

		} else {

			String message = "L'ajout a �chou� !";

			// Ajouter le message comme attribut de la requ�te
			req.setAttribute("msg", message);

			// R�cup�rer le support de la d�l�gation
			RequestDispatcher rd = req.getRequestDispatcher("/ajout.jsp");

			rd.forward(req, resp);
		}

	}

}
