package ee.paintings.projectZal.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ee.paintings.projectZal.domain.Artist;
import ee.paintings.projectZal.service.ArtistManager;

@Stateless
@Path("artist")
public class ArtistRestService {
	
	@EJB
	ArtistManager am;
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Artist Service";
	}
	
	//add to reproductors
	@PUT
	@Path("reproductors/{aId}/{rId}")
	public Response addToReproductors(
			@PathParam(value = "rId") Long rId,
			@PathParam(value = "aId") Long aId){
		
		try {
			am.addToReproductors(rId, aId);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.CONFLICT).build();
		}
		
		return Response.status(Response.Status.CREATED).build();
	}
	
	
	//add to paintings
	@PUT
	@Path("paintings/{aId}/{pId}")
	public Response addToPaintings(
			@PathParam(value = "pId") Long pId,
			@PathParam(value = "aId") Long aId){
		
		try {
			am.addToPaintings(pId, aId);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.CONFLICT).build();
		}
		
		return Response.status(Response.Status.CREATED).build();
	}
	
	
	//C
	@PUT
	@Path("/add")
	public Response addArtist(Artist a){
		try {
			am.addArtist(a);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		return Response.status(Response.Status.CREATED).build();
	}
	
	//R
	@GET
	@Path("/find/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Artist> getAllArtists(){
		try {
			return am.getAllArtists();
		} catch (Exception e) {
			// TODO: handle exception
			return new ArrayList<Artist>();
		}
	}
	
	@GET
	@Path("/find/id/{artistId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Artist getAtristById(@PathParam(value = "artistId") Long id){
		try {
			return am.findArtistById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return new Artist();
		}
	}
	
	@GET
	@Path("/find/name/{nickName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Artist getArtistByFName(@PathParam(value = "nickName") String nickName){
		try {
			return am.findArtistByNickName(nickName);
		} catch (Exception e) {
			// TODO: handle exception
			return new Artist();
		}
	}
	
	//U
	@POST
	@Path("/update")
	public Response updateArtist(Artist a){
		try {
			am.updateArtist(a);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_MODIFIED).build();
		}
		return Response.status(Response.Status.ACCEPTED).build();
	}
	
	//D
	@DELETE
	@Path("/delete/{id}")
	public Response deleteArtist(@PathParam(value = "id") Long id){
		try {
			am.deleteArtist(id);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		return Response.status(Response.Status.ACCEPTED).build(); 
	}
	
}