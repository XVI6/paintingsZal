package ee.paintings.projectZal.rest;

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

import ee.paintings.projectZal.domain.Reproductor;
import ee.paintings.projectZal.service.ReproductorManager;


@Stateless
@Path("reproductor")
public class ReproductorRestService {
	
	@EJB
	ReproductorManager rm;
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST Reproductor Service";
	}
	
	//add to painting
	@PUT
	@Path("paintings/{rId}/{pId}")
	public Response addToPaintings(
			@PathParam(value = "pId") Long pId,
			@PathParam(value = "rId") Long rId){
		
		try {
			rm.addToPaintings(pId, rId);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.CONFLICT).build();
		}
		
		return Response.status(Response.Status.CREATED).build();
	}
	
	//add to artist
	
	//C
	@PUT
	@Path("/add")
	public Response addReproductor(Reproductor r){		
            try {
                rm.addReproductor(r);
            } catch (Exception e) {
                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
            }
		
		return Response.status(Response.Status.CREATED).build();
	}
		
		
	//R
	@GET
	@Path("/find/all")
	public Response getAllReproductors() {
		
		List<Reproductor> reproductors = null;
		
		try {
			reproductors = rm.getAllReproductors();
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		
		if (reproductors.isEmpty()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(reproductors, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/find/id/{reproductorId}")
    public Response getReproductorById(@PathParam("reproductorId") Long id) {
		
		Reproductor r = null;
		
		try {
			 r = rm.findReproductorById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
    	return Response.ok(r, MediaType.APPLICATION_JSON).build();        
	}
		

	@GET
	@Path("/find/name/{name}")
    public Response getReproductorByName(@PathParam("name") String name) {
		
		Reproductor r = null;
		
		try {
			 r = rm.findReproductorByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
    	return Response.ok(r, MediaType.APPLICATION_JSON).build();        
	}
	
		
	//U
	@POST
	@Path("/update")
    public Response updateReproductor(Reproductor r) {

    	try {
    		rm.updateReproductor(r);					
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_MODIFIED).build();
		}
    	
    	return Response.status(Response.Status.ACCEPTED).build();				
	}
		
	//D
	@DELETE
	@Path("/delete/{reproductorId}")
    public Response deleteReproductor(@PathParam("reproductorId") Long id) {
		
		Reproductor r = null;
		
		try {
			r = rm.findReproductorById(id);
			rm.deleteReproductor(r);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}

        return Response.status(Response.Status.ACCEPTED).build();
	} 
		
//		@GET
//		@Path("/{reproductorId}/paintings")
//		//@Produces(MediaType.APPLICATION_JSON)
//	        public Response getAllPaintings(
//	        		@PathParam("reproductorId") Long id) {
//			Reproductor r;
//			try {
//				r = rm.getReproductor(id);			
//			} catch (Exception e) {
//				// TODO: handle exception
//				return Response.status(Response.Status.BAD_REQUEST).build();
//			}
//	        
//			List<Painting> paintings = rm.getOwnedPaintings(r);
//			
//			if (paintings.isEmpty()) {
//				return Response.status(Response.Status.NOT_FOUND).build();
//			}
//			else {
//				return Response.ok(paintings, MediaType.APPLICATION_JSON).build();
//			}
//			
//		}	
}
