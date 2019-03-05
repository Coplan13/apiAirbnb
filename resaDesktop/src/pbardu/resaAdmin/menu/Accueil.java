package pbardu.resaAdmin.menu;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pbardu.resaAdmin.pages.OpenPopUp;

public class Accueil {

    private static JPanel panel;
    private static JFrame fenetre;


	/**
     * @wbp.parser.entryPoint
     */
    public void Accueil() {

        fenetre = new JFrame();
        fenetre.setSize(1440, 900);
        panel = new JPanel();
        Font policeTitle = new Font("Arial", Font.BOLD, 70);
        Font policeSousTitle = new Font("Arial", Font.BOLD, 40);
        Font policeBoutton = new Font("Arial", Font.BOLD, 25);
        
        fenetre.setTitle("Hello");
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.getContentPane().add(panel);

        fenetre.setVisible(true);

        URL imgUrl = Accueil.class.getResource("/image/adrien-olichon-777314-unsplash.jpg");
        ImageIcon icone = new ImageIcon(imgUrl);
        JLabel jlabel = new JLabel(icone);
        fenetre.getContentPane().add(jlabel);




        panel.setOpaque(false);
        JLabel labelSousTitle = new JLabel("Votre page d'aministration");
        panel.add(labelSousTitle);
        labelSousTitle.setFont(policeSousTitle);
        labelSousTitle.setBorder(BorderFactory.createEmptyBorder(30,450,0,0));
        labelSousTitle.setPreferredSize(new Dimension(1400, 100));
        Color c = Color.decode("#283747");
        labelSousTitle.setForeground(Color.getColor("vert",c) );
        JLabel labelTitle = new JLabel("Bienvenue sur AirBnB");
        panel.add(labelTitle);
        labelTitle.setFont(policeTitle);
        labelTitle.setBorder(BorderFactory.createEmptyBorder(0,350,0,0));
        labelTitle.setPreferredSize(new Dimension(1400, 200));
        Color d = Color.decode("#117A65");
        labelTitle.setForeground(Color.getColor("vert",d) );




        JButton hotes = new JButton("Hôtes");
        hotes.setFocusPainted(false);
        hotes.setForeground(Color.GRAY);
        hotes.setFont(policeBoutton);
        hotes.setPreferredSize(new Dimension(200,50));
        JButton logements = new JButton("Logements");
        logements.setFocusPainted(false);
        logements.setForeground(Color.GRAY);
        logements.setFont(policeBoutton);
        logements.setPreferredSize(new Dimension(200,50));
        JButton voyageurs = new JButton("Voyageurs");
        voyageurs.setFocusPainted(false);
        voyageurs.setForeground(Color.GRAY);
        voyageurs.setFont(policeBoutton);
        voyageurs.setPreferredSize(new Dimension(200,50));
        JButton reservations = new JButton("Réservations");
        reservations.setFocusPainted(false);
        reservations.setForeground(Color.GRAY);
        reservations.setFont(policeBoutton);
        reservations.setPreferredSize(new Dimension(200,50));


        panel.add(hotes);
        panel.add(logements);
        panel.add(voyageurs);
        panel.add(reservations);



        hotes.addMouseListener(
            new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    if(e != null){
                        OpenPopUp hote = new OpenPopUp();
                        hote.OpenPopUp("hote");

                        fenetre.validate();
                    }
                }
            }
        );

        logements.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if(e != null) {
                            OpenPopUp hote = new OpenPopUp();
                            hote.OpenPopUp("logement");
                            fenetre.validate();
                        }
                    }
                }
        );
        voyageurs.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if(e != null) {
                            OpenPopUp hote = new OpenPopUp();
                            hote.OpenPopUp("voyageur");
                            fenetre.validate();
                        }

                    }
                }
        );
        reservations.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if(e != null) {
                            OpenPopUp hote = new OpenPopUp();
                            hote.OpenPopUp("reservation");
                            fenetre.validate();
                        }

                    }
                }
        );

        fenetre.validate();


    }
}
