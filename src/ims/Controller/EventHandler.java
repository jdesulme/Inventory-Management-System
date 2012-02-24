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
	
	//private static final String UIInformation = null;
	public  EntityBase Result;
	private Event UIEvent;
	
	public EventHandler(Event uiEvent){
		this.UIEvent = uiEvent;
	}
	
	public boolean  HandleEvent(EntityBase data){
		//Handle Events here
		boolean isSuccess = false;
		
		if(UIEvent.equals(Event.EVALUATE_INVENTORY)){
			
			Information information = new Information();
			UIInformation result = (UIInformation) data;
			result.IngredientList = new ArrayList<Ingredient>();
			isSuccess = information.ProcessInformation(result);
			//result.IngredientList = UIInformation;
			//Result = result;			
		} 		
		else if (UIEvent.equals(Event.ESTIMATE_QUANTITY)) {
		
			Estimation estimation = new Estimation();
			UIEstimation result = (UIEstimation) data;
			isSuccess = estimation.ProcessInformation(result);
			
		} 
		
		return isSuccess;
	}
	
	
	
	
	public void DisplayResult(){
		
	 if (UIEvent.equals(Event.ESTIMATE_QUANTITY)) {
			DisplayEstimationResult();
		}
		else if (UIEvent.equals(Event.DISPLAY_PIZZAS)) {
			DisplayPizzas();
		}
	}


	private void DisplayEstimationResult() {
		// TODO Auto-generated method stub
		
	}
	
	private void DisplayPizzas() {
		DataAccess dataAccess = new DataAccess();
		ArrayList<Pizza> pizzaList = dataAccess.GetPizzaList();
		
		for (Pizza item: pizzaList) {
			System.out.println(item.getPizzaName());
		}
		
	}
	
}
