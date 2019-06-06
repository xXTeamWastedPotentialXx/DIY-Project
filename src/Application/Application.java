package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Materials;
import model.Project;
import model.Tasks;

/*
 * Notes:
 * - Operates under the assumption that projectIDs will be in order, starting at 1.
 * - Not made to handle invalid formatting of .csv
 * 				
 * Example structure of .csv file:
 * 
 * - For all boolean values, I used 0 for false and 1 for true.
 * - If a project has no tasks, the task line will just say "notasks"; same for materials but "nomaterials" instead. I did this just for simplicity in the parsing algorithm.
 * 
 * |------------------------------------------------------------------------------------------------------------------------|
 * |username		|																										|
 * |------------------------------------------------------------------------------------------------------------------------|
 * |email			|																										|
 * |------------------------------------------------------------------------------------------------------------------------|
 * |project ID		| project name						| difficulty					| priority	| theStatus (0 or 1)	|
 * |------------------------------------------------------------------------------------------------------------------------|
 * |task 1 name		| task 1 completed or not (0 or 1)	| (repeat for remaining tasks)										|
 * |------------------------------------------------------------------------------------------------------------------------|
 * |material 1 name	| material 1 cost					| material 1 quantity			| (repeat for remaining materials)	|
 * |------------------------------------------------------------------------------------------------------------------------|
 * |(repeat for remaining projects) 																						|
 * |------------------------------------------------------------------------------------------------------------------------|
 */

/**
 * Class that holds username, email, and projects and handles the .csv file where it's all stored.
 * @author (whoever worked on this class originally, idk)
 * @author Jacob Marquardt
 *
 */
public class Application {
	
	private String username;
	
	private String userEmail;
	
	private ArrayList<Project> theProjects;
	
	private File csv;
	
	public Application() {
		theProjects = new ArrayList<Project>();
	}
	
	/**
	 * 
	 * @param theCsv
	 * @author Jacob Marquardt
	 */
	public Application(final File theCsv) {
		theProjects = new ArrayList<Project>();
		csv = theCsv;
	}
	
	/**
	 * Leaving this here for now just so that HomePage isn't broken
	 * @param theFile
	 */
	public void loadProjects(final Scanner theFile) {

	}

	/**
	 * Adds a new project to theProjects or replaces an existing project depending on Project ID and updates csv accordingly.
	 * @param theNewProject
	 * @author Jacob Marquardt
	 */
	public void addProject(final Project theNewProject) {
		if (theNewProject.getProjectID() > theProjects.size()) {
			theProjects.add(theNewProject);	
		} else {
			theProjects.remove(theNewProject.getProjectID() - 1);
			theProjects.add(theNewProject.getProjectID() - 1, theNewProject);
		}
		write();
	}
	
	/**
	 * Removes project with the specified ID from theProjects, updates following project IDs to keep ordering correct, and updates csv accordingly.
	 * @param projectID
	 * @author Jacob Marquardt
	 */
	public void deleteProject(final int projectID) {
		theProjects.remove(projectID - 1);
		for (int i = projectID - 1; i < theProjects.size(); i++) {
			theProjects.get(i).setProjectID(theProjects.get(i).getProjectID() - 1);
		}
		write();
	}
		
	public void loadAllEntries() {
		loadAllEntries(csv);
	}
	
	/**
	 * Parses the username, email, and projects from a .csv file.
	 * @param theCsv the .csv file being parsed
	 * @author Jacob Marquardt
	 */
	public void loadAllEntries(final File theCsv) {
		try (Scanner scan = new Scanner(theCsv);) {
			if (scan.hasNext()) {
//				Clearing existing projects because they'll be overwritten
				theProjects.clear();

				username = scan.nextLine().split(",")[0];
				userEmail = scan.nextLine().split(",")[0];
				
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
					theProjects.add(new Project(projectID, projectName, difficulty, priority, ecoFriendly, new ArrayList<Tasks>(tasks), new ArrayList<Materials>(materials)));
					tasks.clear();
					materials.clear();
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes all current application info to csv.
	 * @author Jacob Marquardt
	 */
	private void write() {
		try (FileWriter writer = new FileWriter(csv);) {
			StringBuilder str = new StringBuilder();
//			Add username and email
			str.append(username).append("\n");
			str.append(userEmail).append("\n");
//			Iterate over all projects
			for (Project p : theProjects) {
//				Add ID, name, difficulty, priority, and 1 or 0 if environmentally friendly or not respectively
				str.append(p.getProjectID()).append(",");
				str.append(p.getProjectName()).append(",");
				str.append(p.getDifficultly()).append(",");
				str.append(p.getPriority()).append(",");
				if (p.getEnviromentallyFriendly()) {
					str.append(1);
				} else {
					str.append(0);
				}
				str.append("\n");
//				Add tasks if there are any, or "notasks" if there are not
				if (p.getTasks().size() >= 1) {
//					Iterate over every task in current project
					for (Tasks t : p.getTasks()) {
//						Add name, and 1 or 0 if completed or not respectively
						str.append(t.getName()).append(",");
						if (t.isCompleted()) {
							str.append(1);
						} else {
							str.append(0);
						}
						str.append(",");
					}
				} else {
					str.append("notasks");
				}
				str.append("\n");
//				Add materials if there are any, or "nomaterials" if there are not
				if (p.getMaterials().size() >= 1) {
//					Iterate over over material in current project
					for (Materials m : p.getMaterials()) {
//						Add name, cost, and quantity
						str.append(m.getName()).append(",");
						str.append(m.getCost()).append(",");
						str.append(m.getQuantity()).append(",");
					}
				} else {
					str.append("nomaterials");
				}
				str.append("\n");
			}
//			Write it all to csv
			writer.write(str.toString());
			writer.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
		
	/*
	 * Getters.
	 */
    
	/**
	 * Getter for theProjects.
	 * @return theProjects
	 * @author Jacob Marquardt
	 */
	public ArrayList<Project> getProjects() {
		return theProjects;
	}
	
	/**
	 * Getter for username.
	 * @return username
	 * @author Jacob Marquardt
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Getter for userEmail.
	 * @return userEmail
	 * @author Jacob Marquardt
	 */
	public String getUserEmail() {
		return userEmail;
	}
	
	/**
	 * Getter for csv
	 * @return csv
	 * @author Jacob Marquardt
	 */
	public File getCsv() {
		return csv;
	}
	
	/*
	 * Setters.
	 */
	
	/**
	 * Changes username to the argument passed and updates csv accordingly.
	 * @param theUsername
	 * @author Jacob Marquardt
	 */
	public void setUsername(final String theUsername) {
		username = theUsername;
		write();
	}
	
	/**
	 * Changes userEmail to the argument passed and updates csv accordingly.
	 * @param theUserEmail
	 * @author Jacob Marquardt
	 */
	public void setUserEmail(final String theUserEmail) {
		userEmail = theUserEmail;
		write();
	}
	
	/**
	 * toString for testing purposes.
	 * @author Jacob Marquardt
	 */
	public String toString() {
		StringBuilder out = new StringBuilder(String.format("Username: %s\tEmail: %s\n", username, userEmail));
		for (Project p : theProjects) {
			out.append(p.toString()).append("\n");
		}
		return out.toString();
	}
}