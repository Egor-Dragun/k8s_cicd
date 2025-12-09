FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests
# Stage 2: Production
FROM eclipse-temurin:17-jdk AS production
WORKDIR /app

# Create a non-root user
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup


# Copy the JAR file from the build stage
COPY --from=build /app/target/revision-app-1.0.0.jar /app/revision-app-1.0.0.jar

# Change ownership to the non-root user
RUN chown appuser:appgroup /app/revision-app-1.0.0.jar

# Switch to non-root user
USER appuser

# Expose the application port
EXPOSE 8080

# Define the entry point
ENTRYPOINT ["java", "-jar", "/app/revision-app-1.0.0.jar"]