package fr.adaming.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "formulaire", urlPatterns = { "/formulaire" })
public class MaServletFormulaire extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Récupérer l'objet PrintWriter
		PrintWriter out=resp.getWriter();
		
		resp.setContentType("text/html");
		
		// Écrire dans la réponse
		out.println(" <form action='resultat' method='post'>" + 
				"  <label for='a'>a</label>" + 
				"  <input type='number' name='a'><br><br>" + 
				"  <label for='b'>b</label>" + 
				"  <input type='number' name='b'><br><br>" + 
				"  <input type='submit' value='Additionner'>" + 
				"</form>");
		
		
	}
}
