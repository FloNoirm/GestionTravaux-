package mrbs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrameApp extends JFrame {

	public static String URL = "jdbc:mysql://localhost:3306/mrbs?useUnicode=true&serverTimezone=UTC";
	public static String LOGIN = "root";
	public static String PASSWORD = "root";

	private List<String> users;


	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_3;
	private JButton btnValider;
	private JPanel panel_2;
	private JTextField txtMaisonDesLigues;
	private JTextField identifiant;
	private JTextField mdp;
	private JLabel lblNewLabel;
	private JLabel lblMotDePasse;
	private JLabel lblSeConnecter;
	public FrameApp() {
		setSize(new Dimension(800, 800));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fabio\\Pictures\\t\u00E9l\u00E9chargement.png"));
		getContentPane().add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_1(), BorderLayout.NORTH);
			panel.add(getPanel_2_1(), BorderLayout.CENTER);
			panel.add(getPanel_3(), BorderLayout.SOUTH);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getTxtMaisonDesLigues());
		}
		return panel_1;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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

					boolean response = verifIdentification();

					if (response) {
						afficheFrame2();
					}else {

						JOptionPane.showMessageDialog(null, "Erreur de connexion !", "Alerte", JOptionPane.ERROR_MESSAGE);
					}
				}

				private boolean verifIdentification() {
					String Serveur = "localhost";

					String Base = "mrbs";
					String Utilisateur = "root";
					String MotDePasse = "root";


					String connectionURL = "jdbc:mysql://" + Serveur + ":3306/" + Base + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

					Connection conn;
					try {
						conn = DriverManager.getConnection(connectionURL, Utilisateur,
								MotDePasse);

						Statement Execution = conn.createStatement();

						String requete = "SELECT name, password_hash FROM mrbs_users WHERE name='"+ identifiant.getText() +"' AND password_hash=+MD5('"+mdp.getText()+"')";

						ResultSet rs = Execution.executeQuery(requete);

						if(rs.next()) {
							System.out.println(rs.getString("name") +"\n"  + " "+ rs.getString("password_hash")+"\n");

						} else {
							System.out.println("Mdp Faux");
							return false;
						}

						conn.close();


					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					return true;
				}

			});
		}
		return btnValider;
	}




	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setLayout(null);
			panel_2.add(getIdentifiant());
			panel_2.add(getMdp());
			panel_2.add(getLblNewLabel());
			panel_2.add(getLblMotDePasse());
			panel_2.add(getLblSeConnecter());
		}
		return panel_2;
	}
	private JTextField getTxtMaisonDesLigues() {
		if (txtMaisonDesLigues == null) {
			txtMaisonDesLigues = new JTextField();
			txtMaisonDesLigues.setHorizontalAlignment(SwingConstants.CENTER);
			txtMaisonDesLigues.setFont(new Font("Calibri", Font.PLAIN, 20));
			txtMaisonDesLigues.setText(" Maison des ligues");
			txtMaisonDesLigues.setColumns(10);
		}
		return txtMaisonDesLigues;
	}
	private JTextField getIdentifiant() {
		if (identifiant == null) {
			identifiant = new JTextField();
			identifiant.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String requete = "SELECT name FROM mrbs_users";

				}
			});
			identifiant.setBounds(184, 63, 131, 28);
			identifiant.setColumns(10);
		}
		return identifiant;
	}
	private JTextField getMdp() {
		if (mdp == null) {
			mdp = new JTextField();
			mdp.setColumns(10);
			mdp.setBounds(184, 120, 131, 28);
		}
		return mdp;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Identifiant :");
			lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblNewLabel.setBounds(89, 67, 85, 21);
		}
		return lblNewLabel;
	}
	private JLabel getLblMotDePasse() {
		if (lblMotDePasse == null) {
			lblMotDePasse = new JLabel("Mot de passe :");
			lblMotDePasse.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblMotDePasse.setBounds(78, 124, 96, 21);
		}
		return lblMotDePasse;
	}
	private JLabel getLblSeConnecter() {
		if (lblSeConnecter == null) {
			lblSeConnecter = new JLabel("Se Connecter");
			lblSeConnecter.setFont(new Font("Calibri", Font.BOLD, 20));
			lblSeConnecter.setBounds(134, 11, 110, 28);
		}
		return lblSeConnecter;
	}
	private void afficheFrame2() {
		FrameApp2  frame = new FrameApp2();
		frame.afficheListeUsers();
		frame.afficheListeRooms();
		frame.afficheListeResponsables();
		frame.setVisible(true);

	}
}
