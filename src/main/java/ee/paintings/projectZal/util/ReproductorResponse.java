package ee.paintings.projectZal.util;

import javax.xml.bind.annotation.XmlRootElement;

import ee.paintings.projectZal.domain.Reproductor;

@XmlRootElement
public class ReproductorResponse {
	
	private Reproductor reproductor;

	public Reproductor getReproductor() {
		return reproductor;
	}

	public void setReproductor(Reproductor reproductor) {
		this.reproductor = reproductor;
	}
}
