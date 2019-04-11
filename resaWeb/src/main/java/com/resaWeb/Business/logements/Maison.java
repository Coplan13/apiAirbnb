package com.resaWeb.Business.logements;

import com.resaWeb.Business.utilisateurs.Hote;

import javax.persistence.*;


@Entity
@Table(name = "maison")
public final class Maison extends Logement {

	@Column(name= "superficie_Jardin")
	private int superficieJardin;

	@Column(name= "possede_piscine")
	private boolean possedePiscine;


	public Maison(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieJardin, boolean possedePiscine) {
		super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);

		this.superficieJardin = superficieJardin;
		this.possedePiscine = possedePiscine;
	}

	protected Maison() {
	}

	@Override
	public void afficher() {

		super.afficher();
		System.out.println("Le logement est une maison située " + getAdresse() + " pour " + getNbVoyageursMax() + " utilisateurs max.");
		System.out.println("Superficie : " + getSuperficie() + "m2");

		if (superficieJardin > 0) {
			System.out.println("Jardin : " + superficieJardin + "m2");
		} else {
			System.out.println("Jardin : non");
		}

		// System.out.println("Piscine : " + ((possedePiscine)? "oui" : "non"));

		if (possedePiscine) {
			System.out.println("Piscine : oui");
		} else {
			System.out.println("Piscine : non");
		}
	}

	public int getSuperficieJardin() {
		return superficieJardin;
	}

	public boolean getPossedePiscine() {
		return possedePiscine;
	}
}
