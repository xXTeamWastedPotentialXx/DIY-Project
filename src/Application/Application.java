package Application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Project;

public class Application {
	
	private ArrayList<Project> theProjects;
	public Application() {
		theProjects = new ArrayList<Project>();
	}
	
	public void loadProjects(final Scanner theFile) {

	}
	public void addProject(Project theNewProject) {
		theProjects.add(theNewProject);
	}
    



}
