package pbardu.resaBusiness.reservations;

import java.util.Date;

import pbardu.resaBusiness.logements.Logement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Sejourlong")
public class SejourLong extends Sejour implements ConditionsTarifairesInterface {



	private int PROMOTION_EN_POURCENTAGE = 20;
	private int promotion;

	@Column(name="tarif", nullable=false)
	private int tarif;

	public SejourLong() {
	}

	public SejourLong(Date dateArrivee, Logement logement, int nbNuits, int nbVoyageurs) {
		super(dateArrivee, logement, nbNuits, nbVoyageurs);

		miseAJourTarif();
	}

	@Override
	public void afficher() {
		afficherSejour();
		System.out.println("Le prix de ce séjour est de " + tarif + "€ (" + promotion + "€ de promotion).");
	}

	@Override
	public boolean beneficiePromotion() {
		return true;
	}

	@Override
	public int getTarif() {
		return tarif;
	}

	@Override
	public void miseAJourTarif() {
		int tarifTotal = getNbNuits() * getLogement().getTarifParNuit();
		promotion = tarifTotal * PROMOTION_EN_POURCENTAGE / 100;
		tarif = tarifTotal - promotion;
	}

	@Override
	public boolean verficationNombreDeNuits() {
		
		return getNbNuits() >= 6 && getNbNuits() <= 31;
	}

}
