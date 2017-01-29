package ee.paintings.projectZal.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.paintings.projectZal.domain.Artist;
import ee.paintings.projectZal.domain.Painting;
import ee.paintings.projectZal.domain.Reproductor;


@Stateless
public class ReproductorManager {
	
	@PersistenceContext
	EntityManager em;
	
	//C
	public void addReproductor(Reproductor r) {
		r.setId(null);
		em.persist(r);
	}
	
	//R
	public Reproductor getReproductorById(Long id){
		return em.find(Reproductor.class, id);
	}
	
	public Reproductor getReproductorByName(String name){
		return em.find(Reproductor.class, name);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reproductor> getAllReproductors() {
		return em.createNamedQuery("reproduktor.select.all").getResultList();
	}
	
	//U
	public void updateReproductor(Reproductor r){
		em.merge(r);
	}
	
	//D
	public void deleteReproductor(Reproductor r) {
		em.remove(r);
	}
	
	
	//Others
	public List<Painting> getOwnedPaintings(Long rId) {
		
		return new ArrayList<Painting>
					(em.find(Reproductor.class, rId).getPaintings());
	}
	
	public List<Artist> getOwnedArtists(Long rId) {
		return new ArrayList<Artist>
					(em.find(Reproductor.class, rId).getGroup());
	}
}
