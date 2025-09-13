package modernappliances.application.enumerator;

/**
 * Enumerates the valid room types for the Microwave class
 * @author mr-bones
 * @version 13-09-2025
 */
public enum Room {
	// Values
	K('K'),
	W('W');
	
	// Attributes
	private final char roomRating;
	
	// Getter
	public char getRoomRating() {
		return roomRating;
	}
	
	// Constructor
	private Room(char roomRating) {
		this.roomRating = roomRating;
	}
	
	// Methods
	/**
	 * Takes a char and matches it to an enum value. If it matches one of the values it is converted to an enum.
	 * Otherwise it returns an error.
	 * @author mr-bones
	 * @version 13-09-2025
	 * @param roomChar
	 * @return valid room enum
	 */
	public static Room setRoomRating(char roomChar) {
		for (Room room : values()) {
			if (room.roomRating == roomChar) {
				return room;
			}
		}
		throw new IllegalArgumentException("No room type with " + roomChar + " rating");
	}
}
