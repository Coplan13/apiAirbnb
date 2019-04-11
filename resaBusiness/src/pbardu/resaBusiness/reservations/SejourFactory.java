package pbardu.resaBusiness.reservations;

import java.util.Date;

import pbardu.resaBusiness.logements.Appartement;
import pbardu.resaBusiness.logements.Logement;

public class SejourFactory {

    public static Sejour getSejour(Date dateArrivee, Logement logement, int nbNuits, int nbVoyageurs) {

        Sejour sejour;

        if (nbNuits <= 5) {
            sejour = new SejourCourt(dateArrivee, logement, nbNuits, nbVoyageurs);
        } else {
            sejour = new SejourLong(dateArrivee, logement, nbNuits, nbVoyageurs);
        }

        return sejour;
    }

}
