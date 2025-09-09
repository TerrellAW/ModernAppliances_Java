package modernappliances.application.appliance;

import modernappliances.application.enumerator.Doors;

/**
 * Refrigerator class extends Appliance and implements its own unique attributes and methods.
 * @author mr-bones
 * @version 09-09-2025
 */
public class Refrigerator extends Appliance {
	
	// Attributes
	private Doors doorAmount;
	private int height;
	private int width;
	
	// Getters and Setters
	public Doors getDoorAmount() {
		return doorAmount;
	}

	public void setDoorAmount(Doors doorAmount) {
		this.doorAmount = doorAmount;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	// Constructor
	public Refrigerator(int itemNumber, String brand, int quantity, int wattage, String color, double price, Doors doorAmount, int height, int width) {
		super(itemNumber, brand, quantity, wattage, color, price); // Call from super-class
		this.doorAmount = doorAmount;
		this.height = height;
		this.width = width;
	}

	/**
	 * Returns a string with all the appliance's attributes.
	 * Concatenates to the Appliance super-class' implementation, which it overrides.
	 * @author mr-bones
	 * @version 09-09-2025
	 * @return formatted string with appliance attributes
	 */
	@Override
	public String toString() {
		return super.toString() + "Number of doors: " + getDoorAmount() + "Height: " + getHeight() + "Width: " + getWidth();
	}
	
}
