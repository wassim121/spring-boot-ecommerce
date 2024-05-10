package com.fsb.firstSpringBootApp.models;

 import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profils")
public class Profil {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	 
	  
	  @Column(name = "id_user")
		private Long iduser;
	  @Column(name = "username")
		private String username;
	  @Column(name = "name")
		private String name;
	  @Column(name = "prenom")
		private String prenom;
	  @Column(name = "mail")
		private String mail;
	  @Column(name = "adr")
		private String adr; 
	  @Column(name = "city")
		private String city;
	  @Column(name = "country")
	   private String country;
	  @Column(name = "codepostal")
    	private int codepostal;
		  
	  @Column(name = "aboutme")
    	private String aboutme;
	  @Column(name = "poste")
  	private String poste;

	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	public Long getIduser() {
			return iduser;
		}


		public void setIduser(Long iduser) {
			this.iduser = iduser;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public String getMail() {
			return mail;
		}


		public void setMail(String mail) {
			this.mail = mail;
		}


		public String getAdr() {
			return adr;
		}


		public void setAdr(String adr) {
			this.adr = adr;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public int getCodepostal() {
			return codepostal;
		}


		public void setCodepostal(int codepostal) {
			this.codepostal = codepostal;
		}


		public String getAboutme() {
			return aboutme;
		}


		public void setAboutme(String aboutme) {
			this.aboutme = aboutme;
		}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Long getId_user() {
		return iduser;
	}


	public void setId_user(Long id_user) {
		this.iduser = id_user;
	}
	  
 
}
