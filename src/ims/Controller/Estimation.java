/**
 * 
 */
package ims.Controller;

import ims.DataLayer.DataAccess;
import ims.Model.Ingredient;
import ims.Model.UIEstimation;
import java.util.ArrayList;


/**
 * @author Minh, Kumar, Jean
 *
 */
public class Estimation {
	/**
	 * Estimates the quantity of ingredients used to make 
	 * certain number of a specific type of pizza based upon the user inputs.
	 * @param ui
	 * @return 
	 */
	public boolean ProcessInformation(UIEstimation ui){
		boolean isDone = false;
		DataAccess dataAccess  = new DataAccess();
		ArrayList<Ingredient> EstimationReport = ui.IngredientList;
		ArrayList<Ingredient> estimationList = dataAccess.GetIngredients(ui.pizzaName, ui.pizzaSize);
		
		//checks to see if ingredients exist
		if( estimationList !=null && !estimationList.isEmpty() ) {
			for(Ingredient item : estimationList) {
				double quantity = Rules.GetQuantity(item.getQuantity(), item.getUnitType()); //converts the quantity to liter or kg
				String unitType = Rules.GetAcronymOfUnitType(item.getUnitType());	//returns the correct acronym
				double totalQuantity = quantity * ui.pizzaNumber; //calculates the total quantity
				
				Ingredient tempIngredient = new Ingredient(item.getName(), totalQuantity, 0, unitType);
				EstimationReport.add(tempIngredient);
			}
			isDone = true;
		} else {
			System.out.println("No records available");
		}
		
		return isDone;
	}
	

	/**
	 * Checks to see if the user entered a number
	 * so that we can estimate the quantity of ingredients properly
	 * @param numPizza the number of pizza made
	 * @return
	 */
	public static boolean validateInput(String input) {
		boolean isTrue = false;
		
		try {
			int numPizza = Integer.parseInt(input);
			
			if(numPizza > 0) {
				isTrue = true;
			}
		}
		catch(NumberFormatException ex) {
			System.out.println("Failed Validation. Please Try Again");			
		}
		
		return isTrue;
	}
        
}
