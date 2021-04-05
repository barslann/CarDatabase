package com.coderman.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDatabaseApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarDatabaseApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CarDatabaseApplication.class, args);
        LOGGER.info("Application started!");
    }

}

/*
    @SpringBootApplication
        Combination of multiple annotations!

        @EnableAutoConfiguration -> This enables Spring Boot automatic configuration.Spring Boot will automatically configure your project
        based on dependencies. For example, if you have spring-boot-starter-web dependency, Spring Bot assumes that you are developing
        a web application and configures your application accordingly!

        @ComponentScan -> This enables Spring Boot component scan to find all the components of your application

        @Configure -> This defines the class that can be used as a source of bean definitions!



     Logger
        Spring Boot starter packages provide a logback that we can use for logging without any configuration.
        Logging message can be seen in the console after running the project


       There are 7 different levels of logging - TRACE, DEBUG, INFO, WARN, ERROR, FATAL and OFF.
        We can configure the level of logging in our application.properties file.
            logging.level.root = INFO
         When we set the log level info, then we can't see the TRACE and DEBUG messages anymore.That might be a good settings for a production version of the app.




      Server
        Spring Boot uses the Apache Tomcat as an application server by default! As a default, Tomcat is running on port 8080.
        We can change the port in the application.properties file.
            server.port = 8081 _> this will start Tomcat on port 8081!

        If the port is occupied, the application wont start!





 */