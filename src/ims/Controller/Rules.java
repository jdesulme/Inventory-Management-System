


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
	
	private static double convertToKg(double g) {
		return g / 1000;
	}
	
	/**
	 * Convert milliliters to liters 
	 * @param mL
	 * @return the conversion
	 */
	private  static double convertToLiter(double mL) {
		return mL * (1/1000);
	}
	
	/**
	 * Converts the quantity to proper and standard unit type
	 * @param value
	 * @param unitType
	 * @return
	 */
	public static double GetQuantity(double value, String unitType){
		double convertedValue = 0.0;
		
		if(unitType == "g"){//If unit type is grams convert to kilograms
			convertedValue =  convertToKg(value);
		}
		else if(unitType == "ml"){//If unit type is mili liter convert to liters
			convertedValue =  convertToLiter(value);			
		}
		else{//Do nothing 
			
			convertedValue = value;
		}
		return convertedValue;
	}
	
}
