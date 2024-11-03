package fi.arcada.devops.niskanjo.todolist;

public class Task {
	
	// Task object containing data of a single task
	
	String title;
	boolean done;
	
	public Task(String title) {
		this.title = title;
		this.done = false;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean getDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
}
