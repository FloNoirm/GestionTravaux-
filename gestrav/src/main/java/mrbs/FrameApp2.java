package mrbs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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

public class FrameApp2 extends JFrame {


	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblQui;
	private JLabel lblNewLabel_1;
	private JLabel lblIntitul;
	private JTextField textField_2;
	private JLabel lblCommentaire;
	private JTextField textField_3;
	private JPanel panel_3;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JComboBox comboQui;
	private JComboBox comboOU;
	public FrameApp2() {
		setSize(new Dimension(400, 300));
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
			panel_2.add(getTextField_2());
			panel_2.add(getLblCommentaire());
			panel_2.add(getTextField_3());
			panel_2.add(getComboQui());
			panel_2.add(getComboOU());
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
			lblQui.setBounds(52, 11, 29, 19);
			lblQui.setFont(new Font("Calibri", Font.PLAIN, 15));
		}
		return lblQui;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("O\u00F9 :");
			lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(52, 45, 29, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblIntitul() {
		if (lblIntitul == null) {
			lblIntitul = new JLabel("Intitul\u00E9 :");
			lblIntitul.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblIntitul.setBounds(52, 75, 58, 14);
		}
		return lblIntitul;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(113, 73, 116, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblCommentaire() {
		if (lblCommentaire == null) {
			lblCommentaire = new JLabel("Commentaire :");
			lblCommentaire.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblCommentaire.setBounds(52, 100, 102, 14);
		}
		return lblCommentaire;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(52, 125, 331, 51);
			textField_3.setColumns(10);
		}
		return textField_3;
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
					// alimenter la combo
				}

			});
		}
		return btnValider;
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return btnAnnuler;
	}
	private JComboBox getComboQui() {
		if (comboQui == null) {
			comboQui = new JComboBox();
			comboQui.setBounds(113, 10, 116, 20);
		}
		return comboQui;
	}



	private JComboBox getComboOU() {
		if (comboOU == null) {
			comboOU = new JComboBox();
			comboOU.setBounds(113, 42, 116, 20);
		}
		return comboOU;

	}

	public void refresh() {
		Object[] requete = new Object[]{"Element 1", "Element 2", "Element 3", "Element 4", "Element 5"};

		// ,  getComboBox_1_1().setModel(new ComboBoxModel<?>(elements));
	}

	private List<String> findAllRooms(){

		final List<String> rooms = new ArrayList<String>();//Création d'une liste de users
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(FrameApp.URL, FrameApp.LOGIN, FrameApp.PASSWORD); //Récupére les donnés de connection
			stmt = con.createStatement();
			String requete = "SELECT room_name FROM mrbs_room"; //Récupère les données de la base 
			System.out.println(requete); //Afiche les données récupérées 
			ResultSet rset = stmt.executeQuery(requete);
			while (rset.next()) {
				rooms.add(rset.getString("room_name")); //Ajoute les users dans la liste 
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


	public List<String> findAllUser() {
		final List<String> users = new ArrayList<String>();//Création d'une liste de users
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(FrameApp.URL, FrameApp.LOGIN, FrameApp.PASSWORD); //Récupére les donnés de connection
			stmt = con.createStatement();
			String requete = "SELECT name FROM mrbs_users"; //Récupère les données de la base 
			System.out.println(requete); //Afiche les données récupérées 
			ResultSet rset = stmt.executeQuery(requete);
			while (rset.next()) {
				users.add(rset.getString("name")); //Ajoute les users dans la liste 
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
		List<String> users = findAllUser(); //Création d'une liste avec les users trouvés dans la base 
		System.out.println(users.size()); //Affiche la taille de la liste
		DefaultComboBoxModel<?> defaultCBModel = new DefaultComboBoxModel<>(users.toArray());
		getComboQui().setModel(defaultCBModel);
	}

	public void afficheListeRooms() {
		List<String> rooms = findAllRooms(); //Création d'une liste avec les users trouvés dans la base 
		System.out.println(rooms.size()); //Affiche la taille de la liste
		DefaultComboBoxModel<?> defaultCBModel = new DefaultComboBoxModel<>(rooms.toArray());
		getComboOU().setModel(defaultCBModel);
	}

}
