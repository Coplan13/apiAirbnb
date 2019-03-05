package pbardu.resaBusiness.reservations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pbardu.resaBusiness.logements.Logement;

public abstract class Sejour implements SejourInterface, Cloneable {

	private Logement logement;
	private Date dateArrivee;
	private int nbNuits;
	private int nbVoyageurs;

	public Sejour(Date dateArrivee, Logement logement, int nbNuits, int nbVoyageurs) {

		this.logement = logement;
		this.dateArrivee = dateArrivee;
		this.nbNuits = nbNuits;
		this.nbVoyageurs = nbVoyageurs;
	}

	public abstract void afficher();
	
	public abstract void miseAJourTarif();

	public void afficherSejour() {
		logement.afficher();
		System.out.println("La​ ​date​ ​d'arrivée​ ​est​ ​le​ ​" + dateArrivee + " ​pour​ ​" + nbNuits + "​ ​nuits.");
	}

	public Logement getLogement() {
		return logement;
	}

	public Date getDateArrivee() {
		//SimpleDateFormat dateArrivee2 = new SimpleDateFormat("dd/MM/yyyy",new Locale("fr"));

		//String dateArrivee3 = dateArrivee2.format(dateArrivee);
		return dateArrivee;
	}

	public int getNbNuits() {
		return nbNuits;
	}

	public int getNbVoyageurs() {
		return nbVoyageurs;
	}

	@Override
	public boolean verficationDateArrivee() {
		Date dateCourante = new Date();
		return dateArrivee.after(dateCourante);
	}

	@Override
	public boolean verficationNombreDeVoyageurs() {
		return nbVoyageurs > 0 && nbVoyageurs <= logement.getNbVoyageursMax();
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
		miseAJourTarif();
	}

	public void setDateArrivee(Date dateArrivee) {

		this.dateArrivee = (Date) dateArrivee.clone();
	}

	public void setNbNuits(int nbNuits) {
		this.nbNuits = nbNuits;
		miseAJourTarif();
	}

	public void setNbVoyageurs(int nbVoyageurs) {
		this.nbVoyageurs = nbVoyageurs;
	}

	@Override
	public Object clone()  {

		Sejour sejour = null;
		try {
			sejour = (Sejour) super.clone();
			sejour.dateArrivee = (Date) dateArrivee.clone();
		} catch (CloneNotSupportedException e) {
		}

		return sejour;
	}
}
