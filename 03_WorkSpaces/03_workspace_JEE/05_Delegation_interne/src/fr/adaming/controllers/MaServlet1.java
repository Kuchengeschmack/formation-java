package fr.adaming.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "toto", urlPatterns = { "/serv1" })
public class MaServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = "Je suis passé par la 1ère servlet";

		// Ajouter le message comme attribut de req pour pouvoir le transférer dans
		// Servlet2
		req.setAttribute("msg", message);

		// Récupérer le support de délégation pour pouvoir déléguer la requête de s1
		// vers s2
		RequestDispatcher rd = req.getRequestDispatcher("/serv2");

		// Transférer concrètement la requête vers s2
		rd.forward(req, resp);

		// Après le transfert, la servlet MaServlet1 perd le contrôle sur la requête

	}

}
