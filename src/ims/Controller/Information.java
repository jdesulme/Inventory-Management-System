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

	/**
	 *  Validates and checks if an order exists for the given month and year. 
	 *  if it exists it's added to a list and returns it
	 *  @param year
	 *  @param month
	 *  @param orderList
	 */
	public ArrayList<Order> GetValidOrders(int year, int month,ArrayList<Order> orderList){
		 
		 if(orderList!=null && !orderList.isEmpty()){
				//Looping the order list
			 int i=orderList.size()-1;
			 while(i>=0){
				
				String orderDate = orderList.get(i).getOrderDate();
				if(!orderDate.split("/")[0].contains((String.valueOf(month))) || !orderDate.contains (String.valueOf(year))){
							orderList.remove(i);
				}
				i--;
			}
		  }
		return orderList;
	}
	
	/**
	 * Process the information based on the UI input
	 * @param uiInformation
	 * @return boolean whether information is processed or an error occurred
	 */
	
	public boolean ProcessInformation(UIInformation uiInformation){
		
		boolean isDone = false;
		DataAccess dataAccess  = new DataAccess();
		ArrayList<Ingredient> InformationReport = uiInformation.IngredientList;//using UI information data as reference 
		ArrayList<Order> orderList = dataAccess.GetOrderList(uiInformation.Locality);
		
		double totalCost = 0.0;
		orderList =  GetValidOrders(uiInformation.Year,uiInformation.Month,orderList);
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
						double totalIngredientCost = quantity * ingredient.getCost();
						totalCost +=totalIngredientCost;
						//Find and returns the ingredient if already in the list
						Ingredient tempIngredient = ingredient.GetIngredientFromList(InformationReport);
						
						//If no ingredient is found in the list
						if(tempIngredient == null){
							tempIngredient  = new Ingredient(ingredient.getName(),quantity, totalIngredientCost, Rules.GetAcronymOfUnitType(ingredient.getUnitType()));
							InformationReport.add(tempIngredient);
						}
						else{// if ingredient is found in the lists
							tempIngredient.setQuantity(quantity + tempIngredient.getQuantity());
							tempIngredient.setCost(totalIngredientCost + tempIngredient.getCost());
						}
					}
				}
			}
			
			if(!InformationReport.isEmpty()){
				uiInformation.TotalCost  = totalCost;
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
