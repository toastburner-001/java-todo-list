package fi.arcada.devops.niskanjo.todolist;

public class TaskUtils {
	
	public static Task createNewTask() {
		// Create new task
		String title = UiUtils.getInput("Enter task title:");
		
		return new Task(title);
	}
	
	public static void changeTaskTitle(Task task) {
		
		String newTitle = UiUtils.getInput("Enter task title:");
		
		task.setTitle(newTitle);
	}
}
