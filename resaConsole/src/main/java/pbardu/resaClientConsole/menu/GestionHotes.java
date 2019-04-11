package pbardu.resaClientConsole.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import pbardu.resaBusiness.utilisateurs.Hote;

public class GestionHotes {

	static void listerHotes() {

		System.out.println("-------------------------------------");
		System.out.println("Liste des hôtes ");

		for (int i = 0; i < Menu.listHotes.size(); i++) {
			System.out.print("Numéro " + i + " : ");
			Menu.listHotes.get(i).afficher();
			System.out.println();
		}

		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un hôte");
		System.out.println("2 : Supprimer un hôte");
		System.out.println("3 : Retour");

		try {
			switch (Menu.choix(3)) {
			case 1:
				ajouterHote();
				break;
			case 2:
				supprimerHote();
				break;
			case 3:
				Menu.listerMenu();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Une erreur est survenue lors de la saisie");
			Menu.scanner.next();
			listerHotes();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Une erreur est survenue lors de la suppression");
			listerHotes();
		}
	}

	public static void ajouterHote() throws InputMismatchException {

		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouvel hôte");

		System.out.print("Prénom : ");
		String prenom = Menu.scanner.next();
		System.out.print("Nom : ");
		String nom = Menu.scanner.next();
		System.out.print("Age : ");
		int age = Menu.scanner.nextInt();
		System.out.print("Temps de réponse (heure) : ");
		int delaisReponse = Menu.scanner.nextInt();
		System.out.println();

		Hote newHote = new Hote(prenom, nom, age, delaisReponse);
		Menu.listHotes.add(newHote);

		System.out.println("Votre hôte a été ajouté avec succés");
		listerHotes();
	}

	private static void supprimerHote() throws InputMismatchException, IndexOutOfBoundsException {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		System.out.print("Numéro : ");
		int numero = Menu.scanner.nextInt();
		System.out.println();

		Menu.listHotes.remove(numero);

		System.out.println("Votre hôte a été supprimé avec succés");
		listerHotes();
	}
}
