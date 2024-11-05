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

		// Récupération du support de la délégation
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		
		// Message de confirmation de la déconnexion
		String message = "Vous avez bien été déconnecté !";
		req.setAttribute("msg", message);

		// Retour au login par délégation de la requête
		rd.forward(req, resp);
	}

}
