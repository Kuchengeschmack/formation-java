package fr.adaming.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "deconnexion", urlPatterns = { "/logout" })
public class LogOutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Invalider la session
		req.getSession(false).invalidate();

		// R�cup�ration du support de la d�l�gation
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		
		// Message de confirmation de la d�connexion
		String message = "Vous avez bien �t� d�connect� !";
		req.setAttribute("msg", message);

		// Retour au login par d�l�gation de la requ�te
		rd.forward(req, resp);
	}

}
