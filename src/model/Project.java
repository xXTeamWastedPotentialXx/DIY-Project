/**
 * TCSS 360 - DIY Project
 */

package model;

import java.util.ArrayList;

public class Project {
    
    /**
     * Fields
     */
    private int totalCost;
    
    private int difficultly;
    
    private int priorityOfProject;
    
    private int progressOfProject;

    private String projectName;
    
    private boolean enviromentallyFriendly;
    
    private ArrayList<Tasks> myTasks;
                    
    private ArrayList<Materials> myMaterials;
    
    
    /**
     * Constructor
     */
    public Project(String theName, int theDifficulty, int thePriorty, boolean theStatus,
    			ArrayList<Tasks> theTasks, ArrayList<Materials> theMats) {
        
        enviromentallyFriendly = theStatus;
        
        difficultly = theDifficulty;
        
        priorityOfProject = thePriorty;
        projectName = theName;
        myTasks = theTasks;
        myMaterials = theMats;
    }
    public Project(String test) {
    	projectName = test;
    }
    
    /** #           #
     *   # GETTERS #
     */
    public int getTotalCost() {
        
        return totalCost;
    }
    
    
    public int getDifficultly() {
        
        return difficultly;
    }
    
    
    public int getPriority() {
        
        return priorityOfProject;
    }
    
    
    public int getProgress() {
        
        return progressOfProject;
    }
    
    
    public String getProjectName() {
        
        return projectName;
    }
    
    
    public boolean getEnviromentallyFriendly() {
        
        return enviromentallyFriendly;
    }
    
    
    public ArrayList<Tasks> getTasks() {
        
        return myTasks;
    }
    
    
    public ArrayList<Materials> getMaterials() {
        
        return myMaterials;
    }
    
    
    /** #           #
     *   # SETTERS #
     */
    public void setTotalCost(int theTotalCost) {
        
        this.totalCost = theTotalCost;
    }
    
    
    public void setDifficultly(int theDifficultly) {
        
        this.difficultly = theDifficultly;
    }
    
    public void setPriority(int thePriority) {
        
        this.priorityOfProject = thePriority;
    }
    
    
    public void setProgress(int theProgress) {
        
        this.progressOfProject = theProgress;
    }
    
    
    public void setProjectName(String theName) {
        
        this.projectName = theName;
    }
    
    
    public void setEnviromentallyFriendly(boolean theEnviromentallyFriendly) {
        
        this.enviromentallyFriendly = theEnviromentallyFriendly;
    }
    
    
    public void addTasks(Tasks theTask) {
        
        this.myTasks.add(theTask);
    }
    public void removeTasks(Tasks theTask) {
        
        this.myTasks.remove(theTask);
    }
    
    
    public void addMaterials(Materials theMaterial) {
        
        this.myMaterials.add(theMaterial);
    }
    public void removeMaterials(Materials theMaterial) {
    	this.myMaterials.remove(theMaterial);
    }
}
