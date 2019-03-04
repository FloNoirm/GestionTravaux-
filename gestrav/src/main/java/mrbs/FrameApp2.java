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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameApp2 extends JFrame {

	private static String URL = "jdbc:mysql://localhost:3306/mrbs?useUnicode=true&serverTimezone=UTC";
	private static String LOGIN = "root";
	private static String PASSWORD = "root";


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
	private JComboBox comboBox;
	private JComboBox comboBox_1;
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
			panel_2.add(getComboBox_1());
			panel_2.add(getComboBox_1_1());
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

					String requete = "INSERT INTO # FROM # ";

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
	private JComboBox getComboBox_1() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					List<String> users = findAllUser();
					System.out.println(users.size());
					// alimenter la combo
				}


			});
			comboBox.setBounds(113, 10, 116, 20);
		}
		return comboBox;
	}

	public List<String> findAllUser() {
		final List<String> users = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = con.createStatement();
			String requete = "SELECT name FROM mrbs_users";
			System.out.println(requete);
			ResultSet rset = stmt.executeQuery(requete);
			while (rset.next()) {
				users.add(rset.getString("name"));
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

	private JComboBox getComboBox_1_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(113, 42, 116, 20);
		}
		return comboBox_1;

	}

	public void refresh() {
		Object[] requete = new Object[]{"Element 1", "Element 2", "Element 3", "Element 4", "Element 5"};

		// ,  getComboBox_1_1().setModel(new ComboBoxModel<?>(elements));
	}
}
