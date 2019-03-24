package mrbs;

import java.sql.ResultSet;

public class Taches {

	private String nomTache;
	private int idTache;


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

			taches.setIdentifiant(idTache);
			taches.setName(nomTache);


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return taches;
	}



}


