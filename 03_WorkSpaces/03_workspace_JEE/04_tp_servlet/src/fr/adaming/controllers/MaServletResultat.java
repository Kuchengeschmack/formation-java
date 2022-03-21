package fr.adaming.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "resultat", urlPatterns = { "/resultat" })
public class MaServletResultat extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Récupérer les paramètres de la requête HTTP
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		
		int somme = a + b;
		
		// Récupérer l'objet PrintWriter
		PrintWriter out=resp.getWriter();
		
		resp.setContentType("text/html");
		
		// Écrire dans la réponse
		out.println("<h1>" + a + " + " + b + " = "  + somme + "</h1>");
		
	}
}
