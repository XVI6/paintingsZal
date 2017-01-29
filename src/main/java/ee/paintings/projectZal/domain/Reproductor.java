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
			query = "SELECT r FROM Reproductor r WHERE r.name = :name"),
	@NamedQuery(name = "reproductors.select.byId", 
			query = "SELECT r FROM Reproductor r WHERE r.id = :id")
})
public class Reproductor {
	private Long id;
	
	private String name;
	private String country;
	private String city;
	private String adress;
	private String house_number;
	private String telephone;
	private String e_mail;
	
	private List<Painting> paintings = new ArrayList<>();
	
	private List<Artist> group = new ArrayList<>();
	
	public Reproductor() {
		// TODO Auto-generated constructor stub
	}
	
	public Reproductor(String name, String country, String city, 
			String adress, String house_number,String telephone, String e_mail){
		this.name = name;
		this.country = country;
		this.city = city;
		this.adress = adress;
		this.house_number = house_number;
		this.telephone = telephone;
		this.e_mail = e_mail;
	}
	
	public Reproductor(Long id, String name, String country, String city, 
			String adress, String house_number,String telephone, String e_mail){
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.city = city;
		this.adress = adress;
		this.house_number = house_number;
		this.telephone = telephone;
		this.e_mail = e_mail;
	}
	
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
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
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	public List<Artist> getGroup() {
		return group;
	}

	public void setGroup(List<Artist> group) {
		this.group = group;
	}
}
