# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

ARG ARTIFACT_ID
ARG VERSION

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the container
COPY target/${ARTIFACT_ID}-${VERSION}.jar /app/todolist.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/todolist.jar"]

# Expose port
EXPOSE 8080

