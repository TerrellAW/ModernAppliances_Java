package modernappliances.application.enumerator;

/**
 * Enumerates the valid number of doors in key value pairs for the Refrigerator class
 * @author mr-bones
 * @version 09-09-2025
 */
public enum Door {
	// Values
	TWO(2),
	THREE(3),
	FOUR(4);
	
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
	private Door(int num) {
		this.setNum(num);
	}
}
