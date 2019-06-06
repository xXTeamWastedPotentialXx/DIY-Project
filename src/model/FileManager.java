package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Application.Application;

/*
 * Notes:
 * - Operates under the assumption that projectIDs will be in order, starting at 1.
 * - Not made to handle invalid formatting of .csv
 * - Things I added to make it work: 
 * 		- Tasks.java : added getters, added a constructor that takes isCompleted as an argument
 * 
 * 				public Tasks(final String theName, final boolean isCompleted){
					name = theName;
					completed = isCompleted;
				}
				
				public String getName() {
					return name;
				}
				
				public boolean isCompleted() {
					return completed;
				}
 * 
 * 		- Project.java : added projectID field, added seperate constructor that's identical but takes a projectID argument, added a toString that I used to test this class (not needed)
 * 
 * 				private int projectID;
 * 
 * 				public Project(int theProjectID, String theName, int theDifficulty, int thePriorty, boolean theStatus,
					ArrayList<Tasks> theTasks, ArrayList<Materials> theMats) {
	
					projectID = theProjectID;
				    
				    enviromentallyFriendly = theStatus;
				    
				    difficultly = theDifficulty;
				    
				    priorityOfProject = thePriorty;
				    projectName = theName;
				    myTasks = theTasks;
				    myMaterials = theMats;
				}
				
				
 * 		- Application.java : added a getter so I could access the projects in this class
 * 
 * 				public ArrayList<Project> getProjects() {
					return theProjects;
				}
 * 
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
 * Class that handles updating/reading from the csv file we'll use to store all the application info
 * @author Jacob Marquardt
 * @version 5/30/19
 */
public class FileManager {
	
	private File csv;
	
	public FileManager(File theFile) {
		csv = theFile;
	}
		
	/**
	 * Either adds a new project to csv or edits an existing project based on Project ID
	 * @param theProject the project being added/edited.
	 */
	public void addEntry(Project theProject) {
		try {
			Scanner scan = new Scanner(csv);
			int projectID = theProject.getProjectID();
			StringBuilder projectToAdd = new StringBuilder();
			
//			Skipping to project to be edited or skipping to the end if adding
			for (int i = 1; i < projectID * 3; i++) {
				projectToAdd.append(scan.nextLine()).append("\n");
			}
			
//			Adding basic project info
			projectToAdd.append(theProject.getProjectID()).append(",");
			projectToAdd.append(theProject.getProjectName()).append(",");
			projectToAdd.append(theProject.getDifficultly()).append(",");
			projectToAdd.append(theProject.getPriority()).append(",");
			if (theProject.getEnviromentallyFriendly()) {
				projectToAdd.append(1);
			} else {
				projectToAdd.append(0);
			}
			projectToAdd.append("\n");
			
			ArrayList<Tasks> taskList = theProject.getTasks();
			ArrayList<Materials> materialList = theProject.getMaterials();
			
//			Adding tasks
			if (taskList.size() > 0) {
				for (Tasks task : taskList) {
					projectToAdd.append(task.getName()).append(",");
					if (task.isCompleted()) {
						projectToAdd.append(1);
					} else {
						projectToAdd.append(0);
					}
					projectToAdd.append(",");
				}
			} else {
				projectToAdd.append("notasks");
			}
			
//			Adding materials
			projectToAdd.append("\n");
			if (materialList.size() > 0) {
				for (Materials material : materialList) {
					projectToAdd.append(material.getName()).append(",");
					projectToAdd.append(material.getCost()).append(",");
					projectToAdd.append(material.getQuantity()).append(",");
				}
			} else  {
				projectToAdd.append("nomaterials");
			}
			projectToAdd.append("\n");
			
//			Rewriting the rest of the .csv (if editing, not adding)
			if (scan.hasNext()) {
//				Skipping project being overwritten
				scan.next();
				scan.next();
				scan.next();
				while (scan.hasNext()) {
					projectToAdd.append(scan.next()).append("\n");
				}
			}
			
			scan.close();
			FileWriter writer = new FileWriter(csv, false); 
			writer.write(projectToAdd.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

