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
	public static boolean validateInput(String input) {
		boolean isTrue = false;
		
		try {
			int numPizza = Integer.parseInt(input);
			
			if(numPizza > 0) {
				isTrue = true;
			}
		}
		catch(NumberFormatException ex) {
			System.out.println("Failed Validation. Please Try Again");			
		}
		
		return isTrue;
	}
}
