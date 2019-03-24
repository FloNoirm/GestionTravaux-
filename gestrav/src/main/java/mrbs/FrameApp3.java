package mrbs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FrameApp3 extends JFrame {
	private JPanel panel;
	private JComboBox comboTaches;
	private JLabel lblChoixTaches;
	private JButton btnValider;
	private JList jlist;

	public FrameApp3() throws HeadlessException {
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		setSize(new Dimension(800, 800));
	}

	public FrameApp3(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public FrameApp3(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public FrameApp3(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getComboTaches());
			panel.add(getLblChoixTaches());
			panel.add(getBtnValider());
			panel.add(getJList());
		}
		return panel;
	}
	private JComboBox getComboTaches() {
		if (comboTaches == null) {
			comboTaches = new JComboBox();
			comboTaches.setSize(138, 20);
			comboTaches.setLocation(new Point(159, 75));
		}
		return comboTaches;
	}
	private JLabel getLblChoixTaches() {
		if (lblChoixTaches == null) {
			lblChoixTaches = new JLabel("Choisissez une tâche :");
			lblChoixTaches.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblChoixTaches.setBounds(32, 73, 138, 29);
		}
		return lblChoixTaches;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.setBounds(179, 131, 89, 23);
		}
		return btnValider;
	}

	private JList getJList() {
		if (jlist == null) {
			jlist = new JList();
			jlist.setBounds(100, 165, 259, 62);
		}
		return jlist;
	}

	public void afficheListeTaches() {
		List<Taches> taches = findAllTaches(); //Création d'une liste avec les users trouvés dans la base 
		System.out.println(taches.size()); //Affiche la taille de la liste
		DefaultComboBoxModel<?> defaultCBModel = new DefaultComboBoxModel<>(taches.toArray());
		getComboTaches().setModel(defaultCBModel);
	}



	private List<Taches> findAllTaches(){

		final List<Taches> taches = new ArrayList<>();//Création d'une liste de users
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(FrameApp.URL, FrameApp.LOGIN, FrameApp.PASSWORD); //Récupére les donnés de connexion
			stmt = con.createStatement();
			String requete = "SELECT * FROM taches"; //Récupère les données de la base 
			System.out.println(requete); //Afiche les données récupérées 
			ResultSet rset = stmt.executeQuery(requete);
			while (rset.next()) {
				final Taches tache = Taches.rsetToTache(rset);
				taches.add(tache); //Ajoute les users dans la liste 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					// Le stmt.close ferme automatiquement le rset.
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return taches;

	}
}
