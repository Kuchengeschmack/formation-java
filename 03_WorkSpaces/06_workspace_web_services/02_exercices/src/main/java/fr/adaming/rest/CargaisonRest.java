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

import fr.adaming.entities.Cargaison;
import fr.adaming.service.ICargaisonService;

@Path("/cargaison")
public class CargaisonRest {

	@Autowired
	private ICargaisonService cargService;

	// Méthodes pour les CargaisonRoutiere

	// La méthode retourne la donnée au lieu d'un String ou d'un ModelAndView
	@Path("/search")
	@GET // Pour que cette méthode traite les requêtes HTTP en GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cargaison rechercheCarg(@QueryParam("pId") Long id) {

		return cargService.getById(id);

	}

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargaison> recupererListe() {
		return cargService.list();

	}

	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // Spécifier le format des données en entrée (envoyées par la requête)
	public Cargaison addCarg(Cargaison cargIn) {
		return cargService.save(cargIn);
	}

	@Path("/update")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Cargaison updateCarg(Cargaison cargIn) {
		return cargService.update(cargIn);
	}

	@Path("/delete/{pId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCarg(@PathParam("pId") Long id) {

		int verif = cargService.delete(id);

		if (verif != 0) {
			return Response.status(202).entity("<h1>La suppression est OK</h1>").build();
		}

		return Response.status(417).entity("<h1>La suppression est KO!</h1>").build();
	}

}
