package com.fsb.firstSpringBootApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie_pro {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

		@Column(name = "name")
		private String name_categorie;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName_categorie() {
			return name_categorie;
		}

		public void setName_categorie(String name_categorie) {
			this.name_categorie = name_categorie;
		}
		
}
