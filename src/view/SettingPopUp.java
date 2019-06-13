package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingPopUp extends JOptionPane {
	/**
	 * Class to represent the pop up window for displaying the current person logged in to the application
	 * @author Miranda Bessex
	 * @author Gehry Guest
	 * @author Joeseph Rushford
	 */
	private static final long serialVersionUID = 1L;
	
	/** The email of the user */
	private String myEmail;
	
	/** The username of the user */
	private String myName;
	
	
	/**
	 * Constructor for the pop up settings window
	 * @param theEmail
	 * @param theName
	 * @author Miranda Bessex
	 */
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
		
		//If they select ok then overwrite the values
		if(confirm == JOptionPane.OK_OPTION) {
			myEmail = email.getText();
			myName = name.getText();
		
		//If they select cancel then do not overwrite the values
		}else if(confirm == JOptionPane.CANCEL_OPTION) {
			myEmail = theEmail;
			myName = theName;
		}
	}
	
	public String getEmail() {
		return myEmail;
		
	}
	public String getName() {
		return myName;
	}
}
