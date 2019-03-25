package mrbs;

import java.sql.ResultSet;
import java.util.Date;

public class Taches {

	private String nomTache;
	private int idTache;
	private Date date_debut;
	private Date date_fin;
	private int priorite_tache;


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
	public int getIdentifiant() {
		return idTache;
	}
	public void setIdentifiant(int identifiant) {
		this.idTache = identifiant;
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
			long time = rset.getDate("date_debut") == null ? 0 : rset.getDate("date_debut").getTime();
			final Date date_debut = new Date(time);
			time = rset.getDate("date_fin") == null ? 0 : rset.getDate("date_fin").getTime();
			final Date date_fin = new Date(time);

			taches.setIdentifiant(idTache);
			taches.setName(nomTache);
			taches.setDate_debut(date_debut);
			taches.setDate_fin(date_fin);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return taches;
	}
}
