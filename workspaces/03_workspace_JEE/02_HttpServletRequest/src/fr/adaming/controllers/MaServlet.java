package fr.adaming.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Déclarer une servlet à partir de la version 3.0
@WebServlet(name = "toto", urlPatterns = { "/test" })
public class MaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Récupérer l'objet PrintWriter afin de pouvoir écrire dans la réponse
		PrintWriter out = resp.getWriter();

		// Spécifier le format de la réponse envoyée au navigateur (contenttype, le type
		// mime)
		resp.setContentType("text/html");

		// Récupérer la méthode Http utilisée
		out.println("<b>La méthode HTTP : </b>" + req.getMethod());
		
		// Récupérer l'url de la requête HTTP
		out.println("<br/><b>L'URL de la requête: </b>"+req.getRequestURL());
		
		// Récupérer l'uri de la requête HTTP
		out.println("<br/><b>L'URI de la requête: </b>"+req.getRequestURI());
		
		// Récupérer le contexte de la requête
		out.println("<br/><b>Le contexte de la requête: </b>"+req.getContextPath());
		
		// Récupérer l'url pattern de la servlet
		out.println("<br/><b>L'url pattern de la servlet: </b>"+req.getServletPath());
	}

}
