package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Materials;
import model.Project;
import model.Tasks;

public class Application {
	private String myUser;
	private String myEmail;
	private ArrayList<Project> theProjects;
	public Application() {
		theProjects = new ArrayList<Project>();
	}
	
	public void loadProjects(final Scanner theFile) {

	}
	public void addProject(Project theNewProject) {
		theProjects.add(theNewProject);
	}
    
	/**
	 * Parses the (username, email, and) projects from the .csv file.
	 * @return an Application object containing the (username, email, and) projects from the .csv file.
	 */
	public Application loadAllEntries() {
		Application app = new Application();
		try (Scanner scan = new Scanner(csv)) {
			if (scan.hasNext()) {
//				This is here because I'm hoping we'll just save username and email in Application.java because 
//				I think it makes more sense
				String userName = scan.nextLine().split(",")[0];
				String userEmail = scan.nextLine().split(",")[0];
				
				String[] line;
				int projectID;
				String projectName;
				int difficulty;
				int priority;
				boolean ecoFriendly;
				String[] taskList;
				String[] matList;
				ArrayList<Tasks> tasks = new ArrayList<Tasks>();
				ArrayList<Materials> materials = new ArrayList<Materials>();
				
//				Loop that creates Project objects and adds them to app
				while (scan.hasNext()) {
					
//					Parses the basic project info on first line of project
					line = scan.next().split(",");
					projectID = Integer.parseInt(line[0]);
					projectName = line[1];
					difficulty = Integer.parseInt(line[2]);
					priority = Integer.parseInt(line[3]);
					if (Integer.parseInt(line[4]) == 0) {
						ecoFriendly = false;
					} else {
						ecoFriendly = true;
					}
					
//					Parses tasks from second line of project
					if (scan.hasNext()) {
						taskList = scan.next().split(",");
						if (!taskList[0].equals("notasks")) {
							for (int i = 0; i < taskList.length; i += 2) {
								if (Integer.parseInt(taskList[i + 1]) == 1) {
									tasks.add(new Tasks(taskList[i], true));
								} else {
									tasks.add(new Tasks(taskList[i], false));
								}
							}
						} 
					}
					
//					Parses materials from third line of project
					if (scan.hasNext()) {
						matList = scan.next().split(",");
						if (!matList[0].equals("nomaterials")) {
							for (int i = 0; i < matList.length; i += 3) {
								materials.add(new Materials(matList[i], Double.parseDouble(matList[i + 1]), Integer.parseInt(matList[i + 2])));
							}
						}
					}
					
//					Adds project to app and clears tasks & materials to be used for the next project
					app.addProject(new Project(projectID, projectName, difficulty, priority, ecoFriendly, new ArrayList<Tasks>(tasks), new ArrayList<Materials>(materials)));
					tasks.clear();
					materials.clear();
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return app;
	}
	public ArrayList<Project> getProjects() {
		return theProjects;
	}

}
