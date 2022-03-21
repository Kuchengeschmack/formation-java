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

		// Récupérer les paramètres de la requête
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		int age = Integer.parseInt(req.getParameter("pAge"));

		// Instancier un Etudiant avec ces valeurs
		Etudiant eIn = new Etudiant(nom, prenom, age);

		// Récupérer la session http si elle existe déjà, sinon retourner null
		HttpSession maSession = req.getSession(false); // Ne pas la créer si elle n'existe pas !

		// Récupérer le formateur de la session
		Formateur formateur = (Formateur) maSession.getAttribute("fSession");

		// Appel de la méthode service
		int verif = eService.addEtudiant(formateur, eIn);

		if (verif != 0) { // Si qqc a bien été ajouté dans la base de données
			// Récupérer la nouvelle liste
			List<Etudiant> liste = eService.getAllEtudiant(formateur);

			// Ajouter la nouvelle liste dans la requête
			req.setAttribute("etudiants", liste);

			// Récupérer le support de la délégation
			RequestDispatcher rd = req.getRequestDispatcher("/accueil.jsp");

			// Déléguer la requête concrètement
			rd.forward(req, resp);

		} else {

			String message = "L'ajout a échoué !";

			// Ajouter le message comme attribut de la requête
			req.setAttribute("msg", message);

			// Récupérer le support de la délégation
			RequestDispatcher rd = req.getRequestDispatcher("/ajout.jsp");

			rd.forward(req, resp);
		}

	}

}
