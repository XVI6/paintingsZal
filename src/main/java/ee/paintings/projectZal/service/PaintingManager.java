package ee.paintings.projectZal.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.paintings.projectZal.domain.Artist;
import ee.paintings.projectZal.domain.Painting;
import ee.paintings.projectZal.domain.Reproductor;

@Stateless
public class PaintingManager {
	
	@PersistenceContext
	EntityManager em;
	
	//C
	public void addPainting(Painting p){
		p.setId(null);
		
		em.persist(p);
	}

	public void addPainting(Long reproductorId, Painting p){
		p.setId(null);
		Reproductor r = em.find(Reproductor.class, reproductorId);
		
		r.getPaintings().add(p);
	}
	
	//R
	public Painting findPaintingById(Long id){
		return em.find(Painting.class, id);
	}
	
	public Painting findPaintingByName(String name){
		return em.find(Painting.class, name);
	}
	
	@SuppressWarnings("unchecked")
	public List<Painting> getAllPainting(){
		return em.createNamedQuery("paintings.select.all").getResultList();
	}
	
	//U
	public void updatePainting(Painting p){
		em.merge(p);
	}
	
	//D
	public void deletePainting(Painting p){
		em.remove(p);
	}
	
	//Others
	public Reproductor getOwnerPainting(Long pId) {
		return em.find(Painting.class, pId).getReproductor();
	}
	
	public Artist getOriginArtistPainting(Long pId) {
		return em.find(Painting.class, pId).getOrigin_artist();
	}
}
