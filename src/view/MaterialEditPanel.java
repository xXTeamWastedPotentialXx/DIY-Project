package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Application.Application;
import model.Materials;

public class MaterialEditPanel extends JOptionPane{

	private static final long serialVersionUID = 1L;
	
	/** The cost of the material being edited */
	private String myCost;
	
	/**The name of the material being edited */
	private String myName;
	
	/**The amount of the material being edited */
	private String myAmount;
	
	/**The reference to the AddPage */
	private AddPage myAddPage;
	
	/**
	 * Constructor for the material edit Panel
	 * @param theName
	 * @param theCost
	 * @param theQuantity
	 * @author Miranda Bessex
	 */
	public MaterialEditPanel(String theName, String theCost, String theQuantity, AddPage theAddPage) {
		
		myAddPage = theAddPage;
		
		JTextField cost = new JTextField(30);
		JTextField name = new JTextField(30);
		JTextField amount = new JTextField(30);
		
		JButton myDeleteButton = new JButton("Delete");
		
		myDeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myAddPage.deleteMaterial(new Materials(theName, 0, 0));
				
			}
			
		});
		
		name.setText(theName);
		//Set it to disabled. Once a name has been added it cannot be changed only deleted
		//Need to keep it this way because the add page will test based off of name for the replacement material
		name.setEnabled(false);
		cost.setText(theCost);
		amount.setText(theQuantity);
		
		JPanel namePan = new JPanel();
		JPanel costPan = new JPanel();
		JPanel amountPan = new JPanel(); 
		
		namePan.add(new JLabel("Name:"), BorderLayout.WEST);
		namePan.add(name, BorderLayout.EAST);
		costPan.add(new JLabel("Cost:"), BorderLayout.WEST);
		costPan.add(cost, BorderLayout.EAST);
		amountPan.add(new JLabel("Quantity:"), BorderLayout.WEST);
		amountPan.add(amount, BorderLayout.EAST);
		amountPan.add(myDeleteButton, BorderLayout.SOUTH);
		
		JPanel[] settings = new JPanel[3];
		name.setName("Name");
		settings[1] = costPan;
		settings[0] = namePan;
		settings[2] = amountPan;
		
		int confirm = JOptionPane.showConfirmDialog(null, settings, "Edit Material",  JOptionPane.OK_CANCEL_OPTION);
		if(confirm == JOptionPane.OK_OPTION) {
			myCost = cost.getText();
			myName = name.getText();
			myAmount = amount.getText();
			myAddPage.addMaterial(new Materials(myName, Double.parseDouble(myCost), Integer.parseInt(myAmount)));
			
		} else {
			myCost = "invalid input";
			myName = "No Name Given";
			myAmount = "invalid input";
		}
	
	}
	/**
	 * @author Joseph Rushford
	 */
	public Materials returnMat() {
		Materials newMat = new Materials("invalid", (double) -1, 0);
		try {
			newMat = new Materials(myName, Double.parseDouble(myCost), Integer.parseInt(myAmount));
		} catch(NumberFormatException e) {
			
		}
		return newMat;
	}

  }


