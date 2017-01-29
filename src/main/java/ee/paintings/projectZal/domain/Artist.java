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
	@NamedQuery(name = "artists.select.all", 
			query = "SELECT a FROM Artist a"),
	@NamedQuery(name = "artists.select.byLName", 
			query = "SELECT a FROM Artist a WHERE a.lName = :lName"),
	@NamedQuery(name = "artists.select.byFName", 
			query = "SELECT a FROM Artist a WHERE a.fName = :fName"),
	@NamedQuery(name = "artists.select.byId", 
			query = "SELECT a FROM Artist a WHERE a.id = :id")
})
public class Artist {
	
	private Long id;
	
	private String fName;
	private String lName;
	private String country;
	private String city;
	private String adress;
	private String house_number;
	private String telephone;
	private String e_mail;
	
	private List<Painting> paintings = new ArrayList<>();
	
	private List<Reproductor> myGroup = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false)
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	@Column(nullable = false)
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
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

	@OneToMany(mappedBy = "origin_artist", fetch = FetchType.EAGER)
	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
	}

	@ManyToMany(mappedBy = "group", fetch = FetchType.EAGER)
	public List<Reproductor> getMyGroup() {
		return myGroup;
	}
	
	public void setMyGroup(List<Reproductor> myGroup) {
		this.myGroup = myGroup;
	}
	
}
