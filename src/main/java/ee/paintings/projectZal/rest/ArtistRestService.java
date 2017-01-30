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
	
	//C
	@PUT
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
	@Path("/find/first/{fName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Artist getArtistByFName(@PathParam(value = "fName") String fName){
		try {
			return am.findArtistByFName(fName);
		} catch (Exception e) {
			// TODO: handle exception
			return new Artist();
		}
	}
	
	@GET
	@Path("/find/last/{lName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Artist getArtistByLName(@PathParam(value = "lName") String lName){
		try {
			return am.findArtistByFName(lName);
		} catch (Exception e) {
			// TODO: handle exception
			return new Artist();
		}
	}
	
	//U
	@POST
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
	@Path("/{artistId}")
	public Response deleteArtist(@PathParam(value = "{artistId}") Long id){
		try {
			am.deleteArtist(id);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		return Response.status(Response.Status.ACCEPTED).build(); 
	}
	
}