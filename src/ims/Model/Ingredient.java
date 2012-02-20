/**
 * 
 */
package ims.Model;

/**
 * @author Minh, Kumar, Jean
 * @version 02/17/2012
 */

public class Ingredient {

	// Declare attributes
	private String name;
	private int quantity;
	private double cost;
	private String unitType;
	
	/*
	 * Constructor
	 */
	public Ingredient (String name, int quantity, double cost, String unitType)
	{
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.unitType = unitType;
	}
	
	/*
	 * Accessing method for name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Mutator for name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Accessing method for quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/*
	 * Mutator for quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*
	 * Accessing method for cost
	 */	
	public double getCost() {
		return cost;
	}
	
	/*
	 * Mutator for cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/*
	 * Accessing method for unitType
	 */
	public String getUnitType() {
		return unitType;
	}
	
	/*
	 * Mutator for unitType
	 */
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	
	
	
	
	
}
