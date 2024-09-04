# Use OpenJDK 21 as the base image
FROM openjdk:21-jdk-slim as build

# Set the working directory in the container
WORKDIR /workspace/app

# Copy the Gradle files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Copy the project source
COPY src src

# Build the application
RUN ./gradlew build -x test

# Create the final image
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the built artifact from the build stage
COPY --from=build /workspace/app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 9192

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]