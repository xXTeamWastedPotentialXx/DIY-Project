/**
 * TCSS 360 - DIY Project
 */

package model;

import java.util.ArrayList;

/**
 * Class to model a project
 * @author gehryguest
 * @author Miranda Bessex
 *
 */
public class Project {
    
    /** total cost tracker. */
    private int myTotalCost;
    
    /** difficultly for project. */
    private int myDifficultly;
    
    /** Priority of project. */
    private int myPriorityOfProject;
    
    /** progress of project. */
    private int myProgressOfProject;

    /** Name of project. */
    private String myProjectName;
    
    /** Is the project environmentally friendly. */
    private boolean myEnvironmentallyFriendly;
    
    /** list of Tasks for projects. */
    private ArrayList<Tasks> myTasks;
    
    /** List of materials for projects. */
    private ArrayList<Materials> myMaterials;
    
    /**unique project id that is created from hashing the this object */
    private int myProjectID;
    
    
 	/**
      * constructor if an ID is not given, then it will generate one with this objects hashCode value
      * @param theName
      * @param theDifficultly
      * @param thePriority
      * @param theStatus
      * @param theTasks
      * @param theMats
      * @author gehry guest
      * @author Jacob Marquardt
      * @author Miranda Bessex
      */ 
  	 public Project(String theName, int theDifficulty, int thePriorty,
 			ArrayList<Tasks> theTasks, ArrayList<Materials> theMats) {

 			myProjectID = this.hashCode();
 		    
 		    myDifficultly = theDifficulty;
 		    
 		    myPriorityOfProject = thePriorty;
 		    myProjectName = theName;
 		    myTasks = theTasks;
 		    myMaterials = theMats;
  	 }
  	 
  	/**
      * constructor if an ID is given, Like when it is loaded from the file
      * @param theName
      * @param theDifficultly
      * @param thePriority
      * @param theStatus
      * @param theTasks
      * @param theMats
      * @author gehry guest
      * @author Jacob Marquardt
      * @author Miranda Bessex
      */ 
  	 public Project(int theID, String theName, int theDifficulty, int thePriorty,
 			ArrayList<Tasks> theTasks, ArrayList<Materials> theMats) {

 			myProjectID = theID;
 		    
 		    myDifficultly = theDifficulty;
 		    
 		    myPriorityOfProject = thePriorty;
 		    myProjectName = theName;
 		    myTasks = theTasks;
 		    myMaterials = theMats;
  	 }
    
    /** 
     * @param theName
     * @author gehry guest
     */
    public Project(final String theName) {
    	myProjectName = theName;
    }
 
    //########## Getters ############
    /**
     * @return myProjectID
     * @author Jacob Marquardt
     */
    public int getProjectID() {
    	return myProjectID;
    }
    /** 
     * @return myTotalCost
     * @author gehry guest
     */
    public int getTotalCost() {
    	calculateTotalCost();
        
        return myTotalCost;
    }
    
    /**
     * Method to calculate the total cost of the project
     * @author Miranda Bessex
     */
    private void calculateTotalCost() {
    	int sum = 0;
		for(Materials m : myMaterials) {
			sum += (m.getCost() * m.getQuantity());
		}
		myTotalCost = sum;
	}

	/** 
     * @return myDifficultly
     * @author gehry guest
     */
    public int getDifficultly() {
        
        return myDifficultly;
    }
    
    /** 
     * @return myPriorityOfProject
     * @author gehry guest
     */
    public int getPriority() {
        
        return myPriorityOfProject;
    }
    
    /** 
     * @return myProgressOfProject
     * @author gehry guest
     */
    public int getProgress() {
        
        return myProgressOfProject;
    }
    
    /** 
     * @return myProjectName
     * @author gehry guest
     */
    public String getProjectName() {
        
        return myProjectName;
    }
    
    /** 
     * @return myEnvironmentallyFriendly
     * @author gehry guest
     */
    public boolean getEnviromentallyFriendly() {
        
        return myEnvironmentallyFriendly;
    }
    
    /** 
     * @return myTasks
     * @author gehry guest
     */
    public ArrayList<Tasks> getTasks() {
        
        return myTasks;
    }
    
    /** 
     * @return myMaterials
     * @author gehry guest
     */
    public ArrayList<Materials> getMaterials() {
        
        return myMaterials;
    }
    
    //########## Setters ############
    
    /**
     * @param theProjectID
     * @author Jacob Marquardt
     */
    public void setProjectID(final int theProjectID) {
    	this.myProjectID = theProjectID;
    }
    
    /** 
     * @param theTotalCost
     * @author gehry guest
     */
    public void setTotalCost(int theTotalCost) {
        
        this.myTotalCost = theTotalCost;
    }
    
    /** 
     * @param theTotalCost
     * @author gehry guest
     */
    public void setDifficultly(int theDifficultly) {
        
        this.myDifficultly = theDifficultly;
    }
    
    /** 
     * @param thePriority
     * @author gehry guest
     */
    public void setPriority(int thePriority) {
        
        this.myPriorityOfProject = thePriority;
    }
    
    
    /** 
     * @param theProgress
     * @author gehry guest
     */
    public void setProgress(int theProgress) {
        
        this.myProgressOfProject = theProgress;
    }
    
    /** 
     * @param theName
     * @author gehry guest
     */
    public void setProjectName(String theName) {
        
        this.myProjectName = theName;
    }
    
    /** 
     * @param theEnviromentallyFriendly
     * @author gehry guest
     */
    public void setEnviromentallyFriendly(boolean theEnviromentallyFriendly) {
        
        this.myEnvironmentallyFriendly = theEnviromentallyFriendly;
    }
    
    //########## Adders ############
    
    /** 
     * @param theTask
     * @author gehry guest
     */
    public void addTasks(Tasks theTask) {
        
        this.myTasks.add(theTask);
    }
    
    /** 
     * @param theMaterial
     * @author gehry guest
     */
    public void addMaterials(Materials theMaterial) {
        
        this.myMaterials.add(theMaterial);
    }
    
    
    //########## Removers ############
    
    /** 
     * @param theTask
     * @author gehry guest
     */
    public void removeTasks(Tasks theTask) {
        
        this.myTasks.remove(theTask);
    }
    
    /** 
     * @param theMaterial
     * @author gehry guest
     */
    public void removeMaterials(Materials theMaterial) {
        
    	this.myMaterials.remove(theMaterial);
    }
    
    /**
     * This will be the string that is displayed in the home page list
     * @override toString() method
     * @author Miranda Bessex
     */
    public String toString() {
    	String spacer = "     ";
    	StringBuilder projectDetails = new StringBuilder();
    	projectDetails.append(myProjectName);
    	projectDetails.append(spacer);
    	projectDetails.append("Priority: ");
    	projectDetails.append(myPriorityOfProject);
    	projectDetails.append(spacer);
    	projectDetails.append("Difficulty: ");
    	projectDetails.append(myDifficultly);
    	projectDetails.append(spacer);

    	
    	
    	
		return projectDetails.toString();
    	
    }
    
}
