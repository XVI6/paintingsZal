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
	
	//relation with paintings
	public void addToPaintings(Long pId, Long rId){
		
		Painting p = em.find(Painting.class, pId);
		Reproductor r = em.find(Reproductor.class, rId);
		
		if (p == null || r == null) {
			return;
		}
		
		p.addToReproductors(r);
		
		em.merge(p);
	}
	
	//relation with artists
	
	
	//C
	public void addReproductor(Reproductor r) {
		r.setId(null);
		em.persist(r);
	}
	
	//R
	public Reproductor findReproductorById(Long id){
		return em.find(Reproductor.class, id);
	}
	
	public Reproductor findReproductorByName(String name){
		return (Reproductor) em.createNamedQuery("reproductors.select.byName")
				.setParameter("name", name).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Reproductor> getAllReproductors() {
		return em.createNamedQuery("reproductors.select.all").getResultList();
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
