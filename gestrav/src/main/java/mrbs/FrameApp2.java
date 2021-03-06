package mrbs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import mrbs.model.Rooms;
import mrbs.model.Users;

public class FrameApp2 extends JFrame {


	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblQui;
	private JLabel lblNewLabel_1;
	private JLabel lblIntitul;
	private JTextField SaisieIntitule;
	private JLabel lblCommentaire;
	private JTextField SaisieCom;
	private JPanel panel_3;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JComboBox comboQui;
	private JComboBox comboOU;
	private JLabel lblPriorit;
	private JTextField SaisiePrioTextField;
	private JComboBox comboResp;
	private JLabel lblResponsable;
	public FrameApp2() {
		setSize(new Dimension(800, 800));
		setMinimumSize(new Dimension(400, 300));
		getContentPane().add(getPanel(), BorderLayout.CENTER);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_1(), BorderLayout.NORTH);
			panel.add(getPanel_2(), BorderLayout.CENTER);
			panel.add(getPanel_3(), BorderLayout.SOUTH);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblNewLabel());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getLblQui());
			panel_2.add(getLblNewLabel_1());
			panel_2.add(getLblIntitul());
			panel_2.add(getSaisieIntitule());
			panel_2.add(getLblCommentaire());
			panel_2.add(getSaisieCom());
			panel_2.add(getComboQui());
			panel_2.add(getComboOU());
			panel_2.add(getLblPriorit());
			panel_2.add(getSaisiePrioTextField());
			panel_2.add(getComboResp());
			panel_2.add(getLblResponsable());
		}
		return panel_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Demande de travaux");
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		}
		return lblNewLabel;
	}
	private JLabel getLblQui() {
		if (lblQui == null) {
			lblQui = new JLabel("Qui :");
			lblQui.setBounds(88, 16, 45, 22);
			lblQui.setFont(new Font("Calibri", Font.PLAIN, 20));
		}
		return lblQui;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("O\u00F9 :");
			lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(88, 67, 45, 22);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblIntitul() {
		if (lblIntitul == null) {
			lblIntitul = new JLabel("Intitul\u00E9 :");
			lblIntitul.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblIntitul.setBounds(75, 109, 58, 14);
		}
		return lblIntitul;
	}
	private JTextField getSaisieIntitule() {
		if (SaisieIntitule == null) {
			SaisieIntitule = new JTextField();
			SaisieIntitule.setBounds(148, 102, 210, 33);
			SaisieIntitule.setColumns(10);
		}
		return SaisieIntitule;
	}
	private JLabel getLblCommentaire() {
		if (lblCommentaire == null) {
			lblCommentaire = new JLabel("Commentaire: ");
			lblCommentaire.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblCommentaire.setBounds(63, 235, 102, 14);

		}
		return lblCommentaire;
	}
	private JTextField getSaisieCom() {
		if (SaisieCom == null) {
			SaisieCom = new JTextField();
			SaisieCom.setBounds(62, 265, 398, 78);
			SaisieCom.setColumns(10);
		}
		return SaisieCom;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getBtnAnnuler());
			panel_3.add(getBtnValider());
		}
		return panel_3;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ajouterTache();
				}

			});
		}
		return btnValider;
	}

	private void ajouterTache(){	
		Users user = (Users)getComboQui().getSelectedItem();
		Rooms room = (Rooms)getComboOU().getSelectedItem();
		String intitule = getSaisieIntitule().getText();
		int priorite = Integer.valueOf(getSaisiePrioTextField().getText());
		Users responsable = (Users)getComboResp().getSelectedItem();
		String commentaire = getSaisieCom().getText();

		System.out.println(user.toString() + room.toString() + intitule + priorite + responsable.toString() + commentaire);

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection(FrameApp.URL, FrameApp.LOGIN, FrameApp.PASSWORD); //Récupére les donnés de connection
			String requete= "INSERT INTO taches (mrbs_users_id,mrbs_room_id,nomTache,priorite_tache,responsable,com_tache) VALUES "+
					" (?,?,?,?,?,?)"; 

			stmt = con.prepareStatement(requete);


			stmt.setInt(1, user.getIdentifiant());
			stmt.setInt(2, room.getIdentifiant());
			stmt.setString(3, intitule);
			stmt.setInt(4, priorite);
			stmt.setInt (5, responsable.getIdentifiant());
			stmt.setString(6, commentaire);

			stmt.executeUpdate();
		}  catch (SQLException e) {
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
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					SaisieIntitule.setText("");
					SaisiePrioTextField.setText("");
					SaisieCom.setText("");

				}
			});
			btnAnnuler.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return btnAnnuler;
	}
	private JComboBox getComboQui() {
		if (comboQui == null) {
			comboQui = new JComboBox();
			comboQui.setBounds(148, 10, 210, 33);
		}
		return comboQui;
	}



	private JComboBox getComboOU() {
		if (comboOU == null) {
			comboOU = new JComboBox();
			comboOU.setBounds(148, 61, 210, 33);
		}
		return comboOU;

	}


	private List<Rooms> findAllRooms(){

		final List<Rooms> rooms = new ArrayList<>();//Création d'une liste de users
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(FrameApp.URL, FrameApp.LOGIN, FrameApp.PASSWORD); //Récupére les donnés de connection
			stmt = con.createStatement();
			String requete = "SELECT * FROM mrbs_room"; //Récupère les données de la base 
			System.out.println(requete); //Afiche les données récupérées 
			ResultSet rset = stmt.executeQuery(requete);
			while (rset.next()) {
				final Rooms room = Rooms.rsetToRoom(rset);
				rooms.add(room); //Ajoute les users dans la liste 
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
		return rooms;

	}


	public List<Users> findAllUser() {
		final List<Users> users = new ArrayList<>();//Création d'une liste de users
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(FrameApp.URL, FrameApp.LOGIN, FrameApp.PASSWORD); //Récupére les donnés de connection
			stmt = con.createStatement();
			String requete = "SELECT * FROM mrbs_users"; //Récupère les données de la base 
			System.out.println(requete); //Afiche les données récupérées 
			ResultSet rset = stmt.executeQuery(requete);
			while (rset.next()) {
				final Users user = Users.rsetToUser(rset);
				users.add(user); //Ajoute les users dans la liste 
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
		return users;
	}


	public void afficheListeUsers() {
		List<Users> users = findAllUser(); //Création d'une liste avec les users trouvés dans la base 
		System.out.println(users.size()); //Affiche la taille de la liste
		DefaultComboBoxModel<?> defaultCBModel = new DefaultComboBoxModel<>(users.toArray());
		getComboQui().setModel(defaultCBModel);
	}

	public void afficheListeRooms() {
		List<Rooms> rooms = findAllRooms(); //Création d'une liste avec les salles trouvées dans la base 
		System.out.println(rooms.size()); //Affiche la taille de la liste
		DefaultComboBoxModel<?> defaultCBModel = new DefaultComboBoxModel<>(rooms.toArray());
		getComboOU().setModel(defaultCBModel);
	}

	public void afficheListeResponsables() {
		List<Users> users = findAllUser(); //Création d'une liste avec les users trouvés dans la base 
		System.out.println(users.size()); //Affiche la taille de la liste
		DefaultComboBoxModel<?> defaultCBModel = new DefaultComboBoxModel<>(users.toArray());
		getComboResp().setModel(defaultCBModel);
	}

	private JLabel getLblPriorit() {
		if (lblPriorit == null) {
			lblPriorit = new JLabel("Priorité: ");
			lblPriorit.setBounds(75, 147, 69, 20);
		}
		return lblPriorit;
	}
	private JTextField getSaisiePrioTextField() {
		if (SaisiePrioTextField == null) {
			SaisiePrioTextField = new JTextField();
			SaisiePrioTextField.setBounds(148, 151, 210, 33);
			SaisiePrioTextField.setColumns(10);
		}
		return SaisiePrioTextField;
	}
	private JComboBox getComboResp() {
		if (comboResp == null) {
			comboResp = new JComboBox();
			comboResp.setBounds(148, 190, 210, 36);
		}
		return comboResp;
	}
	private JLabel getLblResponsable() {
		if (lblResponsable == null) {
			lblResponsable = new JLabel("Responsable:");
			lblResponsable.setBounds(37, 183, 102, 36);
		}
		return lblResponsable;
	}
}
