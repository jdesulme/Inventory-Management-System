package ims.Model;

/**
 * @author Minh, Kumar, Jean
 * @version 02/17/2012
 */

public enum Event {
	INTIALIZE (0),
	EVALUATE_INVENTORY (1),
	ESTIMATE_QUANTITY (2);
	private int event ;
	Event(int event){
		this.event = event;
	}
};
