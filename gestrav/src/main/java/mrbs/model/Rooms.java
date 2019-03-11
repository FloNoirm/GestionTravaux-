package mrbs.model;

import java.sql.ResultSet;

public class Rooms {

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
		return  getName();
	}

	public static Rooms rsetToRoom(ResultSet rset) {
		if (rset == null) {
			throw new IllegalArgumentException("Le resultset ne peut pas être null");
		}

		final Rooms room = new Rooms();

		try {
			final String prenom = rset.getString("room_name");
			final Integer id = rset.getInt("id");

			room.setIdentifiant(id);
			room.setName(prenom);


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return room;
	}

}
