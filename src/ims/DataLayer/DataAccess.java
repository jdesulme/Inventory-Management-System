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
		
		Location tempLocal = locality;
		
		//Create orderList
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		//Create objects according to the selected location
		if (tempLocal == Location.Both)
		{
			//Create branch objects
			Branch branch1 = new Branch("Branch1", "123 Second Street", "8489923412", "Ho Chi Minh");
			Branch branch2 = new Branch("Branch2", "456 Community Street", "8488273456", "Ho Chi Minh");
				
			//Create order1
			ArrayList<Ingredient> ingredients1 = new ArrayList<Ingredient>();
			Ingredient pepperoni = new Ingredient ("Pepperoni", 3, 20, "kilograms");
			Ingredient cheese = new Ingredient ("Cheese", 10, 10, "kilograms");
			Ingredient oil = new Ingredient ("Oil", 5, 2, "liters");
			ingredients1.add(pepperoni);
			ingredients1.add(cheese);
			ingredients1.add(oil);
			Order order1 = new Order(1, "01/01/2011", branch1, 170, ingredients1);
			
			//Create order2
			ArrayList<Ingredient> ingredients2 = new ArrayList<Ingredient>();
			Ingredient egg = new Ingredient ("Egg", 12, 3, "dozens");
			Ingredient italianSausage = new Ingredient ("Italian Sausage", 500, 10, "grams");
			Ingredient oil1 = new Ingredient ("Oil", 600, 2, "milliliters");
			ingredients2.add(egg);
			ingredients2.add(italianSausage);
			ingredients2.add(oil1);
			Order order2 = new Order(2, "01/01/2011", branch2, 42.2, ingredients2);
			
			//Create order3
			ArrayList<Ingredient> ingredients3 = new ArrayList<Ingredient>();
			Ingredient dough = new Ingredient ("Dough", 10, 5, "kilograms");
			Ingredient bacon = new Ingredient ("Bacon", 5, 10, "kilograms");
			ingredients3.add(dough);
			ingredients3.add(bacon);
			Order order3 = new Order(3, "05/05/2011", branch1, 100, ingredients3);
			
			//Create order4
			ArrayList<Ingredient> ingredients4 = new ArrayList<Ingredient>();
			Ingredient tuna = new Ingredient ("Tuna", 10, 50, "kilograms");
			Ingredient milk = new Ingredient ("Milk", 10, 2, "liters");
			ingredients4.add(tuna);
			ingredients4.add(milk);
			Order order4 = new Order(4, "05/05/2011", branch2, 520, ingredients4);
			
			//Add orders in orderlist
			orderList.add(order1);
			orderList.add(order2);
			orderList.add(order3);
			orderList.add(order4);
		}
		
		else if (tempLocal == Location.Branch1)
		{
			//Create branch object
			Branch branch1 = new Branch("Branch1", "123 Second Street", "8489923412", "Ho Chi Minh");
			
			//Create order1
			ArrayList<Ingredient> ingredients1 = new ArrayList<Ingredient>();
			Ingredient pepperoni = new Ingredient ("Pepperoni", 3, 20, "kilograms");
			Ingredient cheese = new Ingredient ("Cheese", 10, 10, "kilograms");
			Ingredient oil = new Ingredient ("Oil", 5, 2, "liters");
			ingredients1.add(pepperoni);
			ingredients1.add(cheese);
			ingredients1.add(oil);
			Order order1 = new Order(1, "01/01/2011", branch1, 170, ingredients1);
			
			//Create order3
			ArrayList<Ingredient> ingredients3 = new ArrayList<Ingredient>();
			Ingredient dough = new Ingredient ("Dough", 10, 5, "kilograms");
			Ingredient bacon = new Ingredient ("Bacon", 5, 10, "kilograms");
			ingredients3.add(dough);
			ingredients3.add(bacon);
			Order order3 = new Order(3, "05/05/2011", branch1, 100, ingredients3);
			
			//Add orders in orderlist
			orderList.add(order1);
			orderList.add(order3);
		}
		
		else if (tempLocal == Location.Branch2)
		{
			//Create branch objects
			Branch branch2 = new Branch("Branch2", "456 Community Street", "8488273456", "Ho Chi Minh");
			
			//Create order2
			ArrayList<Ingredient> ingredients2 = new ArrayList<Ingredient>();
			Ingredient egg = new Ingredient ("Egg", 12, 3, "dozens");
			Ingredient italianSausage = new Ingredient ("Italian Sausage", 500, 10, "grams");
			Ingredient oil1 = new Ingredient ("Oil", 600, 2, "milliliters");
			ingredients2.add(egg);
			ingredients2.add(italianSausage);
			ingredients2.add(oil1);
			Order order2 = new Order(2, "01/01/2011", branch2, 42.2, ingredients2);
			
			//Create order4
			ArrayList<Ingredient> ingredients4 = new ArrayList<Ingredient>();
			Ingredient tuna = new Ingredient ("Tuna", 10, 50, "kilograms");
			Ingredient milk = new Ingredient ("Milk", 10, 2, "liters");
			ingredients4.add(tuna);
			ingredients4.add(milk);
			Order order4 = new Order(4, "05/05/2011", branch2, 520, ingredients4);
			
			//Add orders in orderlist
			orderList.add(order2);
			orderList.add(order4);
		}
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
