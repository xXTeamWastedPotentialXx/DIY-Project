/**
 * 
 */
package model;

/**
 * @author Annora Jones
 *
 */
public class Tasks {

	/**
	 * The name of the Task.
	 */
	private String name;
	
	/**
	 * Keeps track of whether the Task has been completed or not.
	 */
	private boolean completed;
	
	/**
	 * Constructs a Task object.
	 * @param theName the name of the Task.
	 */
	 public Tasks(final String theName, final boolean isCompleted){
		name = theName;
		completed = isCompleted;
	 }
	
	 public String getName() {
		 return name;
	 } 
	
	 public boolean isCompleted() {
		 return completed;
	 }

	
	/**
	 * Toggles completion of Task.
	 */
	public void toggleCompletedTask() {
		
		completed = !completed;
	}
	
	/**
	 * @param theName the name to give to the Task.
	 */
	public void setName(final String theName) {
		
		name = theName;
	}
	
}
