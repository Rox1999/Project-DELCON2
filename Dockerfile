# Use official OpenJDK 17 as base image
FROM eclipse-temurin:17-jdk-focal

# Set working directory inside the container
WORKDIR /app

# Copy the built Spring Boot jar into the container
COPY target/delcon-ecommerce-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 for Spring Boot
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
