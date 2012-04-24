/**
 * 
 */
package ims.Model;

import java.util.ArrayList;

/**
 * @author Minh, Kumar, Jean
 *
 */
public class UIEstimation extends EntityBase {
	public int pizzaNumber;
	public String pizzaName;
	public String pizzaSize;
	public String ingredients;
	public ArrayList<Ingredient> IngredientList;
	public ArrayList<Pizza> pizzaList;
	
	public String toString() {
		return String.format("Pizza Number: %d, Pizza Name: %s, Pizza Size: %s %nIngredients To Be Estimated: %s", pizzaNumber, pizzaName, pizzaSize, ingredients);
	}
	
	
}
