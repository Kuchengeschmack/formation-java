package fr.adaming.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.entities.Etudiant;
import fr.adamng.service.IEtudiantService;

/* @Path remplace @Controller, et si on lui donne l'url, elle peut remplacer @RequestMapping
 * Elle permet de définir la classe web service Restful avec jax-rset lui donner une URI
 */

@Path("/ecole")
public class EtudiantRest {

	// Transformation de l'association UML en Java
	@Autowired
	private IEtudiantService etudiantService;

	// La méthode retourne la donnée au lieu d'un String ou d'un ModelAndView
	@Path("/searchEtudiant")
	// Pour que cette méthode traite les requêtes HTTP en GET
	@GET
	public Etudiant rechercheEtudiant(@QueryParam("pId") int id) {

		return etudiantService.getEtudiantById(id);

	}

}
