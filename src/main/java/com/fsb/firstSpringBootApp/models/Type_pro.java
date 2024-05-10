package com.fsb.firstSpringBootApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class Type_pro {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	 
	    @Column(name = "categories")
		private Long id_categorie;
		@Column(name = "name")
		private String name_type;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Long getId_categorie() {
			return id_categorie;
		}
		public void setId_categorie(Long id_categorie) {
			this.id_categorie = id_categorie;
		}
		public String getName_type() {
			return name_type;
		}
		public void setName_type(String name_type) {
			this.name_type = name_type;
		}
		
		
}
