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
	
	//relation with reproductors
	public void addToReproductors(Long rId, Long aId) {
		
		Reproductor r = em.find(Reproductor.class, rId);
		Artist a = em.find(Artist.class, aId);
		
		if (a == null || r == null) {
			return;
		}
		
		r.addToArtists(a);
		
		em.merge(r);
	}
	
	//relation with paintings
	public void addToPaintings(Long pId, Long aId){
		
		Painting p = em.find(Painting.class, pId);
		Artist a = em.find(Artist.class, aId);
		
		if (a == null || p == null) {
			return;
		}
		
		p.addToArtists(a);
		
		em.merge(p);
	}
	
	
	//C
	public void addArtist(Artist artist) {
		artist.setId(null);
		em.persist(artist);
	}
	
	//R
	public Artist findArtistById(Long id) {
		return em.find(Artist.class, id);
	}
	
	public Artist findArtistByNickName(String nickName) {
		return (Artist) em.createNamedQuery("artists.select.byName")
				.setParameter("nickName", nickName).getSingleResult();
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
	public void deleteArtist(Long id) {
		em.remove(
				em.find(Artist.class, id));
	}
	
	//Others
	public List<Reproductor> getOwnGroup(Artist artist) {
		return em.find(Artist.class, artist.getId()).getMyGroup();
	}
	
	public List<Painting> getOwnPaintings(Artist artist) {
		return em.find(Artist.class, artist.getId()).getPaintings();
	}
}
