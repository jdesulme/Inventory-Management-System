/**
 * 
 */
package ims.Controller;

import java.util.ArrayList;

import ims.DataLayer.*;
import ims.Model.*;


/**
 * @author Minh, Kumar, Jean
 *
 */
public class Estimation {
	/**
	 * 
	 * @param ui
	 * @return
	 */
	public boolean ProcessInformation(UIEstimation ui){
		boolean isDone = false;
		DataAccess dataAccess  = new DataAccess();
		ArrayList<Ingredient> EstimationReport = ui.IngredientList;
		ArrayList<Ingredient> estimationList = dataAccess.GetIngredients(ui.pizzaName, ui.pizzaSize);
		
		if( estimationList !=null && !estimationList.isEmpty() ) {
			for(Ingredient item : estimationList) {
				double quantity = Rules.GetQuantity(item.getQuantity(), item.getUnitType());
				String unitType = Rules.GetAcronymOfUnitType(item.getUnitType());
				
				Ingredient tempIngredient = new Ingredient(item.getName(), quantity, 0, unitType);
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
