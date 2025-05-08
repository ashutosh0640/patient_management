# Use the official OpenJDK 21 image
FROM openjdk:21-jdk-slim


# Set the working directory inside the container
WORKDIR /app


# Copy the built JAR file into the container
COPY target/my-spring-boot-app.jar app.jar


# Expose port 8080 (default for Spring Boot)
EXPOSE 8080


# Define the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
