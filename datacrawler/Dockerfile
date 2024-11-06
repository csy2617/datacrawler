# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy the Maven project files and dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy the rest of the application code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Stage 2: Create the Tomcat image with your application
FROM tomcat:10.1.31

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file from the build stage
COPY --from=build /app/target/datacrawler-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8090
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
