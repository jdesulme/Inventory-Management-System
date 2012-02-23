/**
 * 
 */
package ims.DataLayer;

import java.util.ArrayList;

import ims.Model.*;
/**
 * @author Minh, Kumar, Jean
 *
 */
public class DataAccess {
	
	public DataAccess(){
		
		
	}
	
	/**
	 * Gets the order list based upon the locality and date 
	 * 
	 */
	public ArrayList<Order> GetOrderList(Location locality){
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		//Order order = new Order();
		return orderList;
	}
	
	
	/**
	 * Gets all the pizza's that are currently in the system
	 * @return  
	 */
	public ArrayList<Pizza> GetPizzaList() {
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		//this should contain all the pizzas that are stored

		
		return pizzaList;
	}
	
	/**
	 * 
	 * @param pizzaName
	 * @param pizzaSize
	 * @return
	 */
	public ArrayList<Ingredient> GetIngredients(UIEstimation pizzaName, UIEstimation pizzaSize){
		//look in the pizza array list for something that matches 
		//than list out all the ingredients
		
		
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		
		
		return ingredientList;
	}
}
