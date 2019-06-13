package view;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.Materials;
import model.Tasks;

public class TaskEditPanel extends JOptionPane{
	
	/**The state of the Task being edited */
	private boolean myState;
	
	/**The name of the Task being edited */
	private String myName;
	
	/**The reference to the AddPage */
	private AddPage myAddPage;
	
	
	/**
	 * Constructor for the Task edit panel that will pop up when a user wants to edit a task
	 * @author Miranda Bessex 6/12/19
	 */
	public TaskEditPanel(String Description, boolean State, AddPage theAddPage) {

		myAddPage = theAddPage;
		
		JTextField name = new JTextField(30);
		JCheckBox status = new JCheckBox("Completed");
		
		JButton myDeleteButton = new JButton("Delete");
		myDeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myAddPage.deleteTask(new Tasks(Description, false));
				Window w = SwingUtilities.getWindowAncestor(myDeleteButton);

			    if (w != null) {
			      w.setVisible(false);
			    }
			}
			
		});
		
		name.setText(Description);
		
		JPanel namePan = new JPanel();
		JPanel statusPan = new JPanel();
		
		statusPan.add(status, BorderLayout.WEST);
		statusPan.add(myDeleteButton, BorderLayout.EAST);
		namePan.add(new JLabel("Name:"), BorderLayout.WEST);
		namePan.add(name, BorderLayout.EAST);
		
		JPanel[] settings = new JPanel[2];
		name.setName("Name");
		
		settings[0] = namePan;
		settings[1] = statusPan;
		
		int confirm = JOptionPane.showConfirmDialog(null, settings, "Edit Task",  JOptionPane.OK_CANCEL_OPTION);
		
		if(confirm == JOptionPane.OK_OPTION) {
			myState = status.isSelected();
			myName = name.getText();
			myAddPage.addTasks(new Tasks(myName, myState));
		} else if(confirm == JOptionPane.CANCEL_OPTION){
			myState = State;
			myName = Description;
			myAddPage.addTasks(new Tasks(myName, myState));
		}else {
			myName = "No Name Given";
			myState = false;
		}
	
	}
	/**
	 * @author Joseph Rushford 6/3/19
	 */
	public Tasks returnTask() {
		Tasks newTask = new Tasks(myName, myState);
		return newTask;
	}
}

