# Use official OpenJDK runtime as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/agenda-api-1.0.0.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Entry point to run the application
ENTRYPOINT ["java","-jar","/app/app.jar"]