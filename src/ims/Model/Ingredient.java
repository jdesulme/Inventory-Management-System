/**
 * 
 */
package ims.Model;

import java.util.ArrayList;

/**
 * @author Minh, Kumar, Jean
 * @version 02/17/2012
 */

public class Ingredient {

	// Declare attributes
	private String name;
	private double quantity;
	private double cost;
	private String unitType;
	
	/*
	 * Constructor
	 */
	public Ingredient (String name, double quantity, double cost, String unitType)
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
	public double getQuantity() {
		return quantity;
	}
	
	/*
	 * Mutator for quantity
	 */
	public void setQuantity(double quantity) {
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
	
	public double calcQuantityCost(int numPizza) {
		double total;
		
		total = numPizza * getQuantity();
		
		return total; 
	}
	
	
	/**
	 * To find the ingredient in the list of ingredients
	 * @param ingredientList
	 * @return boolean
	 */
	public boolean IsIngredientInList(ArrayList<Ingredient> ingredientList){
		
		if(ingredientList!= null && !ingredientList.isEmpty()){
			
			for (Ingredient ingredient : ingredientList) {
				
				if(ingredient.getName().equalsIgnoreCase(this.name)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Get an ingredient from the ingredient list of it present otherwise return null
	 * @param ingredientList
	 * @return ingredient / NULL
	 */
	public Ingredient GetIngredientFromList(ArrayList<Ingredient> ingredientList){
		
		if(ingredientList!= null && !ingredientList.isEmpty()){
			
			for (Ingredient ingredient : ingredientList) {
				
				if(ingredient.getName().equalsIgnoreCase(this.name)){
					return ingredient;
				}
			}
		}
		
		return null;	
	}
}
