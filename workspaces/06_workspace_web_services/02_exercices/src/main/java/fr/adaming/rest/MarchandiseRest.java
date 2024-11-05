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
import fr.adaming.entities.Marchandise;
import fr.adaming.service.IMarchandiseService;

@Path("/marchandise")
public class MarchandiseRest {

	@Autowired
	private IMarchandiseService marchService;

	// La méthode retourne la donnée au lieu d'un String ou d'un ModelAndView
	@Path("/searchById")
	@GET // Pour que cette méthode traite les requêtes HTTP en GET
	@Produces(MediaType.APPLICATION_JSON)
	public Marchandise rechercheMarchandiseById(@QueryParam("pId") Long id) {

		return marchService.getById(id);

	}

	@Path("/searchByCargaisonAerienne")
	@POST // Pour que cette méthode traite les requêtes HTTP en GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Marchandise> rechercheMarchandiseByCargaison(CargaisonAerienne cargIn) {

		return marchService.rechercheMarchandise(cargIn);

	}

	@Path("/searchByCargaisonRoutiere")
	@POST // Pour que cette méthode traite les requêtes HTTP en GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Marchandise> rechercheMarchandiseByCargaison(CargaisonRoutiere cargIn) {

		return marchService.rechercheMarchandise(cargIn);

	}

	@Path("/searchByMotClef")
	@GET // Pour que cette méthode traite les requêtes HTTP en GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> rechercheMarchandiseByMotClef(@QueryParam("pMotClef") String motClef) {

		return marchService.rechercheMarchandise(motClef);

	}

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> recupererListe() {
		return marchService.list();

	}

	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON) // Spécifier le format des données en entrée (envoyées par la requête)
	public Marchandise addMarchandise(Marchandise marchIn) {
		return marchService.save(marchIn);
	}

	@Path("/update")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Marchandise updateMarchandise(Marchandise marchIn) {
		return marchService.update(marchIn);
	}

	@Path("/delete/{pId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMarchandise(@PathParam("pId") Long id) {
		int verif = marchService.delete(id);

		if (verif != 0) {
			return Response.status(202).entity("<h1>La suppression est OK</h1>").build();
		}

		return Response.status(417).entity("<h1>La suppression est KO!</h1>").build();
	}

}
