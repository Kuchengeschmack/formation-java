package fr.adaming.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "fofo", urlPatterns = { "/serv2" })
public class MaServlet2 extends HttpServlet {

	// Je suis obligé de traiter la requête par la même méthode de servlet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Récupérer l'attribut de l'objet
		String messageRecup = (String) req.getAttribute("msg");

		// Récupérer le PrintWriter pour écrire la réponse
		PrintWriter out = resp.getWriter();

		// Spécifier le format de la réponse
		resp.setContentType("text/html");

		// Écrire la réponse
		out.println("<h1 style='color:red'>Je suis la réponse de la servlet 2<h1>");
		out.println("<h2 style='color:blue'>" + messageRecup + "</h2>");
	}
}
