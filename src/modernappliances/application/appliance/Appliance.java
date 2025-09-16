package modernappliances.application.appliance;

/**
 * Abstract Appliance super-class that is extended by the specific appliance types of Modern Appliances.
 * @author mr-bones
 * @version 16-09-2025
 */
public abstract class Appliance {
	
	// Attributes
	private int itemNumber;
	private String brand;
	private int quantity;
	private int wattage;
	private String color;
	private double price;
	
	// Getters and Setters
	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getWattage() {
		return wattage;
	}

	public void setWattage(int wattage) {
		this.wattage = wattage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// Constructor
	public Appliance(int itemNumber, String brand, int quantity, int wattage, String color, double price) {
		this.itemNumber = itemNumber;
		this.brand = brand;
		this.quantity = quantity;
		this.wattage = wattage;
		this.color = color;
		this.price = price;
	}

	// Methods
	/**
	 * Returns a string with all the appliance's attributes.
	 * Implemented so it can be overridden by sub-classes.
	 * Sub-classes will concatenate their specific toString outputs to this super-class one.
	 * @author mr-bones
	 * @version 08-09-2025
	 * @return formatted string with appliance attributes
	 */
	@Override
	public String toString() {
		return "Item Number: " + getItemNumber() + "Brand: " + getBrand() + "Quantity: " + getQuantity() 
				+ "Wattage: " + getWattage() + "Colour: " + getColor() + "Price: " + getPrice();
	}
	
	/**
	 * Decreases quantity of appliance if it would not result in a number smaller than 0.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @param amount
	 */
	public void decreaseQuantity(int amount) {
		if (getQuantity() >= amount) {	
			setQuantity(-amount);
		} else {
			System.out.println("Not enough Appliances for purchase.");
		}
	}
	
}
