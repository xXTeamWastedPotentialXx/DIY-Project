/**
 * TCSS 360 - DIY Project
 */

package model;


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
    
    private Object task[];
                    
    private Object materials[];
    
    
    /**
     * Constructor
     */
    public Project() {
        
        enviromentallyFriendly = false;
        
        difficultly = 0;
        
        priorityOfProject = 0;
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
    
    
    public Object getTasks() {
        
        return task;
    }
    
    
    public Object getMaterials() {
        
        return materials;
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
    
    
    public void setTasks(Object[] theTasks) {
        
        this.task = theTasks;
    }
    
    
    public void setMaterials(Object[] theMaterials) {
        
        this.materials = theMaterials;
    }
}
