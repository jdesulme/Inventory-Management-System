/**
 * 
 */
package ims.View;

import java.util.*;

import ims.Model.*;
import ims.Controller.*;

/**
 * @author kumar
 *
 */
public class Program {

	/**
	 * @param args
	 */
	private EntityBase UIData;
	private static Event event;
	
	public static void main(String[] args) {
		
		Program program = new Program();
		
		event = program.GetEvent();
		
		EventHandler eventHandler = new EventHandler(event);
		
		if(eventHandler.HandleEvent(program.UIData)){
			program.DisplayResult(program.UIData);
			System.out.println("\n\nThank You for using our program");
		}
		else {
			System.out.println("Error Occurred");
		}
		
	}
	
	public Event GetEvent(){
		int option = 0;
		
		do{
			System.out.println("Enter the option");
			System.out.println("1.Evaluate Inventory Level");
			System.out.println("2.Estimate Quantity of Ingredients");
			Scanner scan = new Scanner(System.in);
			option = scan.nextInt();
		} while(option<0 || option>2);
		
		Event event = null;
		
		if (option == 1){
			event = Event.EVALUATE_INVENTORY;
			UIData = GetInformationData();
		}
		else if (option == 2){
			event = Event.ESTIMATE_QUANTITY;
			UIData = GetEstimationData();
		}
		return event;		
	}
	
	/**
	 * 
	 * @return
	 */
	
	private UIInformation GetInformationData(){
		
		UIInformation uiData = new UIInformation();
		
		boolean isValid = false;
		Scanner scan = new Scanner(System.in);
		String value;
		//Get the location
		while(!isValid){
			
			System.out.print("Enter the Location (");
			for(Location locValue :Location.values() ){
				System.out.print(locValue + ", ");
			}
			System.out.println(")");
			
			value = scan.next();
			
			for(Location locValue : Location.values() ){
				
				if(locValue.toString().equalsIgnoreCase(value)){
					isValid = true;
					uiData.Locality = locValue;
					break;
				}
				
			}
		}
		
		//Get the year
		isValid = false; // Get ready for next validation
		while(!isValid){
			
			System.out.println("Enter the Year to get inventory information (2011)");
			value = scan.next();
			uiData.Year = new Integer(0);
			 if(IsToInteger(value)){
				 
				 uiData.Year = Integer.parseInt(value);
				 if(uiData.Year > 0 && value.length()==4){
					 isValid = true;
				 }
			 }
		}
		
		//Get the month
		isValid = false; // Get ready for next validation
		while(!isValid){
			System.out.println("Enter the month to get inventory information");
			value = scan.next();
			
			 if(IsToInteger(value)){
				 uiData.Month = Integer.parseInt(value);
				 if(uiData.Month > 0 && uiData.Month<13){
					 isValid = true;
				 }
			 }
		}
		
		return uiData;
	}
	
	/**
	 * 
	 * @return
	 */
	private UIEstimation GetEstimationData(){
		
		UIEstimation uiData = new UIEstimation();
		
		boolean isValid = false;
		String input;
		Scanner scan = new Scanner(System.in);
		
		//user enters number of pizza's with validation
		do {
			System.out.println("Enter the number of pizzas made");
			 input = scan.next();
			
			if ( Estimation.validateInput(input) ) {
				uiData.pizzaNumber = Integer.parseInt(input);
				isValid = true;
			}
		} while (!isValid);
		
		
		//retrieve and display list of all existing pizza's'
		Event pizzaEvent = Event.DISPLAY_PIZZAS;
		EventHandler event = new EventHandler(pizzaEvent);
		event.HandleEvent(uiData);

		for (Pizza item: uiData.pizzaList) {
			System.out.println(item.getPizzaName());
		}
		
		isValid = false;
		scan.skip("\n");
		do {
			System.out.println("Choose the type of pizza to be estimated");
			String inputNum = scan.nextLine();
			
			for (Pizza item: uiData.pizzaList) {
				if(item.getPizzaName().equalsIgnoreCase(inputNum)){
					uiData.pizzaName = inputNum;
					isValid = true;
					break;
				}
			}
			
		} while (!isValid);
		
		
		//user enters the size of the pizza to be estimated
		isValid = false;
		do {
			System.out.println("Choose the size of the pizza to be estimated (small, medium, or large)");
			
			input = scan.next();
			
			for(Sizes size : Sizes.values()){
				if(size.toString().equalsIgnoreCase(input)){
					uiData.pizzaSize = input;
					isValid = true;
					break;
				}
			}
			
		} while(!isValid);
		
		
		return uiData;
	}
	
	/**
	 * Function that checks whether string could be parsed to an integer or not
	 */
	private boolean IsToInteger(String value){
		boolean isParsed = false;
		
		try {		
			Integer.parseInt(value);
			isParsed = true;
		}
		catch(NumberFormatException ex){
			
		}
		return isParsed;
	}
	
	public void DisplayResult(EntityBase uiData){
		
		if(event.equals(Event.EVALUATE_INVENTORY)){		
			DisplayInformationResult((UIInformation)uiData);		
		}
		else if (event.equals(Event.ESTIMATE_QUANTITY)) {
	
			DisplayEstimationResult((UIEstimation)uiData);
		}
	}

	private void DisplayEstimationResult(UIEstimation result) {
		
		if( result != null ){
			System.out.println("====================Estimation Report====================");
			System.out.println("Ingredient Name        Quantity Unit    TotalCost");
			System.out.println("==========================================================");
		
			
			for (Ingredient ingredient : result.IngredientList) {
				
				System.out.printf("%-19s %,11.2f %-5s %,10.2f %n", ingredient.getName(), 
																   ingredient.getQuantity(),
														           ingredient.getUnitType(),
														           ingredient.getCost()); 
			}	
			
			
		}
	}
		
	/*
	 * Displays the processed information result
	 */
	private void DisplayInformationResult(UIInformation result) {
			
		if(result!=null){
			System.out.println("====================Information Report====================");
			System.out.print("Report :" + result.Locality.toString());
			System.out.println("		Month :" + result.Month + "   Year :" + result.Year);
			System.out.println("==========================================================");
			System.out.println("Ingredient Name        Quantity Unit    TotalCost");
			System.out.println("==========================================================");
			
			for (Ingredient ingredient : result.IngredientList) {
				
				System.out.printf("%-19s %,11.2f %-5s %,10.2f %n", ingredient.getName(), 
																   ingredient.getQuantity(),
														           ingredient.getUnitType(),
														           ingredient.getCost()); 
			}		
		}
	}
	
}
