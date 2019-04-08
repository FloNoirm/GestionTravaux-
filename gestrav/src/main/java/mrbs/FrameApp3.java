package mrbs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameApp3 extends JFrame {
	private JPanel panel;
	private JComboBox comboTaches;
	private JLabel lblChoixTaches;
	private JButton btnValider;
	private JLabel lblDateDeDbut;
	private JLabel lblDateDeFin;
	private JLabel lblPrioritDeLa;
	private JLabel lblSalle;
	private JTextField txtFDateDebut;
	private JTextField txtFDateFin;
	private JTextField txtFPriorite;
	private JTextField txtFSalle;

	public FrameApp3() throws HeadlessException {
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		setSize(new Dimension(800, 800));
	}


	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getComboTaches());
			panel.add(getLblChoixTaches());
			panel.add(getBtnValider());
			panel.add(getLblDateDeDbut());
			panel.add(getLblDateDeFin());
			panel.add(getLblPrioritDeLa());
			panel.add(getLblSalle());
			panel.add(getTxtFDateDebut());
			panel.add(getTxtFDateFin());
			panel.add(getTxtFPriorite());
			panel.add(getTxtFSalle());
		}
		return panel;
	}
	private JComboBox getComboTaches() {
		if (comboTaches == null) {
			comboTaches = new JComboBox();
			comboTaches.setSize(138, 20);
			comboTaches.setLocation(new Point(193, 37));
		}
		return comboTaches;
	}
	private JLabel getLblChoixTaches() {
		if (lblChoixTaches == null) {
			lblChoixTaches = new JLabel("Choisissez une tâche :");
			lblChoixTaches.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblChoixTaches.setBounds(45, 33, 138, 29);
		}
		return lblChoixTaches;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					afficherDonneesTaches();

				}


			});
			btnValider.setBounds(193, 68, 89, 23);
		}
		return btnValider;
	}

	private void afficherDonneesTaches() {
		Taches tacheSelectionner=(Taches) getComboTaches().getSelectedItem();
		System.out.println(tacheSelectionner.getNomTache());
		txtFDateDebut.setText(tacheSelectionner.getDate_debut().toString());
		txtFDateFin.setText(tacheSelectionner.getDate_fin().toString());
		txtFPriorite.setText(tacheSelectionner.getPrioriteLibelle());
		txtFSalle.setText(tacheSelectionner.getLibelleSalle());
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
	private JLabel getLblDateDeDbut() {
		if (lblDateDeDbut == null) {
			lblDateDeDbut = new JLabel("Date de début :");
			lblDateDeDbut.setBounds(89, 115, 82, 20);
		}
		return lblDateDeDbut;
	}
	private JLabel getLblDateDeFin() {
		if (lblDateDeFin == null) {
			lblDateDeFin = new JLabel("Date de fin :");
			lblDateDeFin.setBounds(99, 146, 72, 20);
		}
		return lblDateDeFin;
	}
	private JLabel getLblPrioritDeLa() {
		if (lblPrioritDeLa == null) {
			lblPrioritDeLa = new JLabel("Priorité de la tache :");
			lblPrioritDeLa.setBounds(67, 177, 103, 24);
		}
		return lblPrioritDeLa;
	}
	private JLabel getLblSalle() {
		if (lblSalle == null) {
			lblSalle = new JLabel("Salle :");
			lblSalle.setBounds(132, 208, 39, 20);
		}
		return lblSalle;
	}
	private JTextField getTxtFDateDebut() {
		if (txtFDateDebut == null) {
			txtFDateDebut = new JTextField();
			txtFDateDebut.setBounds(193, 115, 138, 20);
			txtFDateDebut.setColumns(10);
		}
		return txtFDateDebut;
	}
	private JTextField getTxtFDateFin() {
		if (txtFDateFin == null) {
			txtFDateFin = new JTextField();
			txtFDateFin.setBounds(193, 146, 138, 20);
			txtFDateFin.setColumns(10);
		}
		return txtFDateFin;
	}
	private JTextField getTxtFPriorite() {
		if (txtFPriorite == null) {
			txtFPriorite = new JTextField();
			txtFPriorite.setBounds(193, 179, 138, 20);
			txtFPriorite.setColumns(10);
		}
		return txtFPriorite;
	}
	private JTextField getTxtFSalle() {
		if (txtFSalle == null) {
			txtFSalle = new JTextField();
			txtFSalle.setBounds(193, 208, 138, 20);
			txtFSalle.setColumns(10);
		}
		return txtFSalle;
	}
}
