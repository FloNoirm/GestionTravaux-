package mrbs;

import java.sql.ResultSet;
import java.util.Date;

public class Taches {

	private String nomTache;
	private int etat_id_etat;
	private Date date_debut;
	private Date date_fin;
	private int priorite_tache;
	private int idTache;

	private enum EtatTache{
		EN_COURS(1, "En cours"),
		TERMINE(3, "Terminée"),
		EN_ATTENTE(2,"En attente");

		private String libelle;
		private int etat_id_etat;


		private EtatTache(int code ,String libelle) {
			this.libelle = libelle;
			this.etat_id_etat = code;
		}

		public int etat_id_etat() {
			return etat_id_etat;
		}

		public String getLibelle() {
			return libelle;
		}
		public static String libelleWithCode(int codeValue) {
			for (EtatTache etat : EtatTache.values()) {
				if ( etat.etat_id_etat() == codeValue )
					return etat.getLibelle();
			}
			return null;
		}
	}


	private enum PrioriteTache{
		IMPORTANT(1, "Important"),
		MEDIUM(2, "Medium"),
		SANS_URGENCE(3,"Sans urgence");

		private String libelle;
		private int code;


		private PrioriteTache(int code ,String libelle) {
			this.libelle = libelle;
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public String getLibelle() {
			return libelle;
		}
		public static String libelleWithCode(int codeValue) {
			for (PrioriteTache etat : PrioriteTache.values()) {
				if ( etat.getCode() == codeValue )
					return etat.getLibelle();
			}
			return null;
		}


	}

	public String getPrioriteLibelle() {
		PrioriteTache.libelleWithCode(priorite_tache);
		return PrioriteTache.libelleWithCode(priorite_tache);
	}

	public int getPriorite_tache() {
		return priorite_tache;
	}
	public void setPriorite_tache(int priorite_tache) {
		this.priorite_tache = priorite_tache;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String getNomTache() {
		return nomTache;
	}
	public void setName(String name) {
		this.nomTache = name;
	}

	public void setEtatTache(int etat_id_etat) {
		this.etat_id_etat = etat_id_etat;
	}
	public int getEtat() {
		return etat_id_etat;
	}

	public void setIdEtat(int idTache) {
		this.idTache = getIdTache();
	}
	private int getIdTache() {
		return idTache;
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
			final Integer idTache = rset.getInt("idTache");
			final String nomTache = rset.getString("nomTache");
			final int etatTache = rset.getInt("Etat_id_etat");
			final int priorite_tache = rset.getInt("priorite_tache");
			long time = rset.getDate("date_debut") == null ? 0 : rset.getDate("date_debut").getTime();
			final Date date_debut = new Date(time);
			time = rset.getDate("date_fin") == null ? 0 : rset.getDate("date_fin").getTime();
			final Date date_fin = new Date(time);

			taches.setIdentifiant(idTache);
			taches.setName(nomTache);
			taches.setDate_debut(date_debut);
			taches.setDate_fin(date_fin);
			taches.setEtatTache(etatTache);
			taches.setPriorite_tache(priorite_tache);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return taches;
	}
	private void setIdentifiant(Integer idTache) {
		this.idTache = idTache;

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
	public String getLibelleEtat() {
		return EtatTache.libelleWithCode(etat_id_etat);
	}
	public char[] getSalle() {

		return null;
	}
}
