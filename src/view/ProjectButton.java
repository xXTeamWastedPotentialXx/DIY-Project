package view;

import javax.swing.JButton;

import model.Project;

public class ProjectButton extends JButton {
	
	//The Project the button is built with
	private Project myProject;

	/**
	 * Constructor for the Project Button
	 * @param theProject
	 * @author Miranda Bessex
	 */
	public ProjectButton(Project theProject) {
		super(theProject.toString());
		myProject = theProject;
	
	}
	
	/**
	 * A getter for the project on the button
	 * @author Miranda Bessex
	 */
	public Project getProject() {
		return myProject;
	}

}
