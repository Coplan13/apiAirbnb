package com.resaWeb.Business.reservations;

import com.resaWeb.Business.logements.Logement;

import java.util.Date;



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
