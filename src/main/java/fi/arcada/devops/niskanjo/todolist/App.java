package fi.arcada.devops.niskanjo.todolist;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	ArrayList<Task> taskList = new ArrayList<Task>();
    	
    	// Task list placeholder
    	taskList.add(new Task("Go shopping"));
    	taskList.add(new Task("Do the laundry"));
    	taskList.add(new Task("Prepare dinner"));
    	
    	
        for (int i = 0; i < taskList.size(); i++) {
        	Task taskEntry = taskList.get(i);
        	System.out.print(String.format("[%d] %s | Done: %s\n", (i + 1), taskEntry.getTitle(), taskEntry.getDone()));
        }
    }
}
