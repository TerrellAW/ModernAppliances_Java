package modernappliances.application;

/**
 * Enumerates number of doors in a key value pair for the Refrigerator class
 * @author mr-bones
 * @version 09-09-2025
 */
public enum Doors {
	// Values
	TWO("Two", 2),
	THREE("Three", 3),
	FOUR("Four", 4);
	
	// Attributes
	private String numStr;
	private int num;
	
	// Getters and Setters
	public String getNumStr() {
		return numStr;
	}

	public void setNumStr(String numStr) {
		this.numStr = numStr;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// Constructor
	private Doors(String numStr, int num) {
		this.setNumStr(numStr);
		this.setNum(num);
	}
}
