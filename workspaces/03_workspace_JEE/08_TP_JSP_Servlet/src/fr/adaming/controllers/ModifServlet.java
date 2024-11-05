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

@WebServlet(name = "modifier", urlPatterns = { "/update" })
public class ModifServlet extends HttpServlet {

	// Transformation de l'association UML en Java
	private IEtudiantService eService = new EtudiantServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�rer les param�tres de la requ�te
		int id = Integer.parseInt(req.getParameter("pId"));
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		int age = Integer.parseInt(req.getParameter("pAge"));

		// Instancier un Etudiant avec ces valeurs
		Etudiant eIn = new Etudiant(id, nom, prenom, age);

		// R�cup�rer la session http si elle existe d�j�, sinon retourner null
		HttpSession maSession = req.getSession(false); // Ne pas la cr�er si elle n'existe pas !

		// R�cup�rer le formateur de la session
		Formateur formateur = (Formateur) maSession.getAttribute("fSession");

		// Appel de la m�thode service
		int verif = eService.updateEtudiant(formateur, eIn);

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

			String message = "La modification a �chou� !";

			// Ajouter le message comme attribut de la requ�te
			req.setAttribute("msg", message);

			// R�cup�rer le support de la d�l�gation
			RequestDispatcher rd = req.getRequestDispatcher("/modif.jsp");

			rd.forward(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// R�cup�rer les param�tres de la requ�te
		int id = Integer.parseInt(req.getParameter("pId"));

		// Instancier un Etudiant avec ces valeurs
		Etudiant eIn = new Etudiant();
		eIn.setId(id);

		// R�cup�rer la session http si elle existe d�j�, sinon retourner null
		HttpSession maSession = req.getSession(false); // Ne pas la cr�er si elle n'existe pas !

		// R�cup�rer le formateur de la session
		Formateur formateur = (Formateur) maSession.getAttribute("fSession");

		// Appel de la m�thode service
		Etudiant eOut = eService.getEtudiantById(formateur, eIn);

		// Ajouter l'�tudiant comme attribut de l'objet req
		req.setAttribute("eModif", eOut);

		// R�cup�rer le support de la d�l�gation
		RequestDispatcher rd = req.getRequestDispatcher("/modif.jsp");

		// D�l�guer la requ�te concr�tement
		rd.forward(req, resp);
	}

}
