package ee.paintings.projectZal.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import ee.paintings.projectZal.domain.Painting;

@XmlRootElement
public class PaintingResponse {
	
	private List<Painting> painting;

	public List<Painting> getPainting() {
		return painting;
	}

	public void setPainting(List<Painting> painting) {
		this.painting = painting;
	}
}
