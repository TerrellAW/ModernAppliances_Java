package modernappliances.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modernappliances.application.appliance.*;
import modernappliances.application.enumerator.*;

/**
 * Main driver class of the program. Contains the entry point.
 * @author mr-bones
 * @version 13-09-2025
 */
public class AppDriver {
	// Initialize scanner for user input
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * Main entry point of program. Calls all the functions needed for program features.
	 * Contains main menu for displaying options and accepting user input for choosing options.
	 * @author mr-bones
	 * @version 10-09-2025
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialization
		boolean running = true;
		// Load and parse data
		List<String> applianceData = readData();
		List<List<Appliance>> appliances = parseApplianceData(applianceData);
		
		// Main menu
		/**
		 * Main menu loop. Continues looping until user ends the program by saving and exiting.
		 * Has input validation and restarts when user makes an invalid input.
		 * @author mr-bones
		 * @version 10-09-2025
		 */
		while (running) {
			System.out.println(
					"Welcome to Modern Appliances!\n"
							+ "How may we assist you?\n"
							+ "1 - Check out appliance\n"
							+ "2 - Find appliances by brand\n"
							+ "3 - Display appliances by type\n"
							+ "4 - Produce random appliance list\n"
							+ "5 - Save & exit");
			
			// Take user input
			String option = input.nextLine();
			
			// Input validation
			switch (option) {
			case "1":
				purchaseAppliance(appliances);
				break;
			case "2":
				searchAppliancesBrand(appliances);
				break;
			case "3":
				displayAppliancesType(appliances);
				break;
			case "4":
				generateRandomList(appliances);
				break;
			case "5":
				// Save data
				storeData(appliances);
				// End main program loop
				running = false;
				break;
			default:
				// Notify user of incorrect input and try again
				System.out.println("Invalid option. Try again.");
				break;
			}
			
		}
		
