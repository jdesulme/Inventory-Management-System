/**
 * 
 */
package ims.Model;

/**
 * @author Minh, Kumar, Jean
 *
 */
public class UIEstimation extends EntityBase {
	public int pizzaNumber;
	public String pizzaName;
	public String pizzaSize;
	
	public String toString() {
		return String.format("Pizza Number: %d, Pizza Name: %s, Pizza Size: %s", pizzaNumber, pizzaName, pizzaSize);
	}
	
	
}
