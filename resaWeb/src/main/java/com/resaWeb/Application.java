package com.resaWeb;



import com.resaWeb.Repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import pbardu.resaBusiness.logements.Appartement;
import pbardu.resaBusiness.logements.AppartementDao;
import pbardu.resaBusiness.logements.Maison;
import pbardu.resaBusiness.reservations.Reservation;
import pbardu.resaBusiness.reservations.Sejour;
import pbardu.resaBusiness.reservations.SejourFactory;
import pbardu.resaBusiness.utilisateurs.Hote;
import pbardu.resaBusiness.utilisateurs.Voyageur;

import java.util.Date;
import java.util.List;


@SpringBootApplication
@EntityScan("pbardu")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Bean
    public CommandLineRunner demo(HoteRepository repository, VoyageurRepository voyageur, LogementRepository logement, AppartementDao appartements, SejourRepository sejour, ReservationRepository reservation) {
        return (args) -> {

            // save a couple of customers
            repository.save(new Hote("Jack", "Bauer", 23,"admin","admin.admin@gmail.com",12));
            repository.save(new Hote("Chloe", "Brian", 45,"admin","admin.admin@gmail.com", 12));
            repository.save(new Hote("Kim", "Bauer", 55,"admin","admin.admin@gmail.com", 6));
            repository.save(new Hote("David", "Palmer", 67,"admin","admin.admin@gmail.com", 24));
            repository.save(new Hote("Michelle", "Dessler", 18,"admin","admin.admin@gmail.com", 24));

            voyageur.save(new Voyageur("tutu", "Mehdi", 23,"admin", "admin.admin@gmail.com"));
            voyageur.save(new Voyageur("tutu", "Pierre", 27,"admin","admin.admin@gmail.com"));
            voyageur.save(new Voyageur("tutu", "Sam", 17,"admin","admin.admin@gmail.com"));
            voyageur.save(new Voyageur("tutu", "Jeremy", 67,"admin","admin.admin@gmail.com"));
            voyageur.save(new Voyageur("armand", "tata", 90,"admin","admin.admin@gmail.com"));

            Hote hote1 = new Hote ("paul", "maul", 23,"admin","admin.admin@gmail.com",7);
            repository.save(hote1);


            Hote hote2 = new Hote ("andrey", "ali", 31,"admin","admin.admin@gmail.com",56);
            repository.save(hote2);
            Hote hote3 = new Hote ("armand", "tata", 28,"admin","admin.admin@gmail.com",2);
            repository.save(hote3);
            logement.save(new Appartement(hote1, 35, "46 Rue des Canonniers, 59800 Lille", 34, 8,  3, 20));
            logement.save(new Appartement(hote1, 35, "46 Rue des Canonniers, 59800 Lille", 78, 2,  78, 3));
            logement.save(new Maison(hote2, 35, "146 Rue George Sand, 59553 Cuincy", 120, 2,  3000, false));
            logement.save(new Appartement(hote3, 35, "2334 Rue des Canonniers, 59800 Lille", 12, 4,  24, 2));
            logement.save(new Appartement(hote3, 35, "2334 Rue des Canonniers, 59800 Tours", 36, 2,  167, 5));
            logement.save(new Appartement(hote3, 35, "2334 Rue des Canonniers, 59800 Lille", 22, 6,  0, 3));

            List<Appartement> aps = appartements.findAll();
            for(int i = 0; i < aps.size(); i++){
                System.out.println( aps.get(i).getAdresse());
            }

            Appartement appartement1 = new Appartement(hote1, 35, "46 Rue des Canonniers, 59800 Lille", 72, 6,  3, 3);
            logement.save(appartement1);

            Appartement appartement2 = new Appartement(hote1, 35, "118 rue de la marre, 37000 Tours", 72, 6,  3, 3);
            logement.save(appartement2);

            Date dateArrivee = new Date(1555326886393l);


            Sejour sejour1 = SejourFactory.getSejour(dateArrivee, appartement1, 10, 6);

            sejour.save(sejour1);

            logement.save(new Appartement(hote3, 35, "2334 Rue des Canonniers, 59800 Lille", 72, 2,  3, 20));
            Sejour sejour2 = SejourFactory.getSejour(dateArrivee, appartement2, 14, 2);
            sejour.save(sejour2);


            Voyageur voyageur1 = new Voyageur ("Jeremy", "brosse", 23,"admin", "admin.admin@gmail.com");
            voyageur.save(voyageur1);

            reservation.save(new Reservation(sejour2, voyageur1));
            reservation.save(new Reservation(sejour1,voyageur1));

        };
    }
}
