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

	// Je suis oblig� de traiter la requ�te par la m�me m�thode de servlet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�rer l'attribut de l'objet
		String messageRecup = (String) req.getAttribute("msg");

		// R�cup�rer le PrintWriter pour �crire la r�ponse
		PrintWriter out = resp.getWriter();

		// Sp�cifier le format de la r�ponse
		resp.setContentType("text/html");

		// �crire la r�ponse
		out.println("<h1 style='color:red'>Je suis la r�ponse de la servlet 2<h1>");
		out.println("<h2 style='color:blue'>" + messageRecup + "</h2>");
	}
}
