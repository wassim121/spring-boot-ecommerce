package com.fsb.firstSpringBootApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clames")
public class Clame {

	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

		@Column(name = "id_user")
		private Long id_user;
		@Column(name = "etat")
		private String etat;
		
		@Column(name = "object")
		private String object;
		@Column(name = "msg")
		private String msg;
		
		
		
		
		public long getId() {
			return id;
		}public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Long getId_user() {
			return id_user;
		}
		public void setId_user(Long id_user) {
			this.id_user = id_user;
		}
		public String getObject() {
			return object;
		}
		public void setObject(String object) {
			this.object = object;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
}
