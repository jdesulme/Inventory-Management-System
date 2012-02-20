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
		// TODO Auto-generated method stub
		
		
		Program program = new Program();
		Event event = program.GetEvent();
		
		if(EventHandler.HandleEvent(event,program.UIData)){
			
		}
		else{
			System.out.println("Error Occured");
		}
		
	}
	
	private Event GetEvent(){
		int option = 0;
		
		do{
			System.out.println("Enter the option");
			System.out.println("1.Evaluate Inventory Level");
			System.out.println("2.Estimate qunatity of Ingredients");
			Scanner scan = new Scanner(System.in);
			option = scan.nextInt();
		}while(option<0 || option>2);
		
		Event event = null;
		
		if(option ==1){
			
			event = Event.EVALUATE_INVENTORY;
			UIData = GetInformationData();
		}
		else if(option == 2){
			event = Event.ESTIMATE_QUANTITY;
		}
		return event;		
	}
	
	private UIInformation GetInformationData(){
		
		UIInformation uiData = new UIInformation();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Location");
		uiData.Locality = Location.valueOf(scan.next());
		System.out.println("Enter the Year to get inventory information");
		uiData.Year = scan.nextInt();
		System.out.println("Enter the month to get inventory information");
		uiData.Month = scan.nextInt();
		return uiData;
	}

}
