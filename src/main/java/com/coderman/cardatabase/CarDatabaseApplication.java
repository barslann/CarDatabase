package com.coderman.cardatabase;

import com.coderman.cardatabase.domain.Car;
import com.coderman.cardatabase.domain.Owner;
import com.coderman.cardatabase.domain.User;
import com.coderman.cardatabase.repo.CarRepository;
import com.coderman.cardatabase.repo.OwnerRepository;
import com.coderman.cardatabase.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CarDatabaseApplication {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;



    public static void main(String[] args) {
//        SpringApplication.run(CarDatabaseApplication.class, args);
        SpringApplication springApplication = new SpringApplication(CarDatabaseApplication.class);
        springApplication.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.print("\n\n\t This is my own banner!\n\n".toUpperCase());
            }
        });

        springApplication.run(args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {

            Owner owner1 = new Owner("Beck", "Ars");
            Owner owner2 = new Owner("Moon", "Koo");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);



            carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121",2017,59000,owner1));
            carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002",2015,25000,owner2));
            carRepository.save(new Car("Toyota", "Camry", "Silver", "KKO-0212",2020,30000,owner2));

            userRepository.save(new User("user", "$2a$10$D8SY7/Y4opDezort4dqh6OplvfBRNnf/0M7agw3tT8rDCF6JHKnZG","USER"));
//            userRepository.save(new User("admin", passwordEncoder.encode("admin"),"ADMIN"));

        };
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



     CommandLineRunner
        allows us to execute additonal code before the application has fully started.





 */