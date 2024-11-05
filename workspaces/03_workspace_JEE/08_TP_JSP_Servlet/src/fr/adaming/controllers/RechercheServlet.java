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

		// Récupérer les paramètres de la requête
		int id = Integer.parseInt(req.getParameter("pId"));

		// Instancier un Etudiant avec ces valeurs
		Etudiant eIn = new Etudiant();
		eIn.setId(id);

		// Récupérer la session http si elle existe déjà, sinon retourner null
		HttpSession maSession = req.getSession(false); // Ne pas la créer si elle n'existe pas !

		// Récupérer le formateur de la session
		Formateur formateur = (Formateur) maSession.getAttribute("fSession");

		// Appel de la méthode service
		Etudiant eOut = eService.getEtudiantById(formateur, eIn);

		if (eOut != null) {
			
			// Ajouter l'étudiant trouvé comme attribut de la requête
			req.setAttribute("etudiant", eOut);

		} else {

			String message = "La recherche est infructueuse !";

			// Ajouter le message comme attribut de la requête
			req.setAttribute("msg", message);

		}
		
		// Récupérer le support de la délégation
		RequestDispatcher rd = req.getRequestDispatcher("/recherche.jsp");

		// Déléguer la requête concrètement
		rd.forward(req, resp);

	}

	

}
