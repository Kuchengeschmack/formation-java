package fr.adaming.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MaPremiereServlet doit hériter de HttpServlet pour le protocole HTTP

// Déclarer une servlet
@WebServlet(name = "toto", urlPatterns = { "/test" })
public class MaPremiereServlet extends HttpServlet {

	// redéfinir la méthode doGet pour traiter les requêtes HTTP envoyées avec la
	// méthode HTTP
	// Cette méthode accepte en entrée
	// - un objet HttpServletRequest qui stocke les infos récupérées de la requête
	// HTTP
	// - un objet HttpServletResponse qui stocke les infos de la réponse HTTP

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----- Je suis passé par la méthode service de ma servlet -----");
		super.service(req, resp);
	}

	// Le rôle d'une servlet est de générer le contenu dynamiquement (générer des
	// pages html dynamiquement
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupérer un objet de type printWriter (stylo) pour écrire dans la réponse
		PrintWriter out = resp.getWriter();

		// Écrire dans l'objet réponse (écrire la réponse générée par la servlet)

		resp.setContentType("text/plain");
		
		out.println("<h1> Bonjour tout le monde METHODE GET!</h1>");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Récupérer un objet de type printWriter (stylo) pour écrire dans la réponse
		PrintWriter out = resp.getWriter();

		// Écrire dans l'objet réponse (écrire la réponse générée par la servlet)
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Ma Page </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> Bonjour tout le monde METHODE POST!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
