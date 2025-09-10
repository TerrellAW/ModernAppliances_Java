package modernappliances.application;

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
	
	
	
}
