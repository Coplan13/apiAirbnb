package pbardu.resaBusiness.reservations;

import java.util.Date;

import pbardu.resaBusiness.logements.Logement;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

	private int tarif;

	public SejourCourt(Date dateArrivee, Logement logement, int nbNuits, int nbVoyageurs) {
		super(dateArrivee, logement, nbNuits, nbVoyageurs);
		miseAJourTarif();
	}

	@Override
	public void afficher() {
		afficherSejour();
		
		System.out.println("Le prix de ce séjour est de " + tarif + "€");
	}

	@Override
	public boolean beneficiePromotion() {
		return false;
	}

	@Override
	public int getTarif() {
		return tarif;
	}

	@Override
	public void miseAJourTarif() {
		this.tarif = getNbNuits() * getLogement().getTarifParNuit();	
	}

	@Override
	public boolean verficationNombreDeNuits() {
		
		return getNbNuits() >= 1 && getNbNuits() <= 5;
	}
}
