package fi.arcada.devops.niskanjo.todolist;

import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;


/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
		server.createContext("/", new FormHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
		System.out.println("Server started on port 8080");
	}
	
	static class FormHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			if ("GET".equals(exchange.getRequestMethod())) {
				
				String response = "<html><body>" + "<form method='POST'>" + "Username: <input type='text' name='username'><br>"
						+ "Password: <input type='password' name='password'><br>"
						+ "<input type='submit' value='Submit'>" + "</form>" + "</body></html>";
				exchange.sendResponseHeaders(200, response.getBytes().length);
				OutputStream os = exchange.getResponseBody();
				os.write(response.getBytes());
				os.close();
				
			} else if ("POST".equals(exchange.getRequestMethod())) {
				
				StringBuilder sb = new StringBuilder();
				try (var is = exchange.getRequestBody()) {
					int i;
					while ((i = is.read()) != -1)
					{
						sb.append((char) i);
					}
				}
				String[] params = sb.toString().split("&");
				String username = params[0].split("=")[1];
				String password = params[1].split("=")[1];

				String response;
				if (Database.authenticate(username, password))
				{
					final ArrayList<Task> taskList = Database.getTaskList(username);
					StringBuilder taskListStr = new StringBuilder();
					
					taskListStr.append("Welcome to the Task List Manager! Here is your task list.\n");
					for (int i = 0; i < taskList.size(); i++) {
        				taskListStr.append(String.format("[%d] %s [DONE: %b]\n", (i + 1), taskList.get(i).getTitle(), taskList.get(i).getDone()));
        			}
					
					response = (taskListStr.toString());
				} else
				{
					response = "Wrong username or password.";
				}

				exchange.sendResponseHeaders(200, response.getBytes().length);
				OutputStream os = exchange.getResponseBody();
				os.write(response.getBytes());
				os.close();
			}
		}
	}
}
