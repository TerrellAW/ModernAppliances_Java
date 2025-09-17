package modernappliances.application.enumerator;

/**
 * Enumerates the valid sound ratings for the Dishwasher class
 * @author mr-bones
 * @version 13-09-2025
 */
public enum Sound {
	// Values
	Qt("Qt"),
	Qr("Qr"),
	Qu("Qu"),
	M("M");
	
	// Attributes
	private final String soundRating;
	
	// Getter
	public String getSoundRating() {
		return soundRating;
	}
	
	// Constructor
	private Sound(String soundRating) {
		this.soundRating = soundRating;
	}
	
	// Methods
	/**
	 * Takes a string and matches it to an enum value. If it matches one of the values it is converted to an enum.
	 * Otherwise it returns an error.
	 * @author mr-bones
	 * @version 13-09-2025
	 * @param soundStr
	 * @return valid sound enum
	 */
	public static Sound setSoundRating(String soundStr) {
		for (Sound sound : values()) {
			if (sound.soundRating.equals(soundStr)) {
				return sound;
			}
		}
		throw new IllegalArgumentException("No sound type with " + soundStr + " rating");
	}
}
