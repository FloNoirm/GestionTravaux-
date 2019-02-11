package mrbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App 
{
	public static void main( String[] args ) throws SQLException
	{
		FrameApp  frame = new FrameApp();
		frame.setVisible(true);

		System.out.println( "Salut les tocards !!!!!" );
		//TestMySQL();

	}

	private static void TestMySQL() throws SQLException {
		String Serveur = "localhost";

		String Base = "mrbs";
		String Utilisateur = "root";
		String MotDePasse = "root";


		String connectionURL = "jdbc:mysql://" + Serveur + ":3306/" + Base + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

		Connection conn = DriverManager.getConnection(connectionURL, Base,
				MotDePasse);

		Statement Execution = conn.createStatement();

		String requete = "SELECT name, email FROM mrbs_users ORDER BY name";

		ResultSet rs = Execution.executeQuery(requete);

		int cpt = 0;

		while(rs.next()) {
			System.out.println(rs.getString("name") + " " + rs.getString("email"));
			cpt+=1;
		}
		System.out.println("il y a " + cpt + " enregistrements");
		conn.close();
	}
}
