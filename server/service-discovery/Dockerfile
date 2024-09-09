# Use the official OpenJDK image as a parent image
FROM openjdk:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file to the working directory
COPY build/libs/service-discovery-0.0.1-SNAPSHOT.jar service-discovery.jar

# Expose port 8761 to the outside world
EXPOSE 8761

# Run the JAR file
ENTRYPOINT ["java", "-jar", "service-discovery.jar"]