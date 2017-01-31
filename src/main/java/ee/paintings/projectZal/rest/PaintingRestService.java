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

import ee.paintings.projectZal.domain.Painting;
import ee.paintings.projectZal.service.PaintingManager;

@Stateless
@Path("painting")
public class PaintingRestService {
	
	@EJB
	PaintingManager pm;
	
	//add to reproductor
	
	//add to artist
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Painting Service";
	}
	
	//C
	@PUT
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPainting(Painting p){
        try {
            pm.addPainting(p);
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        
		return Response.status(Response.Status.CREATED).build();
	}
		
		
	//R
	@GET
	@Path("/find/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Painting> getAllPaintings() {
		try {
			return pm.findAllPaintings();				
		} catch (Exception e) {
			// TODO: handle exception
			return new ArrayList<Painting>();
		}
	}
	
	@GET
    @Path("/find/id/{paintingId}")
	@Produces(MediaType.APPLICATION_JSON)
    public Painting getPaintingById(@PathParam("paintingId") Long id) {
		
		Painting p = null;
		
		try {
			p = pm.findPaintingById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (p == null) {return new Painting();}
			else {return p;}
		
	}
	
	@GET
    @Path("/find/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
    public Painting getPaintingByName(@PathParam("name") String name) {
		
		Painting p = null;
		
		try {
			p = pm.findPaintingByName(name);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (p == null) {return new Painting();}
			else {return p;}
		
	}
		
		
		
	//U
	@POST
	@Path("/update")
	public Response updatePainting(Painting p){
		
    	try {
    		pm.updatePainting(p);					
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_MODIFIED).build();
		}
    	
    	return Response.status(Response.Status.ACCEPTED).build();				
    	
	}
		
	//D
	@DELETE
	@Path("/delete/{paintingId}")
	public Response deletePainting(
			@PathParam("paintingId") Long id){
		
		Painting p = null;
		
		try {
			p = pm.findPaintingById(id);
			pm.deletePainting(p);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
        
        return Response.status(Response.Status.ACCEPTED).build();
	}
	
}
