/**
 * 
 */
package ims.Controller;

/**
 * Rules class that converts units
 * @author Minh, Kumar, Jean
 *
 */
public class Rules {
	
	/**
	 * Convert grams to kilograms
	 * @param g
	 * @return
	 */
	
	public static double convertToKg(int g) {
		return g / 1000;
	}
	
	/**
	 * Convert milliliters to liters 
	 * @param mL
	 * @return the conversion
	 */
	public static double convertToLiter(double mL) {
		return mL * (1/1000);
	}
}
