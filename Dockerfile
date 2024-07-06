# Use the base image with JDK 17 from Eclipse Temurin
FROM eclipse-temurin:17

# Set the working directory inside the container
WORKDIR /home/app

# Copy the Spring Boot executable JAR file from the target directory to the container
COPY ./target/BaronBoost-0.0.1-SNAPSHOT.jar baronboost.jar

# Copy all HTML files from the current directory into the container's /home/app directory
COPY ./*.html /home/app

# Copy all CSS files from the current directory into the container's /home/app directory
COPY ./*.css /home/app

# Entry point to run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "baronboost.jar"]
