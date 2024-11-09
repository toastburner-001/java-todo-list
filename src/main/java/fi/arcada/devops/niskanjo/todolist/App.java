package fi.arcada.devops.niskanjo.todolist;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	String username = "";
    	boolean authSuccess = false;

    	// Prompt username and password, loop until valid credentials are received
    	while (!authSuccess) {
    		username = UiUtils.getInput("Enter username:");
    		String password = UiUtils.getInput("Enter password:");
    		
    		authSuccess = Database.authenticate(username, password);
    		
    		if (!authSuccess) {
    			System.out.println("Wrong username or password, try again.");
    		}
    	}
    	
    	// Get task list associated with user
    	if (authSuccess) {
    		ArrayList<Task> taskList = Database.getTaskList(username);
    	
    		// Display task list
    		for (int i = 0; i < taskList.size(); i++) {
    			Task taskEntry = taskList.get(i);
    			System.out.print(String.format("[%d] %s | Done: %s\n", (i + 1), taskEntry.getTitle(), taskEntry.getDone()));
    		}
    	}
    	
    }
}
