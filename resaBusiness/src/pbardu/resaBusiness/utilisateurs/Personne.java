package pbardu.resaBusiness.utilisateurs;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class Personne {

	public Personne() {
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getMdp() {
		return mdp;
	}

	// 1° - Les attributs
	@Column(name= "nom")
	private String nom;

	@Column(name= "prenom")
	private String prenom;

	@Column(name= "age")
	private int age;

	@Column(name= "email")
	private String email;

	@Column(name= "mdp")
	private String mdp;


	public Personne(String pNom, String pPrenom, int pAge, String pmdp, String pemail) {
		nom = pNom;
		prenom = pPrenom;
		age = pAge;
		email = pemail;
		mdp = pmdp;
	}

	// 3° - la methode
	public void afficher() {
		System.out.print(prenom + " " + nom + " (" + age + " ans)");
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
