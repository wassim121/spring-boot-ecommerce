package com.fsb.firstSpringBootApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pros")
public class Produit {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	  @Column(name = "ccategorie")
		private Long categorie_id;

	  
	  @Column(name = "type")
		private Long type_id;
	  
	  @Column(name = "img")
		private String img;

	  @Column(name = "nom")
		private String nom_pro;

	  @Column(name = "num_pro")
		private String numpro;
	  
	  @Column(name = "Qte")
		private int Qte;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getCategorie_id() {
		return categorie_id;
	}

	public void setCategorie_id(Long categorie_id) {
		this.categorie_id = categorie_id;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public String getNom_pro() {
		return nom_pro;
	}

	public void setNom_pro(String nom_pro) {
		this.nom_pro = nom_pro;
	}

	public String getNum_pro() {
		return numpro;
	}

	public void setNum_pro(String num_pro) {
		this.numpro = num_pro;
	}

	public int getQte() {
		return Qte;
	}

	public void setQte(int qte) {
		Qte = qte;
	}

	public void supQte(int qte) {
		Qte =Qte- qte;
	}
	  
}
