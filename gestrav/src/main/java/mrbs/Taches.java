package mrbs;

import java.sql.ResultSet;

public class Taches {

	private String nomTache;
	private int etat_id_etat;

	private enum EtatTache{
		EN_COURS(1, "En cours"),
		TERMINE(3, "Terminée"),
		EN_ATTENTE(2,"En attente");

		private String libelle;
		private int code;


		private EtatTache(int code ,String libelle) {
			this.libelle = libelle;
			this.code = code;
		}

		public int etat_id_etat() {
			return code;
		}

		public String getLibelle() {
			return libelle;
		}

	}

	public boolean isTacheTerminee() {
		return etat_id_etat==EtatTache.TERMINE.etat_id_etat();
	}
	public boolean isTacheEnCours() {
		return etat_id_etat==EtatTache.EN_COURS.etat_id_etat();
	}
	public boolean isTacheEnAttente() {
		return etat_id_etat==EtatTache.EN_ATTENTE.etat_id_etat();
	}








	public String getNomTache() {
		return nomTache;
	}
	public void setName(String name) {
		this.nomTache = name;
	}
	public int getEtat() {
		return etat_id_etat;
	}
	public void setIdentifiant(int identifiant) {
		this.etat_id_etat = identifiant;
	}
	@Override
	public String toString() {
		return getNomTache();
	}
	public static Taches rsetToTache(ResultSet rset) {
		if (rset == null) {
			throw new IllegalArgumentException("Le resultset ne peut pas être null");
		}

		final Taches taches = new Taches();

		try {
			final Integer etat_id_etat = rset.getInt("etat_id_etat");
			final String nomTache = rset.getString("nomTache");

			taches.setIdentifiant(etat_id_etat);
			taches.setName(nomTache);


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return taches;
	}



}


