package com.resaWeb.Service.test;


//import com.resaWeb.Repository.LogementRepository;

import com.resaWeb.Repository.HoteRepository;
import com.resaWeb.Repository.LogementRepository;
import com.resaWeb.Repository.ReservationRepository;
import com.resaWeb.Repository.SejourRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import pbardu.resaBusiness.logements.Logement;
import pbardu.resaBusiness.reservations.Reservation;
import pbardu.resaBusiness.reservations.Sejour;
import pbardu.resaBusiness.utilisateurs.Hote;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)

@AutoConfigureDataJpa
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureTestEntityManager

//@EnableJpaRepositories("com.resaWeb.Repository.LogementRepository")
@EnableJpaRepositories("com.resaWeb.Repository")
@EntityScan({"pbardu.resaBusiness"})

@SpringBootTest
@Transactional
//@Rollback
//@ActiveProfiles("test")
//@Configuration
public class LogementService {

    @Autowired
    private LogementRepository logementRepository;

    @Autowired
    private SejourRepository sejourRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HoteRepository hoteRepository;

    @Test
    public void testGetLogement() {

        List<Logement> res;
        res = logementRepository.findByVoyageurMax(4);
        assertEquals(5, res.size());

    }

    @Test
    public void testGetHoteLogement() {
        Logement logement = logementRepository.getOne((long) 2);
        String nom = logement.getHote().getNom();
        String prenom = logement.getHote().getPrenom();
        assertEquals("paul", nom);
        assertEquals("maul", prenom);

    }

    @Test
    public void testGetLogementsHote() {

        List<Logement> resultat;
        resultat = logementRepository.findLogementsHote(8);
        assertEquals(4, resultat.size());

        for (int i = 0; i < resultat.size(); i++) {
            System.out.println("Logement " + i + " = " + resultat.get(i).getAdresse()+" Nombre de voyageur autorisé est : "+ resultat.get(i).getNbVoyageursMax());

        }
    }

    @Test
    public void testGetSejoursLogement(){
        List<Sejour> resu;
        resu = sejourRepository.findSejoursLogement(7);
        assertEquals(2,resu.size());

        for (int i = 0; i < resu.size(); i++) {
            System.out.println("Séjour " + i + " =  le sejour à été réservé par " + resu.get(i).getLogement().getHote().getPrenom());

        }
    }

    @Test
    public void testGetReservation(){
        Reservation reservation = reservationRepository.getOne( 1);
        String nom = reservation.getVoyageur().getPrenom();
        String prenom = reservation.getVoyageur().getNom();
        String nomhote = reservation.getSejour().getLogement().getHote().getNom();
        String prenomhote = reservation.getSejour().getLogement().getHote().getPrenom();
        assertEquals("brosse", nom);
        assertEquals("Jeremy", prenom);
        assertEquals("paul",nomhote);
        assertEquals("maul",prenomhote);


        System.out.println("Monsieur "+nom+" "+prenom + " à fait une réservation chez "+nomhote+" "+prenomhote);

    }

    @Test
    public void testGetReservationsVoyageur(){
        List<Reservation> resa;
        resa = reservationRepository.findReservationsVoyageur(6);
        assertEquals(2,resa.size());

        for (int i = 0; i < resa.size(); i++) {
            System.out.println("Le voyageurs au nom de "+resa.get(i).getVoyageur().getNom()+" à fait une réservation pour la maison situé "+resa.get(i).getSejour().getLogement().getAdresse());

        }

    }

    @Test
    public void testCountHotesLogement(){// compter les hôtes de moins de 31 ans qui possèdent un logement de plus de 29 m2

        Integer countHotes = hoteRepository.findHotesLogement(30,30);
        assertEquals(6, countHotes.intValue());
        System.out.println(countHotes);

    }

}
