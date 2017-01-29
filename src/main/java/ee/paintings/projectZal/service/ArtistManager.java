package ee.paintings.projectZal.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ee.paintings.projectZal.domain.Artist;
import ee.paintings.projectZal.domain.Painting;
import ee.paintings.projectZal.domain.Reproductor;

@Stateless
public class ArtistManager {
	
	@PersistenceContext
	EntityManager em;
	
	
	//C
	public void addArtist(Artist a) {
		a.setId(null);
		em.persist(a);
	}
	
	//R
	public Artist findArtistById(Long id) {
		return em.find(Artist.class, id);
	}
	
	public Artist findArtistByFName(String fName) {
		return em.find(Artist.class, fName);
	}
	
	public Artist findArtistByLName(String lName) {
		return em.find(Artist.class, lName);
	}
	
	@SuppressWarnings("unchecked")
	public List<Artist> getAllArtists() {
		return em.createNamedQuery("artists.select.all").getResultList();
	}
	
	//U
	public void updateArtist(Artist a) {
		em.merge(a);
	}
	
	//D
	public void deleteArtist(Artist a) {
		em.remove(a);
	}
	
	//Others
	public List<Reproductor> getOwnGroup(Artist a) {
		return em.find(Artist.class, a.getId()).getMyGroup();
	}
	
	public List<Painting> getOwnPaintings(Artist a) {
		return em.find(Artist.class, a.getId()).getPaintings();
	}
}
