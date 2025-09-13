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
	private final int num;
	
	// Getters and Setters
	public int getNum() {
		return num;
	}

	// Constructor
	private Door(int num) {
		this.num = num;
	}
	
	// Methods
	public static Door setDoorCount(int count) {
		for (Door door : values()) {
			if (door.num == count) {
				return door;
			}
		}
		throw new IllegalArgumentException("No door type with " + count + " doors");
	}
}
