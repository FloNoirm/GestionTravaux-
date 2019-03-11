package mrbs.model;

import java.sql.ResultSet;

public class Users {

	private String name;
	private int identifiant;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}
	@Override
	public String toString() {
		return getName();
	}
	public static Users rsetToUser(ResultSet rset) {
		if (rset == null) {
			throw new IllegalArgumentException("Le resultset ne peut pas être null");
		}

		final Users user = new Users();

		try {
			final Integer id = rset.getInt("id");
			final String prenom = rset.getString("name");

			user.setIdentifiant(id);
			user.setName(prenom);


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return user;
	}



}

