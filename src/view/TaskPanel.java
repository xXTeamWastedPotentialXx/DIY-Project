package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Materials;
import model.Tasks;

public class TaskPanel extends JOptionPane{


		/**
		 * 
		 */
		private String myCost;
		private String myName;
		private String myAmount;
		/**
		 * @author Joseph Rushford
		 */
		public TaskPanel() {
			JTextField cost = new JTextField(30);
			JTextField name = new JTextField(30);
			JTextField amount = new JTextField(30);
			JPanel namePan = new JPanel();
			JPanel costPan = new JPanel();
			JPanel amountPan = new JPanel(); 
			namePan.add(new JLabel("Name:"), BorderLayout.WEST);
			namePan.add(name, BorderLayout.EAST);
			costPan.add(new JLabel("Cost:"), BorderLayout.WEST);
			costPan.add(cost, BorderLayout.EAST);
			amountPan.add(new JLabel("Amount:"), BorderLayout.WEST);
			amountPan.add(amount, BorderLayout.EAST);
			JPanel[] settings = new JPanel[2];
			name.setName("Name");
			settings[0] = costPan;
			settings[1] = namePan;
			int confirm = JOptionPane.showConfirmDialog(null, settings, "New Task",  JOptionPane.OK_CANCEL_OPTION);
			if(confirm == JOptionPane.OK_OPTION) {
				myCost = cost.getText();
				myName = name.getText();
				myAmount = amount.getText();
			} else {
				myCost = "No Email Given";
				myName = "No Name Given";
			}
		
		}
		/**
		 * @author Joseph Rushford
		 */
		public Tasks returnTask() {
			Tasks newTask = new Tasks();

			return newTask;
		}

	  }
