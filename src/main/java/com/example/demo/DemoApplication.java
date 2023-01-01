package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository) {
        return (args) -> {
            // save a couple of customers
            personRepository.save(new Person("Jack", "Bauer"));
            personRepository.save(new Person("Chloe", "O'Brian"));
            personRepository.save(new Person("Kim", "Bauer"));
            personRepository.save(new Person("David", "Palmer"));
            personRepository.save(new Person("Michelle", "Dessler"));

            // fetch all customers
            log.info("Person found with findAll():");
            log.info("-------------------------------");

            for (Person person : personRepository.findAll()) {
                log.info(person.toString());
            }

            log.info("-------------------------------");
        };
    }
}