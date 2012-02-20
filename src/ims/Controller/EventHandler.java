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
		}
		
		return isSuccess;
	}
	

}
