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

		String message = "Je suis pass� par la 1�re servlet";

		// Ajouter le message comme attribut de req pour pouvoir le transf�rer dans
		// Servlet2
		req.setAttribute("msg", message);

		// R�cup�rer le support de d�l�gation pour pouvoir d�l�guer la requ�te de s1
		// vers s2
		RequestDispatcher rd = req.getRequestDispatcher("/serv2");

		// Transf�rer concr�tement la requ�te vers s2
		rd.forward(req, resp);

		// Apr�s le transfert, la servlet MaServlet1 perd le contr�le sur la requ�te

	}

}
