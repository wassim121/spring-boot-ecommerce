package com.fsb.firstSpringBootApp.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

		@Column(name = "name")
		private String name;

		@Column(name = "prenom")
		private String prenom;
		@Column(name = "mdp")
		private String mdp;
		@Column(name = "Confirm_mdp")
		private String Confirm_mdp;
		@Column(name = "agree",nullable = false)
		private boolean agree;
		@Column(name = "role")
		private List<String> roles;
		@Column(name = "image")
		private String image;
		
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public boolean isAgree() {
			return agree;
		}
		public void setAgree(boolean agree) {
			this.agree = agree;
		}
		public String getConfirm_mdp() {
			return Confirm_mdp;
		}
		public void setConfirm_mdp(String confirm_mdp) {
			Confirm_mdp = confirm_mdp;
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
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
		public String getMdp() {
			return mdp;
		}
		public void setMdp(String mdp) {
			this.mdp = mdp;
		}
		public List<String> getRoles() {
			return roles;
		}
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
	
		
	
}
