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
	ArrayList<Ingredient> EstimationReport;
		
	public boolean ProcessInformation(UIEstimation ui){
		boolean isDone = false;
		DataAccess dataAccess  = new DataAccess();
		ArrayList<Ingredient> estimationList = dataAccess.GetIngredients(ui.pizzaName.toString(), ui.pizzaSize);
	
		for(Ingredient item : estimationList) {
			
			//pass in a string with the user preferences 
			System.out.printf("Quantity: %d	/t Type: %s /t Total Quantity Used: %d",item.getQuantity(), item.getUnitType(), item.calcQuantityCost(ui.pizzaNumber) );
			
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
