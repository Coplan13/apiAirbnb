package com.resaWeb.Business.utilisateurs;

import javax.persistence.*;

@Entity
@Table(name = "voyageur")
public final class Voyageur extends Personne {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	protected Voyageur() {}

	public Voyageur(String pNom, String pPrenom, int pAge, String mdp, String email) {
		super(pNom, pPrenom, pAge, mdp, email);
	}

}
