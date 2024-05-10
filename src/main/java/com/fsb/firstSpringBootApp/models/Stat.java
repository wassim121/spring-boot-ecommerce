package com.fsb.firstSpringBootApp.models;

 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stats")
public class Stat {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	 
	 private static int  vente_echoue=0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static int getVente_echoue() {
		return vente_echoue;
	}

	public static void setVente_echoue() {
		Stat.vente_echoue ++;
	}
	 
 
}
