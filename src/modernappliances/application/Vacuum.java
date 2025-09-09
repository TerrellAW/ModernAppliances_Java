package modernappliances.application;

/**
 * Vacuum class extends Appliance and implements its own unique attributes and methods.
 * @author mr-bones
 * @version 09-09-2025
 */
public class Vacuum extends Appliance {
	
	// Attributes
	private String grade;
	private Voltage voltage;
	
	// Getters and Setters
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Voltage getVoltage() {
		return voltage;
	}

	public void setVoltage(Voltage voltage) {
		this.voltage = voltage;
	}

	// Constructor
	public Vacuum(int itemNumber, String brand, int quantity, int wattage, String color, double price, String grade, Voltage voltage) {
		super(itemNumber, brand, quantity, wattage, color, price); // Call from super-class
		this.setGrade(grade);
		this.setVoltage(voltage);
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
		return super.toString() + "Grade: " + getGrade() + "Voltage: " + getVoltage();
	}
	
}
