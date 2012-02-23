/**
 * 
 */
package ims.Controller;

import java.util.ArrayList;

import ims.Model.*;
import ims.DataLayer.*;
/**
 * @author Minh, Kumar, Jean
 *
 */
public class Information {

	ArrayList<Ingredient> InformationReport;
	
	public boolean ValidateInput(int year, int month){
		boolean isValid = false;
		
		return isValid;
	}
	
	/**
	 * Process the information based on the UI input
	 * @param uiInformation
	 * @return boolean whether information is processed or an error occurred
	 */
	
	public boolean ProcessInformation(UIInformation uiInformation){
		boolean isDone = false;
		DataAccess dataAccess  = new DataAccess();
		InformationReport = new ArrayList<Ingredient>();
		ArrayList<Order> orderList = dataAccess.GetOrderList(uiInformation.Locality);
		
		if(orderList!=null && !orderList.isEmpty()){
			//Looping the order list
			for (Order order : orderList) {
				
				ArrayList<Ingredient> ingredientList = order.getIngredients();
				
				//Looping through the ingredient list
				if(ingredientList!=null && !ingredientList.isEmpty()){
					
					for (Ingredient ingredient : ingredientList) {
						
						//Get the total quantity by applying the rule
						double quantity = Rules.GetQuantity(ingredient.getQuantity(), ingredient.getUnitType());
						
						//calculates the total cost
						double totalCost = quantity * ingredient.getCost();
						
						//Find and returns the ingredient if already in the list
						Ingredient tempIngredient = ingredient.GetIngredientFromList(InformationReport);
						
						//If no ingredient is found in the list
						if(tempIngredient == null){
							tempIngredient  = new Ingredient(ingredient.getName(),quantity, totalCost, "kg");
							InformationReport.add(tempIngredient);
						}
						else{// if ingredient is found in the lists
							tempIngredient.setQuantity(quantity + tempIngredient.getQuantity());
							tempIngredient.setCost(totalCost + tempIngredient.getCost());
						}
					}
				}
			}
			
			if(!InformationReport.isEmpty()){
				isDone = true;
			}
			else{
				// temporary code TO-DO for error handling
				System.out.println("No record found for specified month and year. Try a different date");
			}
		}
		else{
			
			isDone = false;
			// temporary code TO-DO for error handling
			System.out.println("No record found for specified month and year. Try a different date");
		}
		
		return isDone;
	}
	
}