		// Close scanner and end program
		input.close();
		return;
	}

	/**
	 * Method for reading data from the appliances.txt resource file.
	 * Will read line by line and add these lines as strings to a list of strings.
	 * Each line contains information on a single appliance.
	 * @author mr-bones
	 * @version 11-09-2025
	 * @return list of strings, each string is one appliance
	 */
	private static List<String> readData() {
		// Relative file path
		String filePath = "/res/appliances.txt";
		
		// Initialize data list
		List<String> rawData = new ArrayList<>();
		
		// Find and open resource
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				rawData.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return rawData;
	}
	
	/**
	 * This method parses the list of strings from ReadData() into a list of Appliance objects.
	 * @author mr-bones
	 * @version 13-09-2025
	 * @return nested generic collection of Appliance objects
	 */
	private static List<List<Appliance>> parseApplianceData(List<String> applianceData) {
		// Initialize nested lists of Appliance objects
		List<List<Appliance>> appliancesList = new ArrayList<>();
		
		// Sub-class lists
		List<Refrigerator> refrigerators = new ArrayList<>();
		List<Microwave> microwaves = new ArrayList<>();
		List<Vacuum> vacuums = new ArrayList<>();
		List<Dishwasher> dishwashers = new ArrayList<>();
		
		// For each loop and lambda used for sorting data into appropriate list
		applianceData.forEach(item -> {
			// Split each appliance string into an array of appliance attributes
			String[] segments = item.split(";");
			
			// Identify appliance type using first number of ID
			char applianceType = segments[0].charAt(0);
			
			// Convert char to int
			int applianceTypeInt = Character.getNumericValue(applianceType);
			
			// Create appliance objects based on type
			switch (applianceTypeInt) {
				
			// Refrigerator
			case 1:
				// Validate doors with enum
				int doors = Integer.parseInt(segments[6]);
				if (doors == 2 || doors == 3 || doors == 4) {
					
					// Convert valid int to enum
					Door doorAmount = Door.setDoorCount(doors);
					
					// Add to list
					refrigerators.add(
							new Refrigerator(
									Integer.parseInt(segments[0]), // Item Number
									segments[1], // Brand
									Integer.parseInt(segments[2]), // Quantity
									Integer.parseInt(segments[3]), // Wattage
									segments[4], // Colour
									Double.parseDouble(segments[5]), // Price
									doorAmount, // Door Amount
									Integer.parseInt(segments[7]), // Height
									Integer.parseInt(segments[8]) // Width
									)
							);					
				}
				break;
				
			// Vacuum
			case 2:
				// Validate voltage with enum
				int voltage = Integer.parseInt(segments[7]);
				if (voltage == 18 || voltage == 21) {
					
					// Convert valid int to enum
					Voltage voltAmount = Voltage.setVoltageNum(voltage);
					
					// Add to list
					vacuums.add(
							new Vacuum(
									Integer.parseInt(segments[0]), // Item Number
									segments[1], // Brand
									Integer.parseInt(segments[2]), // Quantity
									Integer.parseInt(segments[3]), // Wattage
									segments[4], // Colour
									Double.parseDouble(segments[5]), // Price
									segments[6], // Grade
									voltAmount // Voltage
									)
							);
				}
				break;
				
			// Microwave
			case 3:
				// Validate room with enum
				char room = segments[7].charAt(0);
				if (room == 'K' || room == 'W') {
					
					// Convert valid char to enum
					Room roomType = Room.setRoomRating(room);
					
					// Add to list
					microwaves.add(
							new Microwave(
									Integer.parseInt(segments[0]), // Item Number
									segments[1], // Brand
									Integer.parseInt(segments[2]), // Quantity
									Integer.parseInt(segments[3]), // Wattage
									segments[4], // Colour
									Double.parseDouble(segments[5]), // Price
									Double.parseDouble(segments[6]), // Capacity
									roomType // Room Rating
									)
							);					
				}
				break;
				
			// First Dishwasher
			case 4:
				// Validate sound with enum
				String sound = segments[7];
				if (sound == "Qt" || sound == "Qr" || sound == "Qu" || sound == "M") {
					
					// Convert valid String to enum
					Sound soundType = Sound.setSoundRating(sound);
					
					// Add to list
					dishwashers.add(
							new Dishwasher(
									Integer.parseInt(segments[0]), // Item Number
									segments[1], // Brand
									Integer.parseInt(segments[2]), // Quantity
									Integer.parseInt(segments[3]), // Wattage
									segments[4], // Colour
									Double.parseDouble(segments[5]), // Price
									segments[6], // Feature
									soundType // Sound Rating
									)
							);
				}
				break;
				
			// Second Dishwasher
			case 5:
				// Validate sound with enum
				String sound2 = segments[7];
				if (sound2 == "Qt" || sound2 == "Qr" || sound2 == "Qu" || sound2 == "M") {
					
					// Convert valid String to enum
					Sound soundType2 = Sound.setSoundRating(sound2);
					
					// Add to list
					dishwashers.add(
							new Dishwasher(
									Integer.parseInt(segments[0]), // Item Number
									segments[1], // Brand
									Integer.parseInt(segments[2]), // Quantity
									Integer.parseInt(segments[3]), // Wattage
									segments[4], // Colour
									Double.parseDouble(segments[5]), // Price
									segments[6], // Feature
									soundType2 // Sound Rating
									)
							);
				}
				break;
			}
		});
		
		// Add subclass lists to nested Appliance list
		appliancesList.add(new ArrayList<Appliance>(refrigerators));
		appliancesList.add(new ArrayList<Appliance>(microwaves));
		appliancesList.add(new ArrayList<Appliance>(vacuums));
		appliancesList.add(new ArrayList<Appliance>(dishwashers));
		
		return appliancesList;
	}
	
	/**
	 * 
	 * @param appliances
	 */
	private static void purchaseAppliance(List<List<Appliance>> appliances) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param appliances
	 */
	private static void searchAppliancesBrand(List<List<Appliance>> appliances) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param appliances
	 */
	private static void displayAppliancesType(List<List<Appliance>> appliances) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param appliances
	 */
	private static void generateRandomList(List<List<Appliance>> appliances) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param appliances
	 */
	private static void storeData(List<List<Appliance>> appliances) {
		// TODO Auto-generated method stub
		
	}
	
}
