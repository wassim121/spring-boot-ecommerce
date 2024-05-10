package com.fsb.firstSpringBootApp.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventes")
public class Vente {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

		@Column(name = "pro")
		private Long id_pro;

		@Column(name = "nbV")
		static int nbVE=0;
			
			@Column(name = "QTe")
			private int Qte;
			@Column(name = "num_cart")
			private int num_cart;
			@Column(name = "mdp_cart")
			private int mdp_cart;
			
			@Column(name = "date")
			private Date date;
			
			
			public Date getDate() { 
				return date;
			}
			public void setDate(Date date) {
				this.date = date;
			}
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
			public Long getId_pro() {
				return id_pro;
			}
			public void setId_pro(Long id_pro) {
				this.id_pro = id_pro;
			}
			public int getQte() {
				return Qte;
			}
			public void setQte(int qte) {
				Qte = qte;
			}
			public int getNum_cart() {
				return num_cart;
			}
			public void setNum_cart(int num_cart) {
				this.num_cart = num_cart;
			}
			public int getMdp_cart() {
				return mdp_cart;
			}
			public void setMdp_cart(int mdp_cart) {
				this.mdp_cart = mdp_cart;
			}

			public static int getNbV() {
				return nbVE;
			}
			public static void setNbV(int nbV) {
				Vente.nbVE = nbV;
			}
			public static void ajoutNbV( ) {
				Vente.nbVE ++;
			}

}
