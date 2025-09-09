package modernappliances.application;

/**
 * Dishwasher class extends Appliance and implements its own unique attributes and methods.
 * @author mr-bones
 * @version 09-09-2025
 */
public class Dishwasher extends Appliance {
	
	// Attributes
	private String feature;
	private Sound soundRating;
	
	// Getters and Setters
	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Sound getSoundRating() {
		return soundRating;
	}

	public void setSoundRating(Sound soundRating) {
		this.soundRating = soundRating;
	}

	// Constructor
	public Dishwasher(int itemNumber, String brand, int quantity, int wattage, String color, double price, String feature, Sound soundRating) {
		super(itemNumber, brand, quantity, wattage, color, price); // Call from super-class
		this.feature = feature;
		this.soundRating = soundRating;
	}

	// Methods
	/**
	 * Returns a string with all the appliance's attributes.
	 * Concatenates to the Appliance super-class' implementation, which it overrides.
	 * @author mr-bones
	 * @version 09-09-2025
	 * @return formatted string with appliance attributes
	 */
	@Override
	public String toString() {
		return super.toString() + "Feature: " + getFeature() + "Sound Rating: " + getSoundRating();
	}
	
}
