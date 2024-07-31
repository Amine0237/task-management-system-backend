FROM openjdk:17-jdk-alpine

# Add Maintainer Info
LABEL maintainer="youremail@example.com"

# The application's jar file
ARG JAR_FILE=/target/task-management-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} task-management-0.0.1-SNAPSHOT.jar

# Expose the port on which the app runs
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
