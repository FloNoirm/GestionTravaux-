package mrbs;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class FrameApp3 extends JFrame {
	private JPanel panel;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JButton btnValider;
	private JList jlist;

	public FrameApp3() throws HeadlessException {
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		// TODO Auto-generated constructor stub
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
			panel.add(getComboBox());
			panel.add(getLblNewLabel());
			panel.add(getBtnValider());
			panel.add(getJList());
		}
		return panel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setSize(138, 20);
			comboBox.setLocation(new Point(150, 100));
		}
		return comboBox;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Choisissez une tâche :");
			lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel.setBounds(150, 60, 138, 29);
		}
		return lblNewLabel;
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
}
