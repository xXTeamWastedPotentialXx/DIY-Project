/**
 * 
 */
package model;


/**
 * @author Annora Jones
 *
 */
public class Materials {

	/**
	 * The name of the Material.
	 */
	private String name;
	
	/**
	 * The cost of one unit of this Material.
	 */
	private double cost;
	
	/**
	 * The number of units of this material the user needs.
	 */
	private int quantity;
	
	/**
	 * The total cost of all of this kind of material.
	 */
	private double totalCost;
	
	/**
	 * Constructs a Material object.
	 * @param theName the name of the Material.
	 * @param theCost the cost of one unit of this material.
	 * @param theQuantity the number of units the user needs.
	 */
	public Materials(final String theName, final double theCost, final int theQuantity){
		
		name = theName;
		cost = theCost;
		quantity = theQuantity;
		totalCost = sumCosts();
	}
	
	
	//Accessor methods
	
	/**
	 * Calculates the total cost of this type of Material the user requires.
	 * i.e. cost * quantity
	 */
	private double sumCosts() {
		
		return cost * quantity;
	}
	
	/**
	 * @return the name of the Material
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * @return the cost of the Material
	 */
	public double getCost() {
		
		return cost;
	}
	
	/**
	 * @return the quantity of the Material
	 */
	public int getQuantity() {
		
		return quantity;
	}
	
	/**
	 * @return the total cost of the selected quantity of Materials
	 */
	public double getTotalCost() {
		
		return totalCost;
	}
	
	
	//Mutator methods
	
	/**
	 * @param theName the new name to give to the Material
	 */
	public void setName(final String theName) {
		
		name = theName;
	}
	
	/**
	 * @param theCost the new cost to give to the Material
	 */
	public void setCost(final double theCost) {
		
		cost = theCost;
	}
	
	/**
	 * @param theQuantity the new quantity of the Material.
	 */
	public void setQuantity(final int theQuantity) {
		
		quantity = theQuantity;
	}
}
