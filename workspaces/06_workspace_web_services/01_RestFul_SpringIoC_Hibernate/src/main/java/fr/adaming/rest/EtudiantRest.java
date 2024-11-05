package fr.adaming.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.entities.Etudiant;
import fr.adaming.service.IEtudiantService;

/* @Path remplace @Controller, et si on lui donne l'url, elle peut remplacer @RequestMapping
 * Elle permet de définir la classe web service Restful avec jax-rset lui donner une URI
 */

@Path("/ecole")
public class EtudiantRest {

	// Transformation de l'association UML en Java
	@Autowired
	private IEtudiantService etudiantService;

	// La méthode retourne la donnée au lieu d'un String ou d'un ModelAndView
	@Path("/search")
	@GET // Pour que cette méthode traite les requêtes HTTP en GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Etudiant rechercheEtudiant(@QueryParam("pId") int id) {

		return etudiantService.getEtudiantById(id);

	}

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> recupererListe() {
		return etudiantService.getAllEtudiants();

	}

	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // Spécifier le format des données en entrée (envoyées par la requête)
	public Etudiant addEtudiant(Etudiant eIn) {
		return etudiantService.addEtudiant(eIn);
	}

	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateEtudiant(Etudiant eIn) {
		etudiantService.updateEtudiant(eIn);
	}

	@Path("/delete/{pId}")
	@DELETE
	@Produces(MediaType.TEXT_PLAIN) // TEXT_PLAIN si on veut du texte brut
	public Response deleteEtudiant(@PathParam("pId") int id) {
		int verif = etudiantService.deleteEtudiant(id);

		if (verif != 0) {
			return Response.status(202).entity("<h1>La suppression est OK</h1>").build();
		}

		return Response.status(417).entity("<h1>La suppression est KO!</h1>").build();
	}
}
