# Use the official Maven image as the base image
FROM maven AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the Maven project
RUN mvn clean install

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["mvn", "spring-boot:run"]
