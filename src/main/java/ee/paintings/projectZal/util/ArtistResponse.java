package ee.paintings.projectZal.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ee.paintings.projectZal.domain.Artist;

@XmlRootElement
public class ArtistResponse {
	
	private List<Artist> artist;

	public List<Artist> getArtist() {
		return artist;
	}

	public void setArtist(List<Artist> artist) {
		this.artist = artist;
	}
}
