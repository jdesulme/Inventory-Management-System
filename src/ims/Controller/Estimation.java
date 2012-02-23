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
		ArrayList<Ingredient> estimationList = dataAccess.GetIngredients(ui.pizzaName, ui.pizzaSize);
		
		if( estimationList !=null && !estimationList.isEmpty() ) {
			for(Ingredient item : estimationList) {
				System.out.printf("Name: %s		Quantity: %2.2f		Type: %s	Total Quantity Used: %2.2f%n ",item.getName(), item.getQuantity(), item.getUnitType(),item.calcQuantityCost(ui.pizzaNumber) );
				
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
