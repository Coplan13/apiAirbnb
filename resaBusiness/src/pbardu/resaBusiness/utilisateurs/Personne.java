package pbardu.resaBusiness.utilisateurs;

public class Personne {

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getAge() {
		return age;
	}

	// 1° - Les attributs
	private final String nom;
	private final String prenom;
	private final int age;

	// 2° - le constructeur
	public Personne(String pNom, String pPrenom, int pAge) {
		nom = pNom;
		prenom = pPrenom;
		age = pAge;
	}

	// 3° - la methode
	public void afficher() {
		System.out.print(prenom + " " + nom + " (" + age + " ans)");
	}

}
