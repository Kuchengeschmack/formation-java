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

import fr.adaming.entities.CargaisonAerienne;
import fr.adaming.entities.CargaisonRoutiere;
import fr.adaming.service.ICargaisonAerienneService;
import fr.adaming.service.ICargaisonRoutiereService;

@Path("/cargaison")
public class CargaisonRest {

	@Autowired
	private ICargaisonAerienneService cargAerService;

	@Autowired
	private ICargaisonRoutiereService cargRoutService;

	// Méthodes pour les CargaisonRoutiere

	// La méthode retourne la donnée au lieu d'un String ou d'un ModelAndView
	@Path("/searchCargRout")
	@GET // Pour que cette méthode traite les requêtes HTTP en GET
	@Produces(MediaType.APPLICATION_JSON)
	public CargaisonRoutiere rechercheCargRout(@QueryParam("pId") Long id) {

		return cargRoutService.getById(id);

	}

	@Path("/listCargRout")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CargaisonRoutiere> recupererListe() {
		return cargRoutService.list();

	}

	@Path("/addCargRout")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // Spécifier le format des données en entrée (envoyées par la requête)
	public CargaisonRoutiere addCargRout(CargaisonRoutiere cargRoutIn) {
		return cargRoutService.save(cargRoutIn);
	}

	@Path("/updateCargRout")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCargRout(CargaisonRoutiere cargRoutIn) {
		cargRoutService.update(cargRoutIn);
	}

	@Path("/deleteCargRout/{pId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCargRout(@PathParam("pId") Long id) {

		int verif = cargRoutService.delete(id);

		if (verif != 0) {
			return Response.status(202).entity("<h1>La suppression est OK</h1>").build();
		}

		return Response.status(417).entity("<h1>La suppression est KO!</h1>").build();
	}

	// Méthodes pour les CargaisonAerienne

	// La méthode retourne la donnée au lieu d'un String ou d'un ModelAndView
	@Path("/searchCargAer")
	@GET // Pour que cette méthode traite les requêtes HTTP en GET
	@Produces(MediaType.APPLICATION_JSON)
	public CargaisonAerienne rechercheCargAer(@QueryParam("pId") Long id) {

		return cargAerService.getById(id);

	}

	@Path("/listCargRout")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CargaisonAerienne> recupererListe2() {
		return cargAerService.list();

	}

	@Path("/addCargAer")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // Spécifier le format des données en entrée (envoyées par la requête)
	public CargaisonAerienne addCargAer(CargaisonAerienne cargRoutIn) {
		return cargAerService.save(cargRoutIn);
	}

	@Path("/updateCargAer")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCargAer(CargaisonAerienne cargRoutIn) {
		cargAerService.update(cargRoutIn);
	}

	@Path("/deleteCargAer/{pId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCargAer(@PathParam("pId") Long id) {

		int verif = cargAerService.delete(id);

		if (verif != 0) {
			return Response.status(202).entity("<h1>La suppression est OK</h1>").build();
		}

		return Response.status(417).entity("<h1>La suppression est KO!</h1>").build();
	}
}
