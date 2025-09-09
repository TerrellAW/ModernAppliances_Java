package modernappliances.application;

/**
 * Enumerates the valid battery voltages in key value pairs for the Vacuum class
 * @author mr-bones
 * @version 09-09-2025
 */
public enum Voltage {
	// Values
	EIGHTEEN("Eighteen", 18),
	TWENTY_FOUR("Twenty Four", 24);
	
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
	private Voltage(String numStr, int num) {
		this.setNumStr(numStr);
		this.setNum(num);
	}
}
