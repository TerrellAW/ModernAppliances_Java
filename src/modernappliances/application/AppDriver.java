package modernappliances.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modernappliances.application.appliance.*;

/**
 * Main driver class of the program. Contains the entry point.
 * @author mr-bones
 * @version 10-09-2025
 */
public class AppDriver {
	
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
		List<String> applianceData = ReadData();
		List<List<Appliance>> appliances = ParseApplianceData(applianceData);
		
		// Initialize scanner for user input
		Scanner input = new Scanner(System.in);
		
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
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				// Save data
				
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
	private static List<String> ReadData() {
		// Relative file path
		String filePath = "/res/appliances.txt";
		
		// Initialize data list
		List<String> rawData = new ArrayList<>();
		
		// Find and open resource
		try (InputStream inputStream = AppDriver.class.getResourceAsStream(filePath);
			 BufferedReader reader = new BufferedReader(
		     new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
			
			String line;
			while ((line = reader.readLine()) != null) {
				rawData.add(line); // Add each line to list of lines
			}
			
		} catch (IOException e) {
			// Auto-generated error handler
			e.printStackTrace();
		}
		
		return rawData;
	}
	
	/**
	 * 
	 * @return
	 */
	private static List<List<Appliance>> ParseApplianceData(List<String> applianceData) {
		
	}
	
}
