package ee.paintings.projectZal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "paintings.select.all", 
			query = "SELECT p FROM Painting p"),
	@NamedQuery(name = "paintings.select.byName",
			query = "SELECT p FROM Painting p WHERE p.name = :name"),
	@NamedQuery(name = "paintings.select.byId",
			query = "SELECT p FROM Painting p WHERE p.id = :id")
})
public class Painting {
	
	private Long id;
	
	private String name;
	private int yoc;
	private int cost;
	
	private Reproductor reproductor;
	
	private Artist origin_artist;
	
	public Painting() {
		// TODO Auto-generated constructor stub
	}
	
	public Painting(String name, int yoc, int cost) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.yoc = yoc;
		this.cost = cost;
	}
	
	public Painting(Long id, String name, int yoc, int cost) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.yoc = yoc;
		this.cost = cost;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2)
	@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYoc() {
		return yoc;
	}

	public void setYoc(int yoc) {
		this.yoc = yoc;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Reproductor getReproductor() {
		return reproductor;
	}

	public void setReproductor(Reproductor reproductor) {
		this.reproductor = reproductor;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public Artist getOrigin_artist() {
		return origin_artist;
	}

	public void setOrigin_artist(Artist origin_artist) {
		this.origin_artist = origin_artist;
	}
}
