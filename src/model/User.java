package model;

/**
 * Class to model a User of the APP
 * @author Miranda Bessex
 *
 */

public class User {

	/** User Name */
	private String myName;
	
	/** User Email */
	private String myEmail;
	
	
	/**
	 * Constructor for the User
	 * @param theName
	 * @param theEmail
	 * @author Miranda Bessex
	 */
	public User(String theName, String theEmail) {
		myName = theName;
		myEmail = theEmail;
	}
	
	/**
	 * Getter for the name
	 * @return name
	 * @author Miranda Bessex
	 */
	public String getUserName() {
		return myName;
	}
	
	/**
	 * Getter for the email
	 * @return email
	 * @author Miranda Bessex
	 */
	public String getUserEmail() {
		return myEmail;
	}
	
	/**
	 * Setter for User Name
	 * @author Miranda Bessex
	 */
	public void setUserName(String theName) {
		myName = theName;
	}
	
	/**
	 * Setter for Email
	 * @author Miranda Bessex
	 */
	public void setUserEmail(String theEmail) {
		myEmail = theEmail;
	}
	
}
