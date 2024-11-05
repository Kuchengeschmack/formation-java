package fr.adaming.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "coucou", urlPatterns = { "/serv" })
public class MaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----- Je suis dans la méthode doGet.");
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----- Je suis dans la méthode service.");
		super.service(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("----- Initialisation de la servlet.");
	}
	
	@Override
	public void destroy() {
		System.out.println("----- Je suis dans la méthode destroy.");
	}
	
}
