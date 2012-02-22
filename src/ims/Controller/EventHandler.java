/**
 * 
 */
package ims.Controller;

import ims.Model.*;

/**
 * @author Minh, Kumar, Jean
 *
 */
public class  EventHandler {
	
	public static boolean  HandleEvent(Event event, EntityBase data){
		//Handle Events here
		boolean isSuccess = false;
		if(event.equals(Event.EVALUATE_INVENTORY)){
			Information information = new Information();
			isSuccess = true;
		} else if (event.equals(Event.ESTIMATE_QUANTITY)) {
			Estimation estimation = new Estimation();
			isSuccess = true;
			System.out.println("Reaching the handle Event method");
		} 
		
		return isSuccess;
	}
	

}
