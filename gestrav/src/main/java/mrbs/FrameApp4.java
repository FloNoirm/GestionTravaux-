package mrbs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class FrameApp4 extends JFrame {


	private class TacheTableModel extends AbstractTableModel{
		String  title[] = {"Nom de la Tache", "Etat"};
		@Override
		public int getRowCount() {
			return tachesList.size();
			// return 10;
		}

		@Override
		public int getColumnCount() {

			return title.length;
			// return 5;
		}



		@Override
		public String getColumnName(int column) {
			return title[column];
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				return tachesList.get(rowIndex).getNomTache();

			} else {
				return tachesList.get(rowIndex).getLibelleEtat();
			}

		}

	}

	List<Taches> tachesList;
	TacheTableModel tableTacheModel = new TacheTableModel();
	private JPanel panel;
	private JTable jtable;

	public JTable getJtable() {
		if (jtable == null ) {
			jtable = new JTable();
			jtable.setLayout(null);
			jtable.setModel(tableTacheModel);
		}
		return jtable;
	}

	public FrameApp4() throws HeadlessException {
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		setSize(new Dimension(800, 800));

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));

			JScrollPane jscrollPane = new JScrollPane(getJtable());
			panel.add(jscrollPane);

		}
		return panel;

	}

	public void afficheListeTaches() {
		tachesList = findAllTaches(); //Création d'une liste avec les users trouvés dans la base 
		System.out.println(tachesList.size()); //Affiche la taille de la liste
		tableTacheModel.fireTableDataChanged();
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

