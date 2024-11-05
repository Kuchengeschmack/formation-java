package fr.adaming.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MaPremiereServlet doit h�riter de HttpServlet pour le protocole HTTP

// D�clarer une servlet
@WebServlet(name = "toto", urlPatterns = { "/test" })
public class MaPremiereServlet extends HttpServlet {

	// red�finir la m�thode doGet pour traiter les requ�tes HTTP envoy�es avec la
	// m�thode HTTP
	// Cette m�thode accepte en entr�e
	// - un objet HttpServletRequest qui stocke les infos r�cup�r�es de la requ�te
	// HTTP
	// - un objet HttpServletResponse qui stocke les infos de la r�ponse HTTP

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----- Je suis pass� par la m�thode service de ma servlet -----");
		super.service(req, resp);
	}

	// Le r�le d'une servlet est de g�n�rer le contenu dynamiquement (g�n�rer des
	// pages html dynamiquement
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// R�cup�rer un objet de type printWriter (stylo) pour �crire dans la r�ponse
		PrintWriter out = resp.getWriter();

		// �crire dans l'objet r�ponse (�crire la r�ponse g�n�r�e par la servlet)

		resp.setContentType("text/plain");
		
		out.println("<h1> Bonjour tout le monde METHODE GET!</h1>");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// R�cup�rer un objet de type printWriter (stylo) pour �crire dans la r�ponse
		PrintWriter out = resp.getWriter();

		// �crire dans l'objet r�ponse (�crire la r�ponse g�n�r�e par la servlet)
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
