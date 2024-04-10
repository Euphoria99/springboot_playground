# Springboot_Playground

## Introduction

Springboot_Playground is a basic Spring Boot application for experimentation and learning purposes.

## Prerequisites

- Java Development Kit (JDK) 21.0.2 or later installed on your system.

## Java Version

```
$ java --version
java 21.0.2 2024-01-16 LTS
Java(TM) SE Runtime Environment (build 21.0.2+13-LTS-58)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.2+13-LTS-58, mixed mode, sharing)
```

## Running the Application

### Using Command Line

1. Navigate to the project directory using the command prompt.
2. Run the following command to build the application:
    ```
    mvnw package
    ```
3. After successful build, execute the following command to run the application:
    ```
    java -jar target/name-of-the-jar.jar
    ```
    (Replace `name-of-the-jar` with the actual name of the JAR file generated during the build process.)

### Using Spring Boot Maven Plugin

You can also run the application using the Spring Boot Maven plugin:

```
mvnw spring-boot:run
```

This command will start the Spring Boot application directly from the project directory.
