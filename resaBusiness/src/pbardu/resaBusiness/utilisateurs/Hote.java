package pbardu.resaBusiness.utilisateurs;


import javax.persistence.*;

@Entity
@Table(name = "hote")
public final class Hote extends Personne {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private int delaiReponse;


	public Hote(String nom, String prenom, int age, String mdp, String email, int delaiReponse) {
		super(nom, prenom, age, mdp, email);
		this.delaiReponse = delaiReponse;
	}

	public Hote() {}

	@Override
	public void afficher() {
		super.afficher();
		System.out.print(" qui s'engage à répondre dans les " + delaiReponse + " heures");
	}


	public int getDelaiReponse() {
		return delaiReponse;
	}

	public void setDelaiReponse(int delaiReponse) {
		this.delaiReponse = delaiReponse;
	}
}
