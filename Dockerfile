#docker files defines how to build and run your spring boot application inside a docker container
# Start from a base image with Java and Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set working directory - all actions will happen inside /app
WORKDIR /app

# Copy your code into the container
COPY . .

# Build the app using Maven - ✅ Runs the Maven build command inside the container, generating the .jar file from your Spring Boot app.
RUN mvn clean package -DskipTests

# Use a smaller JDK image to run the app - ✅ Creates a second container layer, optimized for running (not building). Smaller, faster, more secure.
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the build stage - ✅ Transfers the .jar file from the first container (build stage) into this new one.
COPY --from=builder /app/target/*.jar app.jar


# Run the application - ✅ This is the command that runs your Spring Boot application when the container starts.
ENTRYPOINT ["java", "-jar", "app.jar"]
