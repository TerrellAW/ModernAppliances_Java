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
		System.out.println("Loading...");
		// Read and parse appliance data here
		
		// Refresh console
		System.out.println("\033[H\033[2J");
		
		// Main menu
		/**
		 * Main menu loop. Continues looping until user ends the program by saving and exiting.
		 * Has input validation and restarts when user makes an invalid input.
		 * @author mr-bones
		 * @version 10-09-2025
		 */
		while (true) {
			System.out.println(
					"Welcome to Modern Appliances!\n"
							+ "How may we assist you?\n"
							+ "1 - Check out appliance\n"
							+ "2 - Find appliances by brand\n"
							+ "3 - Display appliances by type\n"
							+ "4 - Produce random appliance list\n"
							+ "5 - Save & exit");
			
			// Initialize scanner for user input
			Scanner input = new Scanner(System.in);
			// Take first char from input
			String option = input.next();
			
			// Input validation
			switch (option) {
			case "1":
				// Close scanner and call chosen function
				input.close();
				break;
			case "2":
				// Close scanner and call chosen function
				input.close();
				break;
			case "3":
				// Close scanner and call chosen function
				input.close();
				break;
			case "4":
				// Close scanner and call chosen function
				input.close();
				break;
			case "5":
				// Close scanner and call chosen function
				input.close();
				// End main program loop
				return;
			default:
				// Notify user of incorrect input and try again
				System.out.println("Invalid option. Try again.");
				break;
			}
			
			// Close scanner
			input.close();
		}
	}
	
	
	
}
