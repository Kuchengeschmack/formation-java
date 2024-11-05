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

		req.getSession(false).invalidate();

		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		
		String message = "Vous avez bien été déconnecté !";
		
		req.setAttribute("msg", message);

		rd.forward(req, resp);
	}

}
