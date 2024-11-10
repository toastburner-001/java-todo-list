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
        	System.out.println("Welcome to the Task List Manager!");
            
            String mainMenuOptions = "1. Create new task\n2. Browse task list\n3. Exit\n";
            // Main menu loop
    		while (true) {
    			System.out.println("------------------------------------");
    	        String mainSelection = UiUtils.validateInput("[1-3]",
    	        		mainMenuOptions + "Please select an option by typing a number from the menu and press Enter.",
    	        		"Invalid input, please try again.");
    	        
    	        if (mainSelection.equals("1")) {
    	        	Task newTask = TaskUtils.createNewTask();
    	        	
    	        	taskList.add(newTask);
    	        	
    	        	
    	        } else if (mainSelection.equals("2")) {
    	        	if (taskList.size() <= 0) {
    	        		System.out.println("There are no tasks in the list.");
    	        	} else {
    	        		// Enter task list loop
    	        		while (true) {
    	        			System.out.println("------------------------------------");
    	        			if (taskList.size() <= 0) {
    	        				System.out.println("No tasks in list, exiting to menu...");
    	        				break;
    	        			}
    	        			
    	        			System.out.println("[0] Back to main menu");
    	        			
    	        			for (int i = 0; i < taskList.size(); i++) {
    	        				System.out.printf("[%d] %s [DONE: %b]\n", (i + 1), taskList.get(i).getTitle(), taskList.get(i).getDone());
    	        			}
    	        			
    	        			String taskListSelection = UiUtils.validateInput("[0-" + taskList.size() + "]", "Select a task from the menu for further options." , "Invalid input, please try again.");
    	        			
    	        			if (taskListSelection.matches("[1-" + taskList.size() + "]")) {	        		
    	        				int taskIndex = Integer.parseInt(taskListSelection);
    	        				
    	        				Task selectedTask = taskList.get(taskIndex - 1);
    	        			
    	        				// Task options loop
    		        			while (true) {
    		        				System.out.println("------------------------------------");
    		        				System.out.println("Title: " + selectedTask.getTitle());
    		        				System.out.println("DONE: " + selectedTask.getDone());
    		        				System.out.printf("[0] Back to task list\n[1] Change title\n[2] Set done true/false\n[3] Delete task\n");
    		        				String taskOptionsSelection = UiUtils.validateInput("[0-3]", "Choose an option from the menu.", "Invalid input, please try again.");
    		        				
    		        				if (taskOptionsSelection.equals("1")) {
    		        					TaskUtils.changeTaskTitle(selectedTask);
    		        				} else if (taskOptionsSelection.equals("2")) {
    		        					
    		        					if (selectedTask.getDone() == false) {
    		        						selectedTask.setDone(true);
    		        					} else {
    		        						selectedTask.setDone(false);
    		        					}
    		        				} else if (taskOptionsSelection.equals("3")) {
    		        					// Remove task
    		        					taskList.remove(taskIndex - 1);
    		        					System.out.println("Task removed successfully.");
    		        					break;
    		        				} else if (taskOptionsSelection.equals("0")) {
    		        					break;
    		        				}
    		        				
    		        			} 
    	        			} else if (taskListSelection.equals("0")) {
    	        				break;
    	        			}
    	        		}
    	        		
    	 
    	        	}
    	        } else if (mainSelection.equals("3")) {
    	        	System.out.println("Thank you for using the Task List Manager. Have a great day!");
    	        	// Exit loop
    	        	break;
    	        }
            }
    	}
    	
    }
}
