package mrbs;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblIntitul;
	private JTextField textField_2;
	private JLabel lblCommentaire;
	private JTextField textField_3;
	private JPanel panel_3;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JComboBox comboBox;
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
			panel_2.add(getTextField());
			panel_2.add(getLblNewLabel_1());
			panel_2.add(getTextField_1());
			panel_2.add(getLblIntitul());
			panel_2.add(getTextField_2());
			panel_2.add(getLblCommentaire());
			panel_2.add(getTextField_3());
			panel_2.add(getComboBox_1());
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(91, 10, 138, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("O\u00F9 :");
			lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(52, 45, 29, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(91, 42, 138, 20);
		}
		return textField_1;
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

					String requete = "SELECT name FROM mrbs_users";

				}
			});
			comboBox.setBounds(228, 10, 28, 20);
		}
		return comboBox;
	}
}
