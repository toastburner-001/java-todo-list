package fi.arcada.devops.niskanjo.todolist;

import java.util.Scanner;

public class UiUtils {
	//private static final Scanner scanner = new Scanner(System.in);
	
	
	// Shorthand method for unfiltered user input
	public static String getInput(String prompt) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(prompt);
		
		while (scanner.hasNextLine()) {
			return scanner.nextLine(); 
		}
		
		scanner.close();
		return null;
		
		
	}
	
	public static String validateInput(String regexPattern, String prompt, String errorMsg) {
		Scanner scanner = new Scanner(System.in);
        String validInput = "";
        // Loop until valid input is provided
        while (true) {
            System.out.println(prompt);
            String input = "";
            while (scanner.hasNextLine()) {
            	input = scanner.nextLine();
            }
            
	        // Check if input matches the regex pattern
	        if (input.matches(regexPattern)) {
	        	validInput = input;
	        	
	            break;// Break out of the loop if input is valid
	        } else {
	        	System.out.println(errorMsg);
	        }
            
        }
        scanner.close();

        return validInput;
    }
	
	

}