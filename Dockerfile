# ======== Stage 1: Build the application ========
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /build

# Copy everything into the container
COPY . .

# Build the WAR file using Maven
RUN mvn clean package -DskipTests

# ======== Stage 2: Run the application ========
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built WAR from the builder stage
COPY --from=builder /build/target/SpringRestPortal-0.0.1-SNAPSHOT.war app.war

# Expose the default port
EXPOSE 8080

# Run the WAR file
ENTRYPOINT ["java", "-jar", "app.war"]
