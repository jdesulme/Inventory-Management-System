package ims.Model;

import java.util.ArrayList;

/**
 * @author Minh, Kumar, Jean
 * @version 02/17/2012
 */

public class Order {

	//Declare attributes
	private int orderID;
	private String orderDate;
	private double orderCost;
	private Branch branch;
	private ArrayList <Ingredient> ingredients;
	
	/*
	 * Constructor
	 */
	public Order (int inID, String inDate, Branch inBranch, double inCost, ArrayList <Ingredient> inIngredients)
	{
		this.orderID = inID;
		this.orderDate = inDate;
		this.branch = inBranch;
		this.orderCost = inCost;
		this.ingredients = inIngredients;
	}

	/*
	 * Accessor for orderID
	 */
	public int getOrderID() {
		return orderID;
	}

	/*
	 * Mutator for orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	/*
	 * Accessor for orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/*
	 * Mutator for orderDate
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/*
	 * Accessor for orderCost
	 */
	public double getOrderCost() {
		return orderCost;
	}

	/*
	 * Mutator for orderCost
	 */
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}

	/*
	 * Accessor for branch
	 */
	public Branch getBranch() {
		return branch;
	}

	/*
	 * Mutator for branch
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	/*
	 * Accessor for ingredients
	 */
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	/*
	 * Mutator for ingredients
	 */
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	/*
	 * Method to add an ingredient to order object 
	 */
	public void addIngredient(Ingredient ingredient){
		this.ingredients.add(ingredient);
	}
	
}
