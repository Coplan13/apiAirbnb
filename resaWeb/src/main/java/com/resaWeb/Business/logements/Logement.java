package com.resaWeb.Business.logements;


import com.resaWeb.Business.utilisateurs.Hote;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "logement")
public abstract class Logement {


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "hote_id")
	private Hote hote;

	@Column(name="tarif", nullable=false)
	private  int tarifParNuit;

	@Column(name="adresse", nullable=false)
	private  String adresse;

	@Column(name="superficie", length=40)
	private  int superficie;

	@Column(name="nb_voyageur_max", length=40)
	private  int nbVoyageursMax;


	private  int index;

	private static int cpt = 0;

	protected Logement() {
	}

	public int getIndex() {
		return index;
	}

	public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
		this.index = ++cpt;
		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageursMax = nbVoyageursMax;
	}

	public void afficher() {

		System.out.print("l'hôte : ");
		hote.afficher();
		System.out.println(".");
	}

	public int getTarifParNuit() {
		return tarifParNuit;
	}

	public Hote getHote() {
		return hote;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int getNbVoyageursMax() {
		return nbVoyageursMax;
	}
}
