package fi.arcada.devops.niskanjo.todolist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testInstantiateTask() {
		Task newTask = new Task("Test the task constructor");
		
		assertEquals("Test the task constructor", newTask.getTitle());
		
		// Done status should return false when instantiated
		assertFalse(newTask.getDone());
	}

	@Test
	void testSetTitle() {
		Task newTask = new Task("Original title");
		
		newTask.setTitle("New title");
		
		assertEquals("New title", newTask.getTitle());
	}

	@Test
	void testSetDone() {
		Task newTask = new Task("Test the done status");
		
		newTask.setDone(true);
		
		// Done status should return newly set
		assertTrue(newTask.getDone());
		
	}
}
