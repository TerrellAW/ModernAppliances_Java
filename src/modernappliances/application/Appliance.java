package modernappliances.application;

/**
 * Abstract Appliance super-class that is extended by the specific appliance types of Modern Appliances.
 * @author mr-bones
 * @version 08-09-2025
 */
public abstract class Appliance {
	
	// Constructor
	public Appliance() {
		
	}

	/**
	 * Implemented so it can be overridden by sub-classes.
	 * Sub-classes will concatenate their specific toString outputs to this super-class one.
	 * @author mr-bones
	 * @version 08-09-2025
	 */
	public String toString() {
		return "";
	}
	
}
