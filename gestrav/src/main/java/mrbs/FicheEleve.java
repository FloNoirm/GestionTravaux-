package mrbs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class FicheEleve {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FicheEleve window = new FicheEleve();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public FicheEleve() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JList ListeEleve = new JList();
		frame.getContentPane().add(ListeEleve, BorderLayout.CENTER);
		TestMySQL(ListeEleve);
	}

	private static void TestMySQL(JList Liste) throws SQLException {
		String serveur = "localhost";

		String base = "mrbs";
		String utilisateur = "root";
		String MotDePasse = "root";


		String connectionURL = "jdbc:mysql://" + serveur + ":3306/" + base + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

		Connection conn = DriverManager.getConnection(connectionURL, utilisateur,
				MotDePasse);

		Statement Execution = conn.createStatement();

		String requete = "SELECT name, email FROM mrbs_users ORDER BY name";

		ResultSet rs = Execution.executeQuery(requete);

		int cpt = 0;

		DefaultListModel MonModele = new DefaultListModel();


		while(rs.next()) {
			//System.out.println(rs.getString("Nom") + " " + rs.getString("Prenom"));
			MonModele.addElement(rs.getString("name") + " " + rs.getString("email"));
			cpt+=1;
		}
		Liste.setModel(MonModele);
		//System.out.println("il y a " + cpt + " enregistrements");
		conn.close();
	}

}
