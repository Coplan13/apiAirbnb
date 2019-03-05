package pbardu.resaBusiness.logements;

import pbardu.resaBusiness.utilisateurs.Hote;

public final class Appartement extends Logement{

	private final int superficieBalcon;
	private final int numeroEtage;

	public int getNumeroEtage() {
		return numeroEtage;
	}

	public Appartement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax,
					   int superficieBalcon, int numeroEtage) {
		super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
		this.superficieBalcon = superficieBalcon;
		this.numeroEtage = numeroEtage;
	}


	@Override
	public void afficher() {
		System.out.println("Le​ ​logement​ est un appartement situé​ " + getAdresse() + " pour " + getNbVoyageursMax() + " utilisateurs max.");
		System.out.println("Superficie : " + getSuperficie() + "m2");

		switch (numeroEtage) {
		case 0:
			System.out.println("Situé au rez-de-chaussée");
			break;
		case 1:
			System.out.println("Situé au premier étage");
			break;
		case 2:
			System.out.println("Situé au deuxième étage");
			break;

		default:
			System.out.println("Situé au " + numeroEtage + "ème étage");
			break;
		}

	}

	public int getSuperficieBalcon() {
		return superficieBalcon;
	}
}
