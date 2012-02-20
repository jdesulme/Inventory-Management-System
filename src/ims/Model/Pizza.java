package ims.Model;
import java.util.ArrayList;

/**
 * @author Minh, Kumar, Jean
 * @version 02/17/2012
 */

public class Pizza {
	
	//Declare attributes
	private String pizzaName;
	private char pizzaType;
	private ArrayList <Ingredient> ingredients;
	
	/*
	 * Constructor
	 */
	public Pizza (String inName, char inType, ArrayList <Ingredient> inIngredients)
	{
		pizzaName = inName;
		pizzaType = inType;
		ingredients = inIngredients;
	}

	/*
	 * Accessor for pizzaName
	 */
	public String getPizzaName() {
		return pizzaName;
	}
	
	/*
	 * Mutator for pizzaName
	 */
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	/*
	 * Accessor for pizzaType
	 */
	public char getPizzaType() {
		return pizzaType;
	}

	/*
	 * Mutator for pizzaType
	 */
	public void setPizzaType(char pizzaType) {
		this.pizzaType = pizzaType;
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
}
