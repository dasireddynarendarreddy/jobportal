# Use a base image with Java installed
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the .war file to the container
COPY target/SpringRestPortal-0.0.1-SNAPSHOT.war app.war

# Run the Spring Boot application using the .war
ENTRYPOINT ["java", "-jar", "app.war"]
