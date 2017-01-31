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
	@NamedQuery(name = "artists.select.byName",
			query = "SELECT a FROM Artist a WHERE a.nickName = :nickName")
	})
public class Artist {
	
	private Long id;
	
	private String nickName;
	private String fName;
	private String lName;
	private String country;
	private String city;
	private Long telephone;
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
	
	@Column(nullable = false, unique = true)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	@OneToMany(mappedBy = "origin_artist", fetch = FetchType.EAGER)
	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
	}
	
	//relation paintings
	public void addPainting(Painting p){
		paintings.add(p);
	}

	@ManyToMany(mappedBy = "group", fetch = FetchType.EAGER)
	public List<Reproductor> getMyGroup() {
		return myGroup;
	}
	
	public void setMyGroup(List<Reproductor> myGroup) {
		this.myGroup = myGroup;
	}
	
	//relation reproductors
	public void addReproductor(Reproductor r) {
		myGroup.add(r);
		//r.addToArtists(this);
	}
}
