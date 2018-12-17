package mrbs;

public class ConnexionBDD {

	String Serveur;
	String Base;
	String Utilisateur;
	String MotDePasse;

	public ConnexionBDD(String serveur, String base, String utilisateur, String motDePasse) {
		super();
		Serveur = serveur;
		Base = base;
		Utilisateur = utilisateur;
		MotDePasse = motDePasse;
	}

	public String getServeur() {
		return Serveur;
	}

	public void setServeur(String serveur) {
		Serveur = serveur;
	}

	public String getBase() {
		return Base;
	}

	public void setBase(String base) {
		Base = base;
	}

	public String getUtilisateur() {
		return Utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		Utilisateur = utilisateur;
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}





}
