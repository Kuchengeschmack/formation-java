package fr.adaming.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// D�clarer une servlet � partir de la version 3.0
@WebServlet(name = "toto", urlPatterns = { "/test" })
public class MaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�rer l'objet PrintWriter afin de pouvoir �crire dans la r�ponse
		PrintWriter out = resp.getWriter();

		// Sp�cifier le format de la r�ponse envoy�e au navigateur (contenttype, le type
		// mime)
		resp.setContentType("text/html");

		// R�cup�rer la m�thode Http utilis�e
		out.println("<b>La m�thode HTTP : </b>" + req.getMethod());
		
		// R�cup�rer l'url de la requ�te HTTP
		out.println("<br/><b>L'URL de la requ�te: </b>"+req.getRequestURL());
		
		// R�cup�rer l'uri de la requ�te HTTP
		out.println("<br/><b>L'URI de la requ�te: </b>"+req.getRequestURI());
		
		// R�cup�rer le contexte de la requ�te
		out.println("<br/><b>Le contexte de la requ�te: </b>"+req.getContextPath());
		
		// R�cup�rer l'url pattern de la servlet
		out.println("<br/><b>L'url pattern de la servlet: </b>"+req.getServletPath());
	}

}
