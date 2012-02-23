package ims.Model;
import java.util.ArrayList;

/**
 * @author Minh, Kumar, Jean
 * @version 02/17/2012
 */

public class Pizza {
	
	//Declare attributes
	private String pizzaName;
	private String pizzaType;
	private ArrayList <Ingredient> ingredients;
	
	public Pizza() {
		setPizzaName("Pepperoni");
		setPizzaType("large");
	}
	
	
	/*
	 * Constructor
	 */
	public Pizza (String inName, String inType, ArrayList <Ingredient> inIngredients)
	{
		this.pizzaName = inName;
		this.pizzaType = inType;
		this.ingredients = inIngredients;
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
	public String getPizzaType() {
		return pizzaType;
	}

	/*
	 * Mutator for pizzaType
	 */
	public void setPizzaType(String string) {
		this.pizzaType = string;
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
