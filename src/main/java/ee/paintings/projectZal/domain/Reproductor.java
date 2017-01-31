package ee.paintings.projectZal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "reproductors.select.all", 
			query = "SELECT r FROM Reproductor r"),
	@NamedQuery(name = "reproductors.select.byName", 
			query = "SELECT r FROM Reproductor r WHERE r.name = :name")
})
public class Reproductor {
	private Long id;
	
	private String name;
	private String country;
	private String city;
	private String adress;
	private String house_number;
	private Long telephone;
	private String e_mail;
	
	private List<Painting> paintings = new ArrayList<>();
	
	private List<Artist> group = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	@OneToMany(mappedBy = "reproductor", fetch = FetchType.EAGER)
	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
	}
	
	//relation paintings
	public void addPainting(Painting p) {
		paintings.add(p);
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	public List<Artist> getGroup() {
		return group;
	}

	public void setGroup(List<Artist> group) {
		this.group = group;
	}
	
	//relation artists
	public void addToArtists(Artist a) {
		a.addReproductor(this);
		group.add(a);
//		Artist a1 = group.
	}
}
