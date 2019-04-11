package pbardu.resaClientConsole.menu;

import java.util.InputMismatchException;

import pbardu.resaBusiness.utilisateurs.Voyageur;

public class GestionVoyageurs {

	protected static void listerVoyageurs() {

		System.out.println("-------------------------------------");
		System.out.println("Liste des voyageurs ");

		for (int i = 0; i < Menu.listVoyageurs.size(); i++) {
			System.out.print("Numéro " + i + " :");
			Menu.listVoyageurs.get(i).afficher();
			System.out.println();
		}

		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un voyageur");
		System.out.println("2 : Supprimer un voyageur");
		System.out.println("3 : Retour");

		try {
			switch (Menu.choix(3)) {
			case 1:
				ajouterVoyageur();
				break;
			case 2:
				supprimerVoyageur();
				break;
			case 3:
				Menu.listerMenu();
				break;
			}

		} catch (InputMismatchException e) {
			System.out.println("Une erreur est survenue lors de la saisie");
			Menu.scanner.next();
			listerVoyageurs();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Une erreur est survenue lors de la suppression");
			listerVoyageurs();
		}
	}

	private static void ajouterVoyageur() throws InputMismatchException {

		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouveau voyageur");

		System.out.print("Prénom : ");
		String prenom = Menu.scanner.next();
		System.out.print("Nom : ");
		String nom = Menu.scanner.next();
		System.out.print("Age : ");
		int age = Menu.scanner.nextInt();
		System.out.println();

		Voyageur newVoyageur = new Voyageur(prenom, nom, age);
		Menu.listVoyageurs.add(newVoyageur);

		System.out.println("Votre voyageur a été ajouté avec succés");

		listerVoyageurs();
	}

	private static void supprimerVoyageur() throws InputMismatchException, IndexOutOfBoundsException {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un voyageur");

		System.out.print("Numéro : ");
		int numero = Menu.scanner.nextInt();
		System.out.println();

		Menu.listVoyageurs.remove(numero);

		System.out.println("Votre voyageur a été supprimé avec succés");

		listerVoyageurs();
	}

}
