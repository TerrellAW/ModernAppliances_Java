package modernappliances.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import modernappliances.application.appliance.*;
import modernappliances.application.enumerator.*;

/**
 * Main driver class of the program. Contains the entry point.
 * @author mr-bones
 * @version 16-09-2025
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
	 * @exception FileNotFoundException
	 */
	private static List<String> readData() {
		// Relative file path
		String filePath = "res/appliances.txt";
		
		// Initialize data list
		List<String> rawData = new ArrayList<>();
		
		// Find and open resource
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				rawData.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
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
	
	// Appliance purchasing system methods
	
	/**
	 * Method that gets user input and converts it into an integer. 
	 * It catches number format exceptions to prevent crashing the application.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @return inputNum from user inputted string
	 * @exception NumberFormatException
	 */
	private static int getUserInput() {
		// Initialize variables
		boolean exception = true;
		int inputNum = 0;
		
		// Get user input for appliance number
		System.out.println("Enter the appliance number: ");
		while (exception == true) {
			// Catch invalid inputs
			try {
				inputNum = Integer.parseInt(input.nextLine());
				exception = false;
			} catch (NumberFormatException e) {
				System.out.println("Invalid output. Please enter a number.");
			}
		}
		
		return inputNum;
	}
	
	/**
	 * Searches through the nested collection of Appliances using the appliance's item number.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @param appliancesList
	 * @return Appliance object or null
	 */
	private static Appliance searchApplianceNumber(List<List<Appliance>> appliancesList) {
		// Initialize variable
		int inputNum = getUserInput();
		
		// Find appliance number
		for (List<Appliance> appliances : appliancesList) {
			for (Appliance appliance : appliances) {
				if (appliance.getItemNumber() == inputNum) {
					return appliance;
				}
			}
		}
		
		System.out.println("Appliance not found.");
		return null;
	}
	
	/**
	 * Simulates purchasing an appliance by decreasing its quantity.
	 * If there are 0 appliances it will warn the user that appliances are out of stock and not decrease quantity.
	 * If there are less appliances than the amount the user purchases, decreaseQuantity() will notify
	 * the user that there are not enough appliances and not decrease quantity.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @param appliancesList
	 */
	private static void purchaseAppliance(List<List<Appliance>> appliancesList) {
		// Initialize variable
		Appliance appliance = null;
		
		while (appliance == null) {
			// Use search method
			appliance = searchApplianceNumber(appliancesList);
			
			// Check availability
			if (appliance != null && appliance.getQuantity() > 0) {
				System.out.println("How many would you like to purchase: ");
				int purchaseAmount = getUserInput();
				
				// Decrase amount of available appliances
				appliance.decreaseQuantity(purchaseAmount);
			} else {
				System.out.println("Appliance out of stock.");
			}
		}
	}
	
	/**
	 * Searches for Appliances of a given brand name and displays a list of them.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @param appliancesList
	 */
	private static void searchAppliancesBrand(List<List<Appliance>> appliancesList) {
		// Non case-sensitive search system
		System.out.println("Enter the brand: ");
		String brand = input.nextLine().toLowerCase();
		
		List<Appliance> brandAppliances = new ArrayList<>();
		
		for (List<Appliance> appliances : appliancesList) {
			for (Appliance appliance : appliances) {
				if (appliance.getBrand().toLowerCase().equals(brand)) {
					brandAppliances.add(appliance);
				}
			}
		}
		
		if (!brandAppliances.isEmpty()) {
			System.out.println("Brand Appliances: ");
			for (Appliance appliance : brandAppliances) {
				System.out.println(appliance.toString());
			}
		} else {
			System.out.println("No Appliances found.");
		}
	}

	/**
	 * Displays appliances in a list of appliances of the same type.
	 * Takes user input to choose an appliance type to display.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @param appliancesList
	 */
	private static void displayAppliancesType(List<List<Appliance>> appliancesList) {
		System.out.println(
				"Appliances Type\n"
				+ "1 - Refrigerators\n"
				+ "2 - Vacuums\n"
				+ "3 - Microwaves\n"
				+ "4 - Dishwashers\n"
				+ "Enter the type of Appliance: ");
		String type = input.nextLine();
		
		List<Appliance> chosenAppliances = new ArrayList<>();
		switch (type) {
		case "1":
			chosenAppliances = appliancesList.get(0);
			break;
		case "2":
			chosenAppliances = appliancesList.get(1);
			break;
		case "3":
			chosenAppliances = appliancesList.get(2);
			break;
		case "4":
			chosenAppliances = appliancesList.get(3);
			break;
		default:
			System.out.println("Invalid option. Try again.");
			return;
		}
		for (Appliance appliance : chosenAppliances) {
			System.out.println(appliance.toString());
		}
	}

	/**
	 * Chooses the given amount of random appliances to display in a list.
	 * Takes user input to determine amount of appliances to add to list.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @param appliancesList
	 */
	private static void generateRandomList(List<List<Appliance>> appliancesList) {
		// Take user input
		System.out.println("Enter number of appliances: ");
		int num = Integer.parseInt(input.nextLine());
		
		// Initialize objects
		Random random = new Random();
		List<Appliance> chosenAppliances = new ArrayList<>();
		System.out.println("Random Appliances: ");
		
		while (chosenAppliances.size() < num) {
			// Select random sublist index
			int listI = random.nextInt(appliancesList.size());
			List<Appliance> sublist = appliancesList.get(listI);
			
			// Select random appliance from the sublist
			int applianceI = random.nextInt(sublist.size());
			Appliance randomAppliance = sublist.get(applianceI);
			
			// Add to list
			if (!chosenAppliances.contains(randomAppliance)) {
				chosenAppliances.add(randomAppliance);
				System.out.println("Item Number: " + randomAppliance.getItemNumber() + ", Brand: " + randomAppliance.getBrand());
			}
		}
	}

	/**
	 * Adds data stored in appliancesList to the appliances.txt file for storage.
	 * @author mr-bones
	 * @version 16-09-2025
	 * @param appliancesList
	 */
	private static void storeData(List<List<Appliance>> appliancesList) {
		// Relative file path
		String filePath = "res/appliances.txt";
		
		// Find and open resource
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			for (List<Appliance> appliances : appliancesList) {
				for (Appliance appliance : appliances) {
					if (appliance instanceof Refrigerator) {
						Refrigerator refrigerator = (Refrigerator) appliance;
						writer.println(
								refrigerator.getItemNumber() 
								+ ";" 
								+ refrigerator.getBrand() 
								+ ";" 
								+ refrigerator.getQuantity()
								+ ";"
								+ refrigerator.getWattage()
								+ ";"
								+ refrigerator.getColor()
								+ ";"
								+ refrigerator.getPrice()
								+ ";"
								+ refrigerator.getDoorAmount()
								+ ";"
								+ refrigerator.getHeight()
								+ ";"
								+ refrigerator.getWidth()
								+ ";");
					}
					else if (appliance instanceof Vacuum) {
						Vacuum vacuum = (Vacuum) appliance;
						writer.println(
								vacuum.getItemNumber() 
								+ ";" 
								+ vacuum.getBrand() 
								+ ";" 
								+ vacuum.getQuantity()
								+ ";"
								+ vacuum.getWattage()
								+ ";"
								+ vacuum.getColor()
								+ ";"
								+ vacuum.getPrice()
								+ ";"
								+ vacuum.getGrade()
								+ ";"
								+ vacuum.getVoltage()
								+ ";");
					}
					else if (appliance instanceof Microwave) {
						Microwave microwave = (Microwave) appliance;
						writer.println(
								microwave.getItemNumber() 
								+ ";" 
								+ microwave.getBrand() 
								+ ";" 
								+ microwave.getQuantity()
								+ ";"
								+ microwave.getWattage()
								+ ";"
								+ microwave.getColor()
								+ ";"
								+ microwave.getPrice()
								+ ";"
								+ microwave.getCapacity()
								+ ";"
								+ microwave.getRoomType()
								+ ";");
					}
					else if (appliance instanceof Dishwasher) {
						Dishwasher dishwasher = (Dishwasher) appliance;
						writer.println(
								dishwasher.getItemNumber() 
								+ ";" 
								+ dishwasher.getBrand() 
								+ ";" 
								+ dishwasher.getQuantity()
								+ ";"
								+ dishwasher.getWattage()
								+ ";"
								+ dishwasher.getColor()
								+ ";"
								+ dishwasher.getPrice()
								+ ";"
								+ dishwasher.getFeature()
								+ ";"
								+ dishwasher.getSoundRating()
								+ ";");
					}
				}
			}
			System.out.println("Data stored successfully.");
		} catch (IOException e) {
			System.out.println("Error in storing data: " + e.getMessage());
		}
	}
	
}
