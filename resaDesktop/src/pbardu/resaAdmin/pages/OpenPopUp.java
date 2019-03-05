package pbardu.resaAdmin.pages;


import javax.swing.*;

import pbardu.resaAdmin.menu.Accueil;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OpenPopUp {

    private static JPanel panel1;

    public static void OpenPopUp(String source){
        panel1 = new JPanel();
        JTabbedPane jtbExample = new JTabbedPane();



       if(source == "hote"){
           AffichagePages myPage = new AffichagePages();
           myPage.AffichagePagesHotes(jtbExample, panel1);
       }else if(source == "logement"){
           AffichagePages myPage = new AffichagePages();
           myPage.AffichagePagesLogements(jtbExample, panel1);
       }else if(source == "voyageur"){
            AffichagePages myPage = new AffichagePages();
            myPage.AffichagePagesVoyageur(jtbExample, panel1);
        }else if(source == "reservation"){
            AffichagePages myPage = new AffichagePages();
            myPage.AffichagePagesReservation(jtbExample, panel1);
        }



    }

}
