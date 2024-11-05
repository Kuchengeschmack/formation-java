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

@WebServlet(name="rechercher", urlPatterns="/search")
public class RechercheServlet extends HttpServlet {
	
	// Transformation de l'association UML en Java
	private IEtudiantService eService = new EtudiantServiceImpl();

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

		if (eOut != null) {
			
			// Ajouter l'�tudiant trouv� comme attribut de la requ�te
			req.setAttribute("etudiant", eOut);

		} else {

			String message = "La recherche est infructueuse !";

			// Ajouter le message comme attribut de la requ�te
			req.setAttribute("msg", message);

		}
		
		// R�cup�rer le support de la d�l�gation
		RequestDispatcher rd = req.getRequestDispatcher("/recherche.jsp");

		// D�l�guer la requ�te concr�tement
		rd.forward(req, resp);

	}

	

}
