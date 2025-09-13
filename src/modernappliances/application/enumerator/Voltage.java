package modernappliances.application.enumerator;

/**
 * Enumerates the valid battery voltages in key value pairs for the Vacuum class
 * @author mr-bones
 * @version 09-09-2025
 */
public enum Voltage {
	// Values
	EIGHTEEN(18),
	TWENTY_FOUR(24);
	
	// Attributes
	private int num;
	
	// Getters and Setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	// Constructor
	private Voltage(int num) {
		this.setNum(num);
	}
}
