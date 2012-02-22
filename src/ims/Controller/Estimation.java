/**
 * 
 */
package ims.Controller;

/**
 * @author Minh, Kumar, Jean
 *
 */
public class Estimation {

	
	
	
	
	/**
	 * Checks to see if the user entered a number
	 * @param numPizza the number of pizza made
	 * @return
	 */
	public static boolean validateInput(int numPizza) {
		boolean isTrue = false;
		
		if(numPizza > 0) {
			isTrue = true;
		}
		
		return isTrue;
	}
}
