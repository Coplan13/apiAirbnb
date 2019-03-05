package pbardu.resaAdmin.pages;

import pbardu.resaAdmin.menu.Accueil;
import pbardu.resaBusiness.data.AirBnBData;
import pbardu.resaBusiness.data.Search;
import pbardu.resaBusiness.logements.Appartement;
import pbardu.resaBusiness.logements.Logement;
import pbardu.resaBusiness.logements.Maison;
import pbardu.resaBusiness.reservations.Reservation;
import pbardu.resaBusiness.reservations.Sejour;
import pbardu.resaBusiness.reservations.SejourCourt;
import pbardu.resaBusiness.reservations.SejourLong;
import pbardu.resaBusiness.utilisateurs.Hote;
import pbardu.resaBusiness.utilisateurs.Voyageur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class AffichagePages  extends JFrame{


    //////////////ATTRIBUTS HOTE//////////////
    private static JPanel jplInnerPanelAjouterHote;
    private static JPanel jplInnerPanelSupprimerHote;
    private static JPanel jplInnerPanelAfficherHote;
    private JTextField textFieldNomHote;
    private JTextField textFieldPrenomHote;
    private JTextField textFieldAgeHote;
    private JTextField textFieldSupprimerHote;
    private JLabel lblNewLabelTitreAjouterHote;

    //////////////ATTRIBUTS VOYAGEUR//////////////
    private static JPanel jplInnerPanelAjouterVoyageur;
    private static JPanel jplInnerPanelSupprimerVoyageur;
    private static JPanel JplInnerPanelAfficherVoyageur;
    private JTextField textFieldNomVoyageur;
    private JTextField textFieldPrenomVoyageur;
    private JTextField textFieldAgeVoyageur;
    private JTextField textFieldSupprimerVoyageur;
    private JLabel lblNewLabelTitreAjouterVoyageur;

    //////////////ATTRIBUTS LOGEMENT//////////////
    private boolean isMaison;
    private boolean isAppart;
    private AirBnBData myData = AirBnBData.getInstance();
    private JPanel contentPane;
    private JTextField tfTarifNuit;
    private JTextField tfAdresse;
    private JTextField tfSuperficie;
    private JTextField tfNbVoyageur;
    private JTextField tfBalcon;
    private JTextField tfJardin;
    private JLabel tfM2;
    private JTextField tfNumEtage;
    private JCheckBox chckbxNewCheckBoxPiscine;
    private int superficieBalcon = 0;
    private int numEtag = 0;
    private int superficieJardin = 0;
    private boolean piscineOui = false;
    private Hote monHote;
    private Appartement newAppartement;
    private Maison newMaison;
    private JTextField textFieldSupprimerLogement;
    private JLabel lblSuperficieBalconsi;
    private JLabel lblSuperficieJardin;
    private JLabel lblNumrotage;

    //////////////ATTRIBUTS RESERVATION//////////////
    private static JPanel jplInnerPanelRechercheReservation;
    private static JPanel jplInnerPanelAjouterReservation;
    private static JPanel jplInnerPanelSupprimerReservation;
    private static JPanel jplInnerPanelAfficherReservation;
    private static JPanel jplInnerPanelAfficherRecherche;
    private JTextField textFieldNumeroVoyageurReservation;
    private JTextField textFieldDateArriveeReservation;
    private JTextField textFieldNombreDeNuitReservation;
    private JTextField textFieldSupprimerReservation;
    private JTextField textFieldNumeroVoyageur;
    private JTextField textFieldDateArrivee;
    private JTextField textFieldNombreDeNuit;
    private JTextField textFieldNombreDeVoyageurs;
    private boolean piscine = false;
    private boolean balcon = false;
    private boolean jardin = false;
    private static ArrayList reservation;


    //////////////COULEUR//////////////

    private Color couleur_contour_champ = new Color(41, 128, 185  );

    ////////////FIN COULEUR////////////


    public void AffichagePagesHotes(JTabbedPane jtbExample, JPanel panel1){


          //////////////////////////////
         //////////  AJOUTER   ////////
        //////////////////////////////

        jplInnerPanelAjouterHote = new JPanel();
        jplInnerPanelAjouterHote.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelAjouterHote);
        jplInnerPanelAjouterHote.setLayout(null);

        jplInnerPanelSupprimerHote = new JPanel();
        jplInnerPanelSupprimerHote.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelSupprimerHote);
        jplInnerPanelSupprimerHote.setLayout(null);

        jplInnerPanelAfficherHote = new JPanel();
        jplInnerPanelAfficherHote.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelAfficherHote);
        jplInnerPanelAfficherHote.setLayout(new BoxLayout(jplInnerPanelAfficherHote,BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(jplInnerPanelAfficherHote);

        panel1.add(jtbExample);
        JFrame frame = new JFrame("HÔTES");
        Container panel = frame.getContentPane();
        panel.add(jtbExample);
        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);


        //////////  AJOUTER TITRE  ////////

        lblNewLabelTitreAjouterHote = new JLabel("<HTML>Dans cette interface vous pouvez ajouter un hôtes " +
                "<br>en remplissant les champs ci-dessous.</HTML>");
        lblNewLabelTitreAjouterHote.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabelTitreAjouterHote.setBounds(250, 60, 800, 50);
        jplInnerPanelAjouterHote.add(lblNewLabelTitreAjouterHote);

        //////////  AJOUTER LABEL NOM ////////

        JLabel lblNom = new JLabel("Nom");
        lblNom.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNom.setBounds(76, 160, 90, 29);
        jplInnerPanelAjouterHote.add(lblNom);
/*
        jplInnerPanel1 = new JPanel();
        for (int i = 0; i < list.size(); i++) {
            JLabel localLabel = new JLabel(list.get(i));
            localLabel.setBounds(x,y,height,width);
            //test = new JLabel();
            jplInnerPanel1.add(localLabel);
            x+=1;
            y+=1;
            height+=1;
            width+=1;
        }
*/
        //////////  AJOUTER FIELD NOM ////////

        textFieldNomHote = new JTextField();
        textFieldNomHote.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        textFieldNomHote.setBounds(157, 150, 232, 45);
        textFieldNomHote.setColumns(10);
        jplInnerPanelAjouterHote.add(textFieldNomHote);

        //////////  AJOUTER LABEL PRENOM ////////

        JLabel lblPrnom = new JLabel("Prénom");
        lblPrnom.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblPrnom.setBounds(76, 232, 169, 29);
        jplInnerPanelAjouterHote.add(lblPrnom);

        //////////  AJOUTER FIELD PRENOM ////////

        textFieldPrenomHote = new JTextField();
        textFieldPrenomHote.setColumns(10);
        textFieldPrenomHote.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        textFieldPrenomHote.setBounds(157, 227, 232, 45);
        jplInnerPanelAjouterHote.add(textFieldPrenomHote);

        //////////  AJOUTER LABEL AGE ////////

        JLabel lblNewLabel = new JLabel("Age");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel.setBounds(76, 300, 90, 29);
        jplInnerPanelAjouterHote.add(lblNewLabel);

        //////////  AJOUTER FIELD AGE ////////

        textFieldAgeHote = new JTextField();
        textFieldAgeHote.setColumns(10);
        textFieldAgeHote.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        textFieldAgeHote.setBounds(157, 296, 232, 45);
        jplInnerPanelAjouterHote.add(textFieldAgeHote);

        //////////  AJOUTER LABEL DELAI DE REPONSE ////////

        JLabel lblDlaiDeRponse = new JLabel("Délai de réponse");
        lblDlaiDeRponse.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblDlaiDeRponse.setBounds(76, 400, 169, 29);
        jplInnerPanelAjouterHote.add(lblDlaiDeRponse);

        String[] listeDelaiReponse = {"6", "12", "24", "48"};


        //////////  AJOUTER COMBOBOX DELAI DE REPONSE ////////

        JComboBox comboBox = new JComboBox(listeDelaiReponse);
        comboBox.setBounds(250, 400, 139, 39);
        jplInnerPanelAjouterHote.add(comboBox);

        //////////  AJOUTER BOUTTON VALIDER ////////

        JButton btnNewButtonValider = new JButton("Valider");
        btnNewButtonValider.setBounds(105, 500, 130, 50);
        btnNewButtonValider.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnNewButtonValider.setForeground(Color.getColor("bleu",couleur_contour_champ) );
        jplInnerPanelAjouterHote.add(btnNewButtonValider);

        //////////  AJOUTER BOUTTON RESET ////////

        JButton btnNewButtonReset = new JButton("Reset");
        btnNewButtonReset.setBounds(250, 500, 130, 50);
        btnNewButtonReset.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnNewButtonReset.setForeground(Color.getColor("bleu",couleur_contour_champ) );
        jplInnerPanelAjouterHote.add(btnNewButtonReset);

        //////////  AJOUTER IMAGE ////////

        URL imgUrl = Accueil.class.getResource("/image/host.png");
        ImageIcon icone = new ImageIcon(imgUrl);
        JLabel image1 = new JLabel(icone);
        image1.setBounds(400, 100, 500, 500);
        jplInnerPanelAjouterHote.add(image1);

        //////////  AJOUTER TAB AJOUTER ////////

        jtbExample.addTab("Ajouter", null, jplInnerPanelAjouterHote, "Tab 1");

        //////////  EVENEMENTS BOUTTON ////////

        btnNewButtonValider.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int age = Integer.parseInt(textFieldAgeHote.getText());
                String nom = textFieldNomHote.getText();
                String prenom = textFieldPrenomHote.getText();
                int delaiReponse = Integer.valueOf((String) comboBox.getSelectedItem());

                Hote newHote = new Hote(prenom, nom, age, delaiReponse);
                AirBnBData.getInstance().getHotes().add(newHote);
                textFieldAgeHote.setText("");
                textFieldNomHote.setText("");
                textFieldPrenomHote.setText("");
                comboBox.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Votre hôte a bien été ajouté");
                frame.setVisible(true);
                frame.dispose();
            }
        });
        btnNewButtonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldAgeHote.setText("");
                textFieldNomHote.setText("");
                textFieldPrenomHote.setText("");
                comboBox.setSelectedIndex(0);
            }
        });

          //////////////////////////////////
         /////////  FIN AJOUTER   /////////
        //////////////////////////////////

          ////////////////////////////////
         //////////  SUPPRIMER   ////////
        ////////////////////////////////


        //////////  AJOUTER TITRE ////////




        JLabel lblNewLabelsupprimer = new JLabel("Quel hôte voulez-vous supprimer ?");
        lblNewLabelsupprimer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabelsupprimer.setBounds(267, 30, 389, 25);
        jplInnerPanelSupprimerHote.add(lblNewLabelsupprimer);

        //////////  AJOUTER FIELD SUPPRIMER ////////

        textFieldSupprimerHote = new JTextField();
        textFieldSupprimerHote.setBounds(347, 77, 189, 41);
        textFieldSupprimerHote.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelSupprimerHote.add(textFieldSupprimerHote);
        textFieldSupprimerHote.setColumns(10);

        //////////  AJOUTER BOUTTON SUPPRIMER ////////

        JButton btnNewButtonSupprimer = new JButton("Supprimer");
        btnNewButtonSupprimer.setBounds(380, 150, 130, 50);
        btnNewButtonSupprimer.setForeground(Color.getColor("bleu",couleur_contour_champ));
        btnNewButtonSupprimer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        jplInnerPanelSupprimerHote.add(btnNewButtonSupprimer);

        //////////  AJOUTER TAB SUPPRIMER ////////

        jtbExample.addTab("Supprimer", null, jplInnerPanelSupprimerHote);

        //////////  AJOUTER IMAGE ////////

        URL imgUrlsuppr = Accueil.class.getResource("/image/trash.png");
        ImageIcon iconesuppre = new ImageIcon(imgUrlsuppr);
        JLabel imagesuppri = new JLabel(iconesuppre);
        imagesuppri.setBounds(195, 170, 500, 500);
        jplInnerPanelSupprimerHote.add(imagesuppri);

        //////////  AJOUTER IMAGE ////////

        URL imgUrlminiatureHote = Accueil.class.getResource("/image/host-miniature.png");
        ImageIcon iconeminiatureHote = new ImageIcon(imgUrlminiatureHote);
        JLabel imageminiatureHote = new JLabel(iconeminiatureHote);
        imageminiatureHote.setBounds(100, 30, 200, 200);
        jplInnerPanelSupprimerHote.add(imageminiatureHote);

        //////////  EVENEMENTS BOUTTON ////////

        btnNewButtonSupprimer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int numero = Integer.parseInt(textFieldSupprimerHote.getText());
                AirBnBData.getInstance().getHotes().remove(numero-1);
                textFieldSupprimerHote.setText("");
                JOptionPane.showMessageDialog(null, "Votre hôte a bien été supprimé");
                frame.setVisible(true);
                frame.dispose();


            }
        });

          /////////////////////////////////////
         //////////  FIN SUPPRIMER   /////////
        /////////////////////////////////////

        ////////////////////////////////
        //////////  AFFICHER    ////////
        ////////////////////////////////

        jtbExample.addTab("Afficher", null, scrollPane);
        //////////  AJOUTER TITRE ////////

        AirBnBData myData = AirBnBData.getInstance();
        ArrayList<Hote> hote = myData.getHotes();
        for(int i = 0; i < hote.size(); i++) {

            JLabel hote2 = new JLabel("<html>-------------------<br> HOTE N°"+(i+1)+"<br>-------------------"
                    +"<br> Nom : "+hote.get(i).getNom()+"<br> Prenom : "+hote.get(i).getPrenom()+"<br> Age : "
                    +hote.get(i).getAge()+" ans <br> Le delai de réponse est de : "+hote.get(i).getDelaiReponse()
                    +" heures <br><br></HTML>");
            Hote hot = hote.get(i);
            JButton btnSupprimerHote = new JButton("Supprimer cet hôte");
            btnSupprimerHote.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    myData.getHotes().remove(myData.getHotes().indexOf(hot));
                    SwingUtilities.updateComponentTreeUI(frame);
                    jplInnerPanelAfficherHote.remove(hote2);
                    jplInnerPanelAfficherHote.remove(btnSupprimerHote);
                    jplInnerPanelAfficherHote.revalidate();
                    jplInnerPanelAfficherHote.repaint();
                }
            });
            jplInnerPanelAfficherHote.add(hote2);
            jplInnerPanelAfficherHote.add(btnSupprimerHote);

        }
        //////////  AJOUTER AFFICHAGE ////////


        //////////  AJOUTER IMAGE ////////

        URL imgUrlafficherhote = Accueil.class.getResource("/");
        ImageIcon iconeafficherhote = new ImageIcon(imgUrlafficherhote);
        JLabel imageafficherhote = new JLabel(iconeafficherhote);
        imageafficherhote.setBounds(195, 170, 500, 500);
        jplInnerPanelAfficherHote.add(imageafficherhote);


        /////////////////////////////////////
        //////////  FIN  AFFICHER   /////////
        /////////////////////////////////////


    }
    public void AffichagePagesLogements(JTabbedPane jtbExample, JPanel panel1){


            JPanel myPanelLogement1 = new JPanel();
            jtbExample.addTab("Ajouter", null, myPanelLogement1, "Tab 1");
            jtbExample.setSelectedIndex(0);

            JPanel myPanelLogement2 = new JPanel();
            jtbExample.addTab("Supprimer", null, myPanelLogement2);

            JPanel myPanelLogement3 = new JPanel();
            myPanelLogement3.setLayout(new BoxLayout(myPanelLogement3, BoxLayout.PAGE_AXIS));
            JScrollPane scrollPane = new JScrollPane(myPanelLogement3);
            jtbExample.addTab("Liste", null, scrollPane);

            panel1.add(jtbExample);

            JFrame frame = new JFrame("Logements");
            Container panel11 = frame.getContentPane();
            panel11.add(jtbExample);
            frame.setVisible(true);
            frame.setSize(900, 700);
            frame.setLocationRelativeTo(null);
            JPanel roomList = new JPanel();
            roomList.setLayout(null);

            //////////////////////////////AJOUTER UN LOGEMENT//////////////////////////////////////

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myPanelLogement1.setLayout(null);
            myPanelLogement1.setSize(700, 900);

            JButton btnAjoutMaison = new JButton("Ajouter une maison");
            btnAjoutMaison.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }
            });

            btnAjoutMaison.setBounds(257, 6, 167, 36);
            myPanelLogement1.add(btnAjoutMaison);

            JButton btnAjoutAppart = new JButton("Ajouter un Appartement");

            btnAjoutAppart.setBounds(456, 6, 167, 36);
            myPanelLogement1.add(btnAjoutAppart);

            JLabel lblTarifParNuit = new JLabel("Tarif par nuit : ");
            lblTarifParNuit.setBounds(23, 60, 94, 16);
            myPanelLogement1.add(lblTarifParNuit);

            tfTarifNuit = new JTextField();
            tfTarifNuit.setBounds(129, 55, 130, 26);
            myPanelLogement1.add(tfTarifNuit);
            tfTarifNuit.setColumns(10);

            JLabel lblAdresse = new JLabel("Adresse : ");
            lblAdresse.setBounds(23, 113, 94, 16);
            myPanelLogement1.add(lblAdresse);

            tfAdresse = new JTextField();
            tfAdresse.setBounds(129, 108, 572, 26);
            myPanelLogement1.add(tfAdresse);
            tfAdresse.setColumns(10);

            JLabel lblSuperficie = new JLabel("Superficie : ");
            lblSuperficie.setBounds(23, 167, 94, 16);
            myPanelLogement1.add(lblSuperficie);

            tfSuperficie = new JTextField();
            tfSuperficie.setBounds(129, 162, 64, 26);
            myPanelLogement1.add(tfSuperficie);
            tfSuperficie.setColumns(10);

            JLabel lblM = new JLabel("m2");
            lblM.setBounds(198, 167, 61, 16);
            myPanelLogement1.add(lblM);

            JLabel lblNombreDeVoyageurs = new JLabel("Nombre de voyageurs maximum acceptés :");
            lblNombreDeVoyageurs.setBounds(23, 215, 282, 16);
            myPanelLogement1.add(lblNombreDeVoyageurs);

            tfNbVoyageur = new JTextField();
            tfNbVoyageur.setBounds(321, 210, 80, 26);
            myPanelLogement1.add(tfNbVoyageur);
            tfNbVoyageur.setColumns(10);

            /////////////////////////////////////APPARTEMENT OU MAISON////////////////////////////////////////
            btnAjoutAppart.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if(!isAppart) {
                        isAppart = true;

                        if(isMaison) {
                            Container parent = tfJardin.getParent();
                            parent.remove(tfJardin);
                            parent.remove(lblSuperficieJardin);
                            parent.remove(chckbxNewCheckBoxPiscine);
                            parent.validate();
                            parent.repaint();
                        }

                        isMaison = false;

                        btnAjoutMaison.setEnabled(false);
                        btnAjoutAppart.setEnabled(true);
                        lblSuperficieBalconsi = new JLabel("Superficie Balcon :");
                        lblSuperficieBalconsi.setBounds(23, 263, 201, 16);
                        myPanelLogement1.add(lblSuperficieBalconsi);

                        tfBalcon = new JTextField();
                        tfBalcon.setBounds(236, 258, 130, 26);
                        myPanelLogement1.add(tfBalcon);
                        tfBalcon.setColumns(10);

                        tfM2 = new JLabel("m2");
                        tfM2.setBounds(377, 265, 61, 16);
                        myPanelLogement1.add(tfM2);

                        tfNumEtage = new JTextField();
                        tfNumEtage.setBounds(129, 305, 130, 26);
                        myPanelLogement1.add(tfNumEtage);
                        tfNumEtage.setColumns(10);

                        lblNumrotage = new JLabel("Numéro étage :");
                        lblNumrotage.setBounds(23, 310, 114, 16);
                        myPanelLogement1.add(lblNumrotage);


                        SwingUtilities.updateComponentTreeUI(frame);

                    }
                }
            });

            btnAjoutMaison.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if(!isMaison) {
                        isMaison = true;
                        if(isAppart) {
                            Container parent = tfBalcon.getParent();
                            parent.remove(tfBalcon);
                            parent.remove(tfNumEtage);
                            parent.remove(lblSuperficieBalconsi);
                            parent.remove(lblNumrotage);
                            parent.validate();
                            parent.repaint();
                        }
                        isAppart = false;
                        btnAjoutAppart.setEnabled(false);
                        btnAjoutMaison.setEnabled(true);


                        lblSuperficieJardin = new JLabel("Superficie Jardin :");
                        lblSuperficieJardin.setBounds(23, 263, 201, 16);
                        myPanelLogement1.add(lblSuperficieJardin);

                        tfJardin = new JTextField();
                        tfJardin.setBounds(236, 258, 130, 26);
                        myPanelLogement1.add(tfJardin);
                        tfJardin.setColumns(10);

                        chckbxNewCheckBoxPiscine = new JCheckBox("Piscine");
                        chckbxNewCheckBoxPiscine.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
                        chckbxNewCheckBoxPiscine.setBounds(23, 310, 114, 16);
                        myPanelLogement1.add(chckbxNewCheckBoxPiscine);

                        SwingUtilities.updateComponentTreeUI(frame);

                    }
                }
            });

            //----------APPARTEMENT OU MAISON--------//



            //---------COMBO BOX HOTE---------//
            JLabel lblComboBox = new JLabel("Choisir un hote :");
            lblComboBox.setBounds(23, 355, 114, 16);
            myPanelLogement1.add(lblComboBox);


            ArrayList<Hote> listOfHote = myData.getHotes();
            ArrayList<String> nomPrenom = new ArrayList<String>();

            for(int i = 0; i<listOfHote.size(); i++) {
                String choixCombo = "";
                choixCombo = ""+listOfHote.get(i).getPrenom() +" "+listOfHote.get(i).getNom();
                nomPrenom.add(choixCombo);
            }

            String[] arrayOfName = nomPrenom.toArray(new String[0]);
            JComboBox comboBox = new JComboBox(arrayOfName);
            comboBox.setBounds(140, 355, 139, 39);
            myPanelLogement1.add(comboBox);

            //////////AJOUTER BOUTTON VALIDER ////////
            JButton btnNewButtonValider = new JButton("Valider");
            btnNewButtonValider.setBounds(105, 500, 130, 50);
            btnNewButtonValider.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            btnNewButtonValider.setForeground(Color.getColor("bleu",couleur_contour_champ) );
            myPanelLogement1.add(btnNewButtonValider);

            URL imgUrlminiatureVoyageur = Accueil.class.getResource("/image/house.png");
            ImageIcon iconeminiatureVoyageur = new ImageIcon(imgUrlminiatureVoyageur);
            JLabel imageminiatureVoyageur = new JLabel(iconeminiatureVoyageur);
            imageminiatureVoyageur.setBounds(400, 200, 400, 400);
            myPanelLogement1.add(imageminiatureVoyageur);

            btnNewButtonValider.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.out.println("DEBUT DU LISTENER");
                    int tarifParNuit = Integer.parseInt(tfTarifNuit.getText());
                    String adresse = tfAdresse.getText();
                    int superficie = Integer.parseInt(tfSuperficie.getText());
                    int nbVoyMax = Integer.parseInt(tfNbVoyageur.getText());

                    if(!isMaison) {
                        superficieBalcon = Integer.parseInt(tfBalcon.getText());
                        numEtag = Integer.parseInt(tfNumEtage.getText());
                    }else {
                        superficieJardin = Integer.parseInt(tfJardin.getText());
                        piscineOui = chckbxNewCheckBoxPiscine.isSelected();
                    }

                    String hote = String.valueOf((String) comboBox.getSelectedItem());
                    Hote myHoteOfLogement = null;

                    String prenomHote = hote.split(" ")[0];
                    String nomHote = hote.split(" ")[1];

                    for(int i = 0; i < myData.getHotes().size(); i++) {
                        if((prenomHote.equals(myData.getHotes().get(i).getPrenom())) && (nomHote.equals(myData.getHotes().get(i).getNom()))) {
                            myHoteOfLogement = myData.getHotes().get(i);
                            System.out.println("C'est mon hote + " + myData.getHotes().get(i).getPrenom() + " " +myData.getHotes().get(i).getNom());
                        }
                    }
                    if(!isMaison) {
                        newAppartement = new Appartement(myHoteOfLogement, tarifParNuit, adresse, superficie, nbVoyMax, superficieBalcon, numEtag);
                        AirBnBData.getInstance().getLogements().add(newAppartement);
                    }else {
                        newMaison = new Maison(myHoteOfLogement, tarifParNuit, adresse, superficie, nbVoyMax, superficieJardin, piscineOui);
                        AirBnBData.getInstance().getLogements().add(newMaison);

                    }
                    JOptionPane.showMessageDialog(null, "Votre logement a bien été ajouté");

                    frame.setVisible(true);
                    frame.dispose();

                }
            });

            //--------AJOUTER BOUTTON RESET ----------//

            JButton btnNewButtonReset = new JButton("Reset");
            btnNewButtonReset.setBounds(250, 500, 130, 50);
            btnNewButtonReset.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            btnNewButtonReset.setForeground(Color.getColor("bleu",couleur_contour_champ) );
            myPanelLogement1.add(btnNewButtonReset);

            btnNewButtonReset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tfAdresse.setText("");
                    tfBalcon.setText("");
                    tfM2.setText("");
                    tfNbVoyageur.setText("");
                    tfNumEtage.setText("");
                    tfSuperficie.setText("");
                    tfTarifNuit.setText("");
                    comboBox.setSelectedIndex(0);
                }
            });
            //---------------------FIN AJOUTER UN LOGEMENT-----------------------------------//


            //---------------------RETIRER UN LOGEMENT-----------------------------------//
            myPanelLogement2.setLayout(null);

            //////////  AJOUTER TITRE ////////

            JLabel lblNewLabelsupprimer = new JLabel("Quel logement voulez-vous supprimer ?");
            lblNewLabelsupprimer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabelsupprimer.setBounds(267, 30, 389, 25);
            myPanelLogement2.add(lblNewLabelsupprimer);

            //////////  AJOUTER FIELD SUPPRIMER ////////

            textFieldSupprimerLogement = new JTextField();
            textFieldSupprimerLogement.setBounds(347, 77, 189, 41);
            textFieldSupprimerLogement.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
            myPanelLogement2.add(textFieldSupprimerLogement);
            textFieldSupprimerLogement.setColumns(10);

            //////////  AJOUTER BOUTTON SUPPRIMER ////////

            JButton btnNewButtonSupprimer = new JButton("Supprimer");
            btnNewButtonSupprimer.setBounds(380, 150, 130, 50);
            btnNewButtonSupprimer.setForeground(Color.getColor("bleu",couleur_contour_champ));
            btnNewButtonSupprimer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            myPanelLogement2.add(btnNewButtonSupprimer);

            //////////  AJOUTER IMAGE ////////

            URL imgUrlsuppr = Accueil.class.getResource("/image/trash.png");
            ImageIcon iconesuppre = new ImageIcon(imgUrlsuppr);
            JLabel imagesuppri = new JLabel(iconesuppre);
            imagesuppri.setBounds(195, 170, 500, 500);
            myPanelLogement2.add(imagesuppri);

            //////////  AJOUTER IMAGE ////////

            URL imgUrlminiatureVoyageur2 = Accueil.class.getResource("/image/house-mini.png");
            ImageIcon iconeminiatureVoyageur2 = new ImageIcon(imgUrlminiatureVoyageur2);
            JLabel imageminiatureVoyageur2 = new JLabel(iconeminiatureVoyageur2);
            imageminiatureVoyageur2.setBounds(100, 30, 100, 100);
            myPanelLogement2.add(imageminiatureVoyageur2);

            //////////  EVENEMENTS BOUTTON ////////

            btnNewButtonSupprimer.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int logementASuppr = Integer.parseInt(textFieldSupprimerLogement.getText());
                    myData.getLogements().remove(logementASuppr);
                    JOptionPane.showMessageDialog(null, "Votre logement a bien été supprimé");
                    frame.setVisible(true);
                    frame.dispose();
                }
            });

            //---------------------RETIRER UN LOGEMENT FIN -----------------------------//



            //-------------------- Afficher Liste Logement -----------------------------//

            ArrayList<Logement> logements = myData.getLogements();
            for(int i = 0; i < logements.size(); i++) {
                monHote = logements.get(i).getHote();
                Logement log = logements.get(i);
                JLabel traits = testMaisonOuAppart(log, i, logements) ;

                JButton btnSupprimerLogement = new JButton("Supprimer ce logement");
                btnSupprimerLogement.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        myData.getLogements().remove(myData.getLogements().indexOf(log));
                        SwingUtilities.updateComponentTreeUI(frame);
                        myPanelLogement3.remove(traits);
                        myPanelLogement3.remove(btnSupprimerLogement);
                        myPanelLogement3.revalidate();
                        myPanelLogement3.repaint();
                    }
                });
                myPanelLogement3.add(traits);
                myPanelLogement3.add(btnSupprimerLogement);

            }

        }

        private JLabel testMaisonOuAppart(Logement logement, int i, ArrayList<Logement> logements) {
            JLabel affichageLabel;
            if(logement instanceof Maison) {
                Maison maMaison = (Maison) logement;
                String testPiscine = ((maMaison.getPossedePiscine())?"possède une piscine" : "ne possède pas de piscine");
                affichageLabel = new JLabel(afficheLogement(logements, i)
                        + "La maison "+ testPiscine +".<br>"
                        + "La superficie du jardin est de " + maMaison.getSuperficieJardin()+ "m2."
                        + "</html>");
                return affichageLabel;
            }else {
                Appartement monAppart = (Appartement) logement;
                String phraseBalcon = monAppart.getSuperficieBalcon() ==0 ? "Il n'y a pas de balcon <br>" : "Le balcon est d'une superficie de "+ monAppart.getSuperficieBalcon() +"m2.<br>";
                affichageLabel = new JLabel(afficheLogement(logements, i)
                        + phraseBalcon
                        + "L'appartement est à l'étage " + monAppart.getNumeroEtage() + "."
                        + "</html>");
                return affichageLabel;
            }
        }
        private String afficheLogement( ArrayList<Logement> logements, int i) {
            String styleDuLogement = logements.get(i) instanceof Appartement ? "un Appartement" : "une Maison";
            String logementAffiche = "<html>---------- <br>"
                    + "Logement numéro " + i + " est "+styleDuLogement+" : <br>"
                    + "Situé au " +logements.get(i).getAdresse()+".<br>"
                    + "Le propriétaire est "+monHote.getPrenom() + " " + monHote.getNom()+" "+monHote.getAge() +" ans qui répond généralement dans un délais de "+monHote.getDelaiReponse() + " heures. <br>"
                    + "Le logement est à un tarif de : "+logements.get(i).getTarifParNuit() + " € par nuit. <br>"
                    + "Il est doté d'une superficie de "+logements.get(i).getSuperficie() + " m2. <br>"
                    + "Le nombre maximum de voyageurs acceptés est  "+logements.get(i).getNbVoyageursMax() + " voyageurs.<br>";
            return logementAffiche;
    }

    public void AffichagePagesVoyageur(JTabbedPane jtbExample, JPanel panel1){




        //////////////////////////////
        //////////  AJOUTER   ////////
        //////////////////////////////

        jplInnerPanelAjouterVoyageur = new JPanel();
        jplInnerPanelAjouterVoyageur.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelAjouterVoyageur);
        jplInnerPanelAjouterVoyageur.setLayout(null);

        jplInnerPanelSupprimerVoyageur = new JPanel();
        jplInnerPanelSupprimerVoyageur.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelSupprimerVoyageur);
        jplInnerPanelSupprimerVoyageur.setLayout(null);

        JplInnerPanelAfficherVoyageur = new JPanel();
        JplInnerPanelAfficherVoyageur.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(JplInnerPanelAfficherVoyageur);
        JplInnerPanelAfficherVoyageur.setLayout(new BoxLayout(JplInnerPanelAfficherVoyageur,BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(JplInnerPanelAfficherVoyageur);

        panel1.add(jtbExample);
        JFrame frame = new JFrame("VOYAGEURS");
        Container panel = frame.getContentPane();
        panel.add(jtbExample);
        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);


        //////////  AJOUTER TITRE  ////////

        lblNewLabelTitreAjouterVoyageur = new JLabel("<HTML>Dans cette interface vous pouvez ajouter un " +
                "voyageur <br>   en remplissant les champs ci-dessous.</HTML>");
        lblNewLabelTitreAjouterVoyageur.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabelTitreAjouterVoyageur.setBounds(250, 60, 800, 50);
        jplInnerPanelAjouterVoyageur.add(lblNewLabelTitreAjouterVoyageur);

        //////////  AJOUTER LABEL NOM ////////

        JLabel lblNom = new JLabel("Nom");
        lblNom.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNom.setBounds(76, 220, 90, 29);
        jplInnerPanelAjouterVoyageur.add(lblNom);

        //////////  AJOUTER FIELD NOM ////////

        textFieldNomVoyageur = new JTextField();
        textFieldNomVoyageur.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        textFieldNomVoyageur.setBounds(157, 210, 232, 45);
        textFieldNomVoyageur.setColumns(10);
        jplInnerPanelAjouterVoyageur.add(textFieldNomVoyageur);

        //////////  AJOUTER LABEL PRENOM ////////

        JLabel lblPrnom = new JLabel("Prénom");
        lblPrnom.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblPrnom.setBounds(76, 300, 169, 29);
        jplInnerPanelAjouterVoyageur.add(lblPrnom);

        //////////  AJOUTER FIELD PRENOM ////////

        textFieldPrenomVoyageur = new JTextField();
        textFieldPrenomVoyageur.setColumns(10);
        textFieldPrenomVoyageur.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        textFieldPrenomVoyageur.setBounds(157, 290, 232, 45);
        jplInnerPanelAjouterVoyageur.add(textFieldPrenomVoyageur);

        //////////  AJOUTER LABEL AGE ////////

        JLabel lblNewLabel = new JLabel("Age");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabel.setBounds(76, 380, 90, 29);
        jplInnerPanelAjouterVoyageur.add(lblNewLabel);

        //////////  AJOUTER FIELD AGE ////////

        textFieldAgeVoyageur = new JTextField();
        textFieldAgeVoyageur.setColumns(10);
        textFieldAgeVoyageur.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        textFieldAgeVoyageur.setBounds(157, 370, 232, 45);
        jplInnerPanelAjouterVoyageur.add(textFieldAgeVoyageur);

        //////////  AJOUTER BOUTTON VALIDER ////////

        JButton btnNewButtonValider = new JButton("Valider");
        btnNewButtonValider.setBounds(105, 450, 130, 50);
        btnNewButtonValider.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnNewButtonValider.setForeground(Color.getColor("bleu",couleur_contour_champ) );
        jplInnerPanelAjouterVoyageur.add(btnNewButtonValider);

        //////////  AJOUTER BOUTTON RESET ////////

        JButton btnNewButtonReset = new JButton("Reset");
        btnNewButtonReset.setBounds(250, 450, 130, 50);
        btnNewButtonReset.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnNewButtonReset.setForeground(Color.getColor("bleu",couleur_contour_champ) );
        jplInnerPanelAjouterVoyageur.add(btnNewButtonReset);

        //////////  AJOUTER IMAGE ////////

        URL imgUrl = Accueil.class.getResource("/image/guide.png");
        ImageIcon icone = new ImageIcon(imgUrl);
        JLabel image1 = new JLabel(icone);
        image1.setBounds(400, 100, 500, 500);
        jplInnerPanelAjouterVoyageur.add(image1);

        //////////  AJOUTER TAB AJOUTER ////////

        jtbExample.addTab("Ajouter", null, jplInnerPanelAjouterVoyageur, "Tab 1");

        //////////  EVENEMENTS BOUTTON ////////


        btnNewButtonValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int ageVoyageur = Integer.parseInt(textFieldAgeVoyageur.getText());
                String nomVoyageur = textFieldNomVoyageur.getText();
                String prenomVoyageur = textFieldPrenomVoyageur.getText();

                Voyageur voyageur = new Voyageur(nomVoyageur,prenomVoyageur,ageVoyageur);
                AirBnBData.getInstance().getVoyageurs().add(voyageur);
                textFieldAgeVoyageur.setText("");
                textFieldNomVoyageur.setText("");
                textFieldPrenomVoyageur.setText("");
                JOptionPane.showMessageDialog(null, "Votre voyageur a bien été ajouté");
                frame.setVisible(true);
                frame.dispose();


            }
        });
        btnNewButtonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldAgeVoyageur.setText("");
                textFieldNomVoyageur.setText("");
                textFieldPrenomVoyageur.setText("");

            }
        });

        //////////////////////////////////
        /////////  FIN AJOUTER   /////////
        //////////////////////////////////

        ////////////////////////////////
        //////////  SUPPRIMER   ////////
        ////////////////////////////////


        //////////  AJOUTER TITRE ////////

        JLabel lblNewLabelsupprimer = new JLabel("Quel voyageur voulez-vous supprimer ?");
        lblNewLabelsupprimer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabelsupprimer.setBounds(267, 30, 389, 25);
        jplInnerPanelSupprimerVoyageur.add(lblNewLabelsupprimer);

        //////////  AJOUTER FIELD SUPPRIMER ////////

        textFieldSupprimerVoyageur = new JTextField();
        textFieldSupprimerVoyageur.setBounds(347, 77, 189, 41);
        textFieldSupprimerVoyageur.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelSupprimerVoyageur.add(textFieldSupprimerVoyageur);
        textFieldSupprimerVoyageur.setColumns(10);

        //////////  AJOUTER BOUTTON SUPPRIMER ////////

        JButton btnNewButtonSupprimer = new JButton("Supprimer");
        btnNewButtonSupprimer.setBounds(380, 150, 130, 50);
        btnNewButtonSupprimer.setForeground(Color.getColor("bleu",couleur_contour_champ));
        btnNewButtonSupprimer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        jplInnerPanelSupprimerVoyageur.add(btnNewButtonSupprimer);

        //////////  AJOUTER TAB SUPPRIMER ////////

        jtbExample.addTab("Supprimer", null, jplInnerPanelSupprimerVoyageur);


        //////////  AJOUTER IMAGE ////////

        URL imgUrlsuppr = Accueil.class.getResource("/image/trash.png");
        ImageIcon iconesuppre = new ImageIcon(imgUrlsuppr);
        JLabel imagesuppri = new JLabel(iconesuppre);
        imagesuppri.setBounds(195, 170, 500, 500);
        jplInnerPanelSupprimerVoyageur.add(imagesuppri);

        //////////  AJOUTER IMAGE ////////

        URL imgUrlminiatureVoyageur = Accueil.class.getResource("/image/guide-miniature.png");
        ImageIcon iconeminiatureVoyageur = new ImageIcon(imgUrlminiatureVoyageur);
        JLabel imageminiatureVoyageur = new JLabel(iconeminiatureVoyageur);
        imageminiatureVoyageur.setBounds(100, 30, 200, 200);
        jplInnerPanelSupprimerVoyageur.add(imageminiatureVoyageur);

        //////////  EVENEMENTS BOUTTON ////////

        btnNewButtonSupprimer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int numero = Integer.parseInt(textFieldSupprimerVoyageur.getText());
                AirBnBData.getInstance().getVoyageurs().remove(numero-1);
                textFieldSupprimerVoyageur.setText("");
                JOptionPane.showMessageDialog(null, "Votre voyageur a bien été supprimé");
                frame.setVisible(true);
                frame.dispose();

            }
        });

        /////////////////////////////////////
        //////////  FIN SUPPRIMER   /////////
        /////////////////////////////////////

        ////////////////////////////////
        //////////  AFFICHER    ////////
        ////////////////////////////////

        jtbExample.addTab("Afficher", null, scrollPane);

        //////////  AJOUTER AFFICHAGE ////////

        AirBnBData myData2 = AirBnBData.getInstance();
        ArrayList<Voyageur> voyageurs = myData2.getVoyageurs();
        for(int i = 0; i < voyageurs.size(); i++) {

            JLabel voyageur2 = new JLabel("<html>-------------------<br> VOYAGEUR N°"+(i+1)
                    +"<br>-------------------"+"<br> Nom : "+voyageurs.get(i).getNom()+"<br> Prenom : "
                    +voyageurs.get(i).getPrenom()+"<br> Age : "+voyageurs.get(i).getAge()+" ans <br><br>"+"</HTML>");
            Voyageur voy = voyageurs.get(i);
            JButton btnSupprimerVoyageur = new JButton("Supprimer ce voyageur");
            btnSupprimerVoyageur.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    myData.getVoyageurs().remove(myData.getVoyageurs().indexOf(voy));
                    SwingUtilities.updateComponentTreeUI(frame);
                    JplInnerPanelAfficherVoyageur.remove(voyageur2);
                    JplInnerPanelAfficherVoyageur.remove(btnSupprimerVoyageur);
                    JplInnerPanelAfficherVoyageur.revalidate();
                    JplInnerPanelAfficherVoyageur.repaint();
                }
            });
            JplInnerPanelAfficherVoyageur.add(voyageur2);
            JplInnerPanelAfficherVoyageur.add(btnSupprimerVoyageur);


        }



        //////////  AJOUTER IMAGE ////////

        URL imgUrlaffichervoyageur = Accueil.class.getResource("/");
        ImageIcon iconeaffichervoyageur = new ImageIcon(imgUrlaffichervoyageur);
        JLabel imageaffichervoyageur = new JLabel(iconeaffichervoyageur);
        imageaffichervoyageur.setBounds(195, 170, 500, 500);
        JplInnerPanelAfficherVoyageur.add(imageaffichervoyageur);


        /////////////////////////////////////
        //////////  FIN  AFFICHER   /////////
        /////////////////////////////////////



        /////////////////////////////
        //////////  AUTRE   /////////
        /////////////////////////////


        /////////     ///////////////
        //////////  FIN AUTRE   /////
        /////////////////////////////


    }
    public void AffichagePagesReservation(JTabbedPane jtbExample, JPanel panel1){

        //////////////////////////////
        //////////  RECHERCHE   ////////
        //////////////////////////////

        jplInnerPanelRechercheReservation = new JPanel();
        jplInnerPanelRechercheReservation.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelRechercheReservation);
        jplInnerPanelRechercheReservation.setLayout(null);


        jplInnerPanelAfficherRecherche = new JPanel();
        jplInnerPanelAfficherRecherche.setBorder(new EmptyBorder(5, 5, 5, 5));
        jplInnerPanelAfficherRecherche.setBounds(0,150,900,700);
        setContentPane(jplInnerPanelAfficherRecherche);
        jplInnerPanelAfficherRecherche.setLayout(new BoxLayout(jplInnerPanelAfficherRecherche,BoxLayout.PAGE_AXIS));
        jplInnerPanelRechercheReservation.add(jplInnerPanelAfficherRecherche);

        jplInnerPanelAjouterReservation = new JPanel();
        jplInnerPanelAjouterReservation.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelAjouterReservation);
        jplInnerPanelAjouterReservation.setLayout(null);

        jplInnerPanelSupprimerReservation = new JPanel();
        jplInnerPanelSupprimerReservation.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelSupprimerReservation);
        jplInnerPanelSupprimerReservation.setLayout(null);

        jplInnerPanelAfficherReservation = new JPanel();
        jplInnerPanelAfficherReservation.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelAfficherReservation);
        jplInnerPanelAfficherReservation.setLayout(new BoxLayout(jplInnerPanelAfficherReservation,BoxLayout.PAGE_AXIS));

        panel1.add(jtbExample);
        JFrame frame = new JFrame("RESERVATIONS");
        Container panel = frame.getContentPane();
        panel.add(jtbExample);
        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        JPanel roomList = new JPanel();
        roomList.setLayout(null);

        JLabel lblNumeroVoyageurReservation = new JLabel("<html>Nombre<br> Voyageurs</html>");
        lblNumeroVoyageurReservation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblNumeroVoyageurReservation.setBounds(10, 6, 100, 60);
        jplInnerPanelRechercheReservation.add(lblNumeroVoyageurReservation);

        textFieldNumeroVoyageurReservation = new JTextField();
        textFieldNumeroVoyageurReservation.setBounds(110, 15, 157, 39);
        textFieldNumeroVoyageurReservation.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelRechercheReservation.add(textFieldNumeroVoyageurReservation);
        textFieldNumeroVoyageurReservation.setColumns(10);

        JLabel lblDateDarriveReservation = new JLabel("<html>Tarif min <br>par nuit<html>");
        lblDateDarriveReservation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblDateDarriveReservation.setBounds(290, 6, 100, 60);
        jplInnerPanelRechercheReservation.add(lblDateDarriveReservation);

        textFieldDateArriveeReservation = new JTextField();
        textFieldDateArriveeReservation.setColumns(10);
        textFieldDateArriveeReservation.setBounds(380, 15, 157, 39);
        textFieldDateArriveeReservation.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelRechercheReservation.add(textFieldDateArriveeReservation);

        JLabel lblNombreDeNuitsReservation = new JLabel("<html>Tarif max<br> par nuit<html>");
        lblNombreDeNuitsReservation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblNombreDeNuitsReservation.setBounds(550, 6, 100, 60);
        jplInnerPanelRechercheReservation.add(lblNombreDeNuitsReservation);

        textFieldNombreDeNuitReservation = new JTextField();
        textFieldNombreDeNuitReservation.setColumns(10);
        textFieldNombreDeNuitReservation.setBounds(650, 15, 157, 39);
        textFieldNombreDeNuitReservation.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelRechercheReservation.add(textFieldNombreDeNuitReservation);

        JCheckBox chckbxNewCheckBoxPiscine = new JCheckBox("Piscine");
        chckbxNewCheckBoxPiscine.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        chckbxNewCheckBoxPiscine.setBounds(200, 110, 105, 23);
        jplInnerPanelRechercheReservation.add(chckbxNewCheckBoxPiscine);

        JCheckBox chckbxNewCheckBoxJardin = new JCheckBox("Jardin");
        chckbxNewCheckBoxJardin.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        chckbxNewCheckBoxJardin.setBounds(300, 110, 105, 23);
        jplInnerPanelRechercheReservation.add(chckbxNewCheckBoxJardin);

        JCheckBox chckbxNewCheckBoxBalcon = new JCheckBox("Balcon");
        chckbxNewCheckBoxBalcon.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        chckbxNewCheckBoxBalcon.setBounds(400, 110, 105, 23);
        jplInnerPanelRechercheReservation.add(chckbxNewCheckBoxBalcon);

        JButton btnNewButtonRechercherReservation = new JButton("Rechercher");
        btnNewButtonRechercherReservation.setBounds(500, 100, 130, 50);
        btnNewButtonRechercherReservation.setForeground(Color.getColor("bleu",couleur_contour_champ));
        btnNewButtonRechercherReservation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        jplInnerPanelRechercheReservation.add(btnNewButtonRechercherReservation);


        jtbExample.addTab("Recherche", null, jplInnerPanelRechercheReservation);

        btnNewButtonRechercherReservation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                reservation = new ArrayList<>();
                jplInnerPanelAfficherRecherche.removeAll();
                jplInnerPanelAfficherRecherche.revalidate();
                jplInnerPanelAfficherRecherche.repaint();
                int nombreVoyageur = Integer.parseInt(textFieldNumeroVoyageurReservation.getText());
                int tarifMinNuit = Integer.parseInt(textFieldDateArriveeReservation.getText());
                int tarifMaxNuit = Integer.parseInt(textFieldNombreDeNuitReservation.getText());

                if (chckbxNewCheckBoxPiscine.isSelected()){
                    piscine = true;
                }else{
                    piscine = false;
                }
                if (chckbxNewCheckBoxBalcon.isSelected()){
                    balcon = true;
                }else{
                    balcon = false;
                }
                if (chckbxNewCheckBoxJardin.isSelected()){
                    jardin = true;
                }else{
                    jardin = false;
                }
                Search.SearchBuilder searchBuilder = new Search.SearchBuilder(nombreVoyageur)
                        .tarifMaxParNuit(tarifMaxNuit).tarifMinParNuit(tarifMinNuit).possedeBalcon(balcon)
                        .possedePiscine(piscine).possedeJardin(jardin);
                Search search = searchBuilder.build();
                ArrayList<Logement> logements = search.result();
                System.out.println(logements);

                for (Logement logement: logements) {
                    if (logement.getClass().getName().equals("pbardu.airbnb.logements.Maison")) {
                        //System.out.println(logement.getClass().getName().equals("pbardu.airbnb.logements.Maison"));
                        System.out.println(logement.getIndex());
                        JLabel reservation = new JLabel("<html>-----------------------------<br>LOGEMENT N°"
                                +logement.getIndex()+"<br>-----------------------------<br>Le logement est une maison située "
                                +logement.getAdresse()+", pour "+logement.getNbVoyageursMax()
                                +" personne(s), la superficie : "+logement.getSuperficie()+" m2, "
                                +logement.getTarifParNuit()+"€");
                        jplInnerPanelAfficherRecherche.add(reservation);
                        if (piscine == true){
                            JLabel piscine = new JLabel("Piscine : oui");
                            jplInnerPanelAfficherRecherche.add(piscine);
                            piscine.setHorizontalAlignment(SwingConstants.CENTER);
                        }else {
                            JLabel piscine = new JLabel("Piscine : non");
                            jplInnerPanelAfficherRecherche.add(piscine);
                            piscine.setHorizontalAlignment(SwingConstants.CENTER);
                        }
                        if (jardin == true){
                            JLabel jardin = new JLabel("Jardin : oui");
                            jplInnerPanelAfficherRecherche.add(jardin);
                            jardin.setHorizontalAlignment(SwingConstants.CENTER);
                        }else {
                            JLabel jardin = new JLabel("Jardin : non");
                            jplInnerPanelAfficherRecherche.add(jardin);
                            jardin.setHorizontalAlignment(SwingConstants.CENTER);
                        }
                       //reservation.setHorizontalAlignment(SwingConstants.CENTER);
                    }else{
                        JLabel reservation2 = new JLabel("<html>-----------------------------<br>LOGEMENT N°"
                                +logement.getIndex()+"<br>-----------------------------<br>Le logement est un appartement " +
                                "située "+logement.getAdresse()+" pour "+logement.getNbVoyageursMax()+" personne(s), superficie : "
                                +logement.getSuperficie()+" m2, "
                                +logement.getTarifParNuit()+"€");
                        jplInnerPanelAfficherRecherche.add(reservation2);
                        if (balcon == true){
                            JLabel balcon = new JLabel("Balcon : oui");
                            jplInnerPanelAfficherRecherche.add(balcon);
                            balcon.setHorizontalAlignment(SwingConstants.CENTER);
                        }else {
                            JLabel balcon = new JLabel("Balcon : non");
                            jplInnerPanelAfficherRecherche.add(balcon);
                            balcon.setHorizontalAlignment(SwingConstants.CENTER);
                        }

                       //reservation2.setHorizontalAlignment(SwingConstants.CENTER);
                    }
                    reservation.add(logement);

                }
                for (int i = 0; i < reservation.size(); i++) {
                    System.out.print("Numéro " + i + " : ");
                    System.out.println(reservation.get(i));
                }
                SwingUtilities.updateComponentTreeUI(jplInnerPanelAfficherRecherche);

            }

        });
        //////////////////////////////////
        /////////  FIN RECHERCHE   //////
        ////////////////////////////////

        //////////////////////////////
        //////////  AJOUTER   ////////
        //////////////////////////////
        jplInnerPanelAjouterReservation = new JPanel();
        jplInnerPanelAjouterReservation.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jplInnerPanelAjouterReservation);
        jplInnerPanelAjouterReservation.setLayout(null);

        JLabel lblNewLabelNumeroVoyageur = new JLabel("Numéro voyageur");
        lblNewLabelNumeroVoyageur.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNewLabelNumeroVoyageur.setBounds(106, 81, 179, 25);
        jplInnerPanelAjouterReservation.add(lblNewLabelNumeroVoyageur);

        textFieldNumeroVoyageur = new JTextField();
        textFieldNumeroVoyageur.setBounds(361, 77, 157, 39);
        textFieldNumeroVoyageur.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelAjouterReservation.add(textFieldNumeroVoyageur);
        textFieldNumeroVoyageur.setColumns(10);

        JLabel lblDateDarrive = new JLabel("Date d’arrivée");
        lblDateDarrive.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblDateDarrive.setBounds(106, 142, 179, 25);
        jplInnerPanelAjouterReservation.add(lblDateDarrive);

        textFieldDateArrivee = new JTextField();
        textFieldDateArrivee.setColumns(10);
        textFieldDateArrivee.setBounds(361, 138, 157, 39);
        textFieldDateArrivee.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelAjouterReservation.add(textFieldDateArrivee);

        JLabel lblNombreDeNuits = new JLabel("Nombre de nuits");
        lblNombreDeNuits.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNombreDeNuits.setBounds(106, 206, 179, 25);
        jplInnerPanelAjouterReservation.add(lblNombreDeNuits);

        textFieldNombreDeNuit = new JTextField();
        textFieldNombreDeNuit.setColumns(10);
        textFieldNombreDeNuit.setBounds(361, 202, 157, 39);
        textFieldNombreDeNuit.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelAjouterReservation.add(textFieldNombreDeNuit);

        JLabel lblNombreDeVoyageurs = new JLabel("Nombre de voyageurs");
        lblNombreDeVoyageurs.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblNombreDeVoyageurs.setBounds(106, 271, 219, 25);
        jplInnerPanelAjouterReservation.add(lblNombreDeVoyageurs);

        textFieldNombreDeVoyageurs = new JTextField();
        textFieldNombreDeVoyageurs.setColumns(10);
        textFieldNombreDeVoyageurs.setBounds(361, 267, 157, 39);
        textFieldNombreDeVoyageurs.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelAjouterReservation.add(textFieldNombreDeVoyageurs);

        JLabel lblChoixLogement = new JLabel("Choix Logement");
        lblChoixLogement.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblChoixLogement.setBounds(106, 335, 219, 25);
        jplInnerPanelAjouterReservation.add(lblChoixLogement);

        JButton btnNewButtonChoisir = new JButton("Choisir");
        btnNewButtonChoisir.setBounds(210, 440, 130, 50);
        btnNewButtonChoisir.setForeground(Color.getColor("bleu",couleur_contour_champ));
        btnNewButtonChoisir.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        jplInnerPanelAjouterReservation.add(btnNewButtonChoisir);

        JTextField textFieldChoisir = new JTextField();
        textFieldChoisir.setBounds(361, 330, 157, 39);
        textFieldChoisir.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelAjouterReservation.add(textFieldChoisir);
        textFieldChoisir.setColumns(10);

        URL imgUrl = Accueil.class.getResource("/image/online-reservation.png");
        ImageIcon icone = new ImageIcon(imgUrl);
        JLabel image1 = new JLabel(icone);
        image1.setBounds(450, 100, 500, 500);
        jplInnerPanelAjouterReservation.add(image1);

        jtbExample.addTab("Ajouter", null, jplInnerPanelAjouterReservation);

        btnNewButtonChoisir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateFormat  dateArrivee = new SimpleDateFormat("dd/MM/yyyy",new Locale("fr"));
                Date d;

                try {
                    d = dateArrivee.parse(textFieldDateArrivee.getText());

                } catch (ParseException e1) {
                    e1.printStackTrace();
                    return;
                }
                System.out.println(dateArrivee.format(d));
                int logementChoix = Integer.parseInt(textFieldChoisir.getText());
                int numeroVoyageur = Integer.parseInt(textFieldNumeroVoyageur.getText());
                int nombreNuit = Integer.parseInt(textFieldNombreDeNuit.getText());
                int nombreVoyageurs = Integer.parseInt(textFieldNombreDeVoyageurs.getText());


                Sejour sejour;
                if (nombreNuit > 5) {
                    sejour = new SejourLong(d,AirBnBData.getInstance().getLogements().get(logementChoix), nombreNuit, nombreVoyageurs);
                } else {
                    sejour = new SejourCourt(d,AirBnBData.getInstance().getLogements().get(logementChoix), nombreNuit, nombreVoyageurs);
                }


                Reservation newReservation = new Reservation(sejour,
                        AirBnBData.getInstance().getVoyageurs().get(numeroVoyageur));

                AirBnBData.getInstance().getListReservations().add(newReservation);

                JOptionPane.showMessageDialog(null, "Votre réservation a bien été ajoutée");

                try {
                    File fichier = new File("/Users/cda/Desktop/reservation/resa.txt") ;
                    PrintWriter out;
                    out = new PrintWriter(new FileWriter(fichier, true));
                    out.println();
                    out.write("-----------------------------");
                    out.println();
                    out.write("----------RESERVATION--------");
                    out.println();
                    out.write("-----------------------------");
                    out.println();
                    out.write("Identifiant du voyageur : 1");
                    out.println();
                    out.write("Numéro du logement : 4");
                    out.println();
                    out.write("Date d'arrivée : " + dateArrivee);
                    out.println();
                    out.write("Nombre nuits : " + nombreNuit);
                    out.println();
                    out.write("Nombre personnes : " + nombreVoyageurs);
                    out.close();

                } catch (Exception f) {
                    System.out.println("Erreur " + f.getMessage());
                }
                frame.setVisible(true);
                frame.dispose();

            }

        });

        /////////////////////////////////////
        //////////  FIN AJOUTER   ////////
        ///////////////////////////////////

        ////////////////////////////////
        //////////  SUPPRIMER   ////////
        ////////////////////////////////





        //////////  AJOUTER TITRE ////////

        JLabel jlabelSupprimerReservation = new JLabel("<html>Quelle reservation voulez-vous<br> supprimer ?</html>");
        jlabelSupprimerReservation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        jlabelSupprimerReservation.setBounds(267, 15, 389, 50);
        jplInnerPanelSupprimerReservation.add(jlabelSupprimerReservation);

        //////////  AJOUTER FIELD SUPPRIMER ////////

        textFieldSupprimerReservation = new JTextField();
        textFieldSupprimerReservation.setBounds(347, 77, 189, 41);
        textFieldSupprimerReservation.setBorder(BorderFactory.createLineBorder(couleur_contour_champ));
        jplInnerPanelSupprimerReservation.add(textFieldSupprimerReservation);
        textFieldSupprimerReservation.setColumns(10);

        //////////  AJOUTER BOUTTON SUPPRIMER ////////

        JButton jButtonSupprimerReservation = new JButton("Supprimer");
        jButtonSupprimerReservation.setBounds(380, 150, 130, 50);
        jButtonSupprimerReservation.setForeground(Color.getColor("bleu",couleur_contour_champ));
        jButtonSupprimerReservation.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        jplInnerPanelSupprimerReservation.add(jButtonSupprimerReservation);

        //////////  AJOUTER TAB SUPPRIMER ////////

        jtbExample.addTab("Supprimer", null, jplInnerPanelSupprimerReservation, "Tab 1");

        //////////  AJOUTER IMAGE ////////

       URL imgUrlsupprReservation = Accueil.class.getResource("/image/trash.png");
       ImageIcon iconesuppreReservation  = new ImageIcon(imgUrlsupprReservation);
       JLabel imagesuppriReservation  = new JLabel(iconesuppreReservation);
       imagesuppriReservation .setBounds(195, 170, 500, 500);
       jplInnerPanelSupprimerReservation.add(imagesuppriReservation );

        //////////  AJOUTER IMAGE ////////

        URL imgUrlminiatureReservation = Accueil.class.getResource("/image/online-reservation-mini.png");
       ImageIcon iconeminiatureReservation = new ImageIcon(imgUrlminiatureReservation);
       JLabel imageminiatureReservation = new JLabel(iconeminiatureReservation);
       imageminiatureReservation.setBounds(100, 30, 200, 200);
       jplInnerPanelSupprimerReservation.add(imageminiatureReservation);

        //////////  EVENEMENTS BOUTTON ////////

        jButtonSupprimerReservation.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e) {

               int numero = Integer.parseInt(textFieldSupprimerReservation.getText());
               AirBnBData.getInstance().getListReservations().remove(numero-1);
               textFieldSupprimerReservation.setText("");
               JOptionPane.showMessageDialog(null, "Votre reservation a bien été supprimée");
               frame.setVisible(true);
               frame.dispose();

           }
       });

        /////////////////////////////////////
        //////////  FIN SUPPRIMER   /////////
        /////////////////////////////////////

        /////////////////////////////////
        //////////  AFFICHER   /////////
        ///////////////////////////////


        jtbExample.addTab("Afficher", null, jplInnerPanelAfficherReservation, "Tab 1");


        AirBnBData myData2 = AirBnBData.getInstance();
        ArrayList<Reservation> reservation = myData2.getListReservations();
        for(int i = 0; i < reservation.size(); i++) {

            JLabel reservation2 = new JLabel("<html>"+reservation.get(i).getVoyageur().getPrenom()
                        +" "+reservation.get(i).getVoyageur().getNom()+" ("
                        +reservation.get(i).getVoyageur().getAge()+" ans) "
                        +"a fait une réservation chez "+reservation.get(i).getSejour().getLogement().getHote().getPrenom()
                        +" "+reservation.get(i).getSejour().getLogement().getHote().getNom()+" ("
                        +reservation.get(i).getSejour().getLogement().getHote().getAge()
                        +" ans) qui s'engage à repondre dans les "
                        +reservation.get(i).getSejour().getLogement().getHote().getDelaiReponse()
                        +" heures.<br> Le logement est "+reservation.get(i).getSejour().getLogement().getAdresse()
                        +" pour "+reservation.get(i).getSejour().getNbVoyageurs()
                        +" voyageur(s) max.<br>Superficie : "+reservation.get(i).getSejour().getLogement().getSuperficie()
                        +"m2<br>La date d'arrivée est le "+reservation.get(i).getSejour().getDateArrivee()
                        +" pour "+reservation.get(i).getSejour().getNbNuits()+" nuits.<br>"
                        +"Le prix de ce séjour est de "
                        +reservation.get(i).getSejour().getLogement().getTarifParNuit()*reservation.get(i).getSejour().getNbNuits()
                        +"€<br>"
                        +"-----------------------------------------------------------------------------------------</html>");
            reservation2.setHorizontalAlignment(SwingConstants.CENTER);
            jplInnerPanelAfficherReservation.add(reservation2);

        }

        /////////////////////////////////////
        //////////  FIN  AFFICHER   /////////
        /////////////////////////////////////






    }
}
