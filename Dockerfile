# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the container
COPY target/niskanjo.todolist-0.0.1-SNAPSHOT.jar /app/todolist.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/todolist.jar"]
