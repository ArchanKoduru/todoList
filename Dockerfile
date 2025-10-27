# Use official OpenJDK 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the built jar into the container
COPY build/libs/TodoList-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the jar
ENTRYPOINT ["java","-jar","app.jar"]
