package ims.Model;

/**
 * @author Minh, Kumar, Jean
 * @version 02/17/2012
 */

public enum Event {
	INTIALIZE (0),
	EVALUATE_INVENTORY (1),
	ESTIMATE_QUANTITY (2),
	DISPLAY_PIZZAS (3),
	ORDER (4);
        
	private int event;
	
	Event(int event){
		this.setEvent(event);
	}

	public int getEvent() {
		return event;
	}

	public void setEvent(int event) {
		this.event = event;
	}
};
