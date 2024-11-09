package fi.arcada.devops.niskanjo.todolist;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
	
	private static final HashMap<String, String> userDb = new HashMap<String, String>();
	private static final HashMap<String, ArrayList<Task>> taskDb = new HashMap<String, ArrayList<Task>>();
	
	public static final boolean authenticate(final String username, final String password) {
		final String dbPassword = userDb.get(username);
		return(dbPassword != null && dbPassword.equals(password));
	}
	
	public static final ArrayList<Task> getTaskList(final String username) {
		return taskDb.get(username);
	}

	static {
		// Username and password
		userDb.put("JohnDoe", "password");
		userDb.put("Bob", "challenge");
		userDb.put("Alice", "key");
		
		ArrayList<Task> taskList1 = new ArrayList<Task>();
		ArrayList<Task> taskList2 = new ArrayList<Task>();
		ArrayList<Task> taskList3 = new ArrayList<Task>();
    	
    	// Task lists have 1 task each
    	taskList1.add(new Task("Go shopping"));
    	taskList2.add(new Task("Do the laundry"));
    	taskList3.add(new Task("Prepare dinner"));
		
		taskDb.put("JohnDoe", taskList1);
		taskDb.put("Bob", taskList2);
		taskDb.put("Alice", taskList3);
		
	}
}
