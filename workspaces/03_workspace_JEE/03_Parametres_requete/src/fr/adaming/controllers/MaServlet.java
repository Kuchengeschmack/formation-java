package fr.adaming.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// R�cup�rer les param�tres de la requ�te HTTP
		String prenom = req.getParameter("pPrenom");
		String nom = req.getParameter("pNom");
		
		// R�cup�rer l'objet PrintWriter
		PrintWriter out=resp.getWriter();
		
		resp.setContentType("text/html");
		
		// �crire dans la r�ponse
		out.println("<h1>Bonjour " + prenom + " " + nom + " </h1>");
		
	}
}
