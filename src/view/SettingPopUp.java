package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingPopUp extends JOptionPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String myEmail;
	private String myName;
	
	public SettingPopUp(String theEmail, String theName) {
		JTextField email = new JTextField(30);
		JTextField name = new JTextField(30);
		JPanel namePan = new JPanel();
		JPanel mailPan = new JPanel();
		email.setText(theEmail);
		name.setText(theName);
		namePan.add(new JLabel("Name:"), BorderLayout.WEST);
		namePan.add(name, BorderLayout.EAST);
		mailPan.add(new JLabel("Email:"), BorderLayout.WEST);
		mailPan.add(email, BorderLayout.EAST);
		JPanel[] settings = new JPanel[2];
		name.setName("Name");
		settings[0] = mailPan;
		settings[1] = namePan;
		int confirm = JOptionPane.showConfirmDialog(null, settings, "Settings",  JOptionPane.OK_CANCEL_OPTION);
		if(confirm == JOptionPane.OK_OPTION) {
			myEmail = email.getText();
			myName = name.getText();
		} else {
			myEmail = "No Email Given";
			myName = "No Name Given";
		}
	
	}
	
	public String getEmail() {
		return myEmail;
		
	}
	public String getName() {
		return myName;
	}
}
