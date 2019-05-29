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

			namePan.add(new JLabel("Name:"), BorderLayout.WEST);
			namePan.add(name, BorderLayout.EAST);

			JPanel[] settings = new JPanel[2];
			name.setName("Name");

			settings[0] = namePan;
			int confirm = JOptionPane.showConfirmDialog(null, settings, "New Task",  JOptionPane.OK_CANCEL_OPTION);
			if(confirm == JOptionPane.OK_OPTION) {

				myName = name.getText();
			} else {
				myName = "No Name Given";
			}
		
		}
		/**
		 * @author Joseph Rushford
		 */
		public Tasks returnTask() {
			Tasks newTask = new Tasks(myName);

			return newTask;
		}

	  }
