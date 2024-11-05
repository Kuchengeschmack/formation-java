package fr.adaming.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.adaming.entities.Client;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

@WebServlet(name = "modif_infos", urlPatterns = { "/modifInfo" })
public class ModifInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// D�claration de l'objet service pour manipuler les clients
	private IClientService clientService = new ClientServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// R�cup�rer la session client
		HttpSession maSession = req.getSession(false); // Ne pas la cr�er si elle n'existe pas !
		Client client = (Client) maSession.getAttribute("clientSession");

		// R�cup�ration des param�tres de la requ�te pour modifier les informations
		// client
		String mail = req.getParameter("pMail");
		String password = req.getParameter("pPassword");
		String nom = req.getParameter("pNom");
		String prenom = req.getParameter("pPrenom");
		String adresse = req.getParameter("pAdresse");
		int codePostal = Integer.parseInt(req.getParameter("pCodePostal"));
		String ville = req.getParameter("pVille");
		int telephone = Integer.parseInt(req.getParameter("pTelephone"));

		// R�cup�ration de l'identifiant client. L'identifiant client ne change pas
		int id = client.getId();

		// D�claration des variables locales
		RequestDispatcher rd;
		
		// Instanciation du client modifi�, qui remplacera le client dans la BD
		Client clientIn = new Client(id, mail, password, nom, prenom, adresse, codePostal, ville, telephone);
		
		// Modification du client dans la BD
		clientService.modifierClient(clientIn); // Retourne une valeur � v�rifier !!!!!!!

		// Message pour notifier de la bonne ex�cution
		String message = "Vos informations ont bien �t� modifi�es !";
		req.setAttribute("msg", message);

		// R�cup�ration du support de d�l�gation
		rd = req.getRequestDispatcher("/login.jsp");

		// Invalider la session pour inviter l'utilisateur � se connecter avec ses identifiants
		maSession.invalidate();

		// D�l�gation de la requ�te
		rd.forward(req, resp);

	}
}
