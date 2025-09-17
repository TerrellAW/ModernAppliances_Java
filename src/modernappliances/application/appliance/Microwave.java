package modernappliances.application.appliance;

import modernappliances.application.enumerator.Room;

/**
 * Microwave class extends Appliance and implements its own unique attributes and methods.
 * @author mr-bones
 * @version 16-09-2025
 */
public class Microwave extends Appliance {
	
	// Attributes
	private double capacity;
	private Room roomType;
	
	// Getters and Setters
	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public Room getRoomType() {
		return roomType;
	}

	public void setRoomType(Room roomType) {
		this.roomType = roomType;
	}

	// Constructor
	public Microwave(int itemNumber, String brand, int quantity, int wattage, String color, double price, double capacity, Room roomType) {
		super(itemNumber, brand, quantity, wattage, color, price); // Call from super-class
		this.capacity = capacity;
		this.roomType = roomType;
	}

	// Methods
	/**
	 * Returns a string with all the appliance's attributes.
	 * Concatenates to the Appliance super-class' implementation, which it overrides.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @return formatted string with appliance attributes
	 */
	@Override
	public String toString() {
		return super.toString() + " Capacity: " + getCapacity() + " Room Type: " + getRoomType();
	}
	
}
