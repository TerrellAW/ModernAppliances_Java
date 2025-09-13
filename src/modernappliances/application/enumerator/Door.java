package modernappliances.application.enumerator;

/**
 * Enumerates the valid number of doors in key value pairs for the Refrigerator class
 * @author mr-bones
 * @version 13-09-2025
 */
public enum Door {
	// Values
	TWO(2),
	THREE(3),
	FOUR(4);
	
	// Attributes
	private final int num;
	
	// Getter
	public int getNum() {
		return num;
	}

	// Constructor
	private Door(int num) {
		this.num = num;
	}
	
	// Methods
	/**
	 * Takes an integer and matches it to an enum value. If it matches one of the values it is converted to an enum.
	 * Otherwise it returns an error.
	 * @author mr-bones
	 * @version 13-09-2025
	 * @param count
	 * @return valid door enum
	 */
	public static Door setDoorCount(int count) {
		for (Door door : values()) {
			if (door.num == count) {
				return door;
			}
		}
		throw new IllegalArgumentException("No door type with " + count + " doors");
	}
}
