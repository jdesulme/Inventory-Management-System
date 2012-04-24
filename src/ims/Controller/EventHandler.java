/**
 * 
 */
package ims.Controller;

import java.util.ArrayList;

import ims.DataLayer.DataAccess;
import ims.Model.*;

/**
 * @author Minh, Kumar, Jean
 *
 */
public class  EventHandler {
	
	public  EntityBase Result; //holds the result processed by the controllers
	private Event UIEvent; //holds the event that occurred in ui . 
	
	public EventHandler(Event uiEvent){
		this.UIEvent = uiEvent;
	}
	
	/**
	 * Accepts the event and parameters which are passed from 
	 * Program class and create either an Information object or Estimation object
	 * @param data 	information gathered from the ui
	 * @return
	 */
	public boolean  HandleEvent(EntityBase data){
		//Handle Events here
		boolean isSuccess = false;
		
		if(UIEvent.equals(Event.EVALUATE_INVENTORY)){
			
			Information information = new Information();
			UIInformation result = (UIInformation) data;
			result.IngredientList = new ArrayList<Ingredient>();
			isSuccess = information.ProcessInformation(result);
	
		} 		 
		else if (UIEvent.equals(Event.ESTIMATE_QUANTITY)) {
		
			Estimation estimation = new Estimation();
			UIEstimation result = (UIEstimation) data;
			result.IngredientList = new ArrayList<Ingredient>();
			isSuccess = estimation.ProcessInformation(result);			

		} 
		else if (UIEvent.equals(Event.DISPLAY_PIZZAS)) {
			
			UIEstimation estimate = (UIEstimation)data;			
			estimate.pizzaList = GetPizzaList(estimate);
			isSuccess = true;
		} 
		return isSuccess;
	}
	
	/**
	 * Gets the pizza list used in the  restaurant from the data access layer and returns it back
	 * @param estimation the information from the ui
	 * @return
	 */
	private ArrayList<Pizza> GetPizzaList(UIEstimation estimation) {
		DataAccess dataAccess = new DataAccess();
		return dataAccess.GetPizzaList();
	}
}
