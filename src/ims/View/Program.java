/**
 * 
 */
package ims.View;

import java.util.Scanner;

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
	
	public static void main(String[] args) {
		Program program = new Program();
		Event event = program.GetEvent();
		EventHandler eventHandler = new EventHandler(event);
		if(eventHandler.HandleEvent(program.UIData)){
			eventHandler.DisplayResult();
		}
		else {
			System.out.println("Error Occured");
		}
		
	}
	
	private Event GetEvent(){
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
		event.DisplayResult();
		
		isValid = false;
		do {
			System.out.println("Choose the type of pizza to be estimated");
			//validation to check if that input exists
			uiData.pizzaName = scan.next();
			isValid = true;
			
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
	 * Function check whether string could be parsed to an integer or not
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
	
	
}
