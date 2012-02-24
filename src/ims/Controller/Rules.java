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
		return mL / 1000;
	}
	
	/**
	 * Converts the quantity to proper and standard unit type
	 * @param value
	 * @param unitType
	 * @return
	 */
	public static double GetQuantity(double value, String unitType){
		double convertedValue = 0.0;
		
		if(unitType.equalsIgnoreCase("grams")){//If unit type is grams convert to kilograms
			convertedValue =  convertToKg(value);
		}
		else if(unitType.equalsIgnoreCase("millilters")){//If unit type is mili liter convert to liters
			convertedValue =  convertToLiter(value);			
		}
		else{//Do nothing 
			
			convertedValue = value;
		}
		return convertedValue;
	}
	
	/**
	 * Get Acronym of unitsType based on the project rule
	 * @param: string abbreviation
	 * @return : string acronym
	 */
	public static String  GetAcronymOfUnitType(String abbreviation){
		
		String acronym;
		
		if(abbreviation.equalsIgnoreCase("milliliters")){
			acronym = "L";
		}
		else if(abbreviation.equalsIgnoreCase("liters")){
			acronym = "L";
		}
		else if(abbreviation.equalsIgnoreCase("kilograms")){
			acronym = "kg";
		}
		else if(abbreviation.equalsIgnoreCase("grams")){
			acronym = "kg";
		}
		else{
			acronym = abbreviation;
		}
		
		return acronym;
	}
	
}
