package modernappliances.application.enumerator;

/**
 * Enumerates the valid battery voltages in key value pairs for the Vacuum class
 * @author mr-bones
 * @version 13-09-2025
 */
public enum Voltage {
	// Values
	EIGHTEEN(18),
	TWENTY_FOUR(24);
	
	// Attributes
	private final int num;
	
	// Getter
	public int getNum() {
		return num;
	}
	
	// Constructor
	private Voltage(int num) {
		this.num = num;
	}
	
	// Methods
	/**
	 * Takes an integer and matches it to an enum value. If it matches one of the values it is converted to an enum.
	 * Otherwise it returns an error.
	 * @author mr-bones
	 * @version 13-09-2025
	 * @param volNum
	 * @return valid voltage enum
	 */
	public static Voltage setVoltageNum(int volNum) {
		for (Voltage voltage : values()) {
			if (voltage.num == volNum) {
				return voltage;
			}
		}
		throw new IllegalArgumentException("No door type with " + volNum + " doors");
	}
}
