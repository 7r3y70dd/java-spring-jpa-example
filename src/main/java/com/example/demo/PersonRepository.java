package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByFirstName(@Param("name") String name);

    List<Person> findByLastName(@Param("name") String name);

    List<Person> findByFirstNameOrLastName(@Param("fname") String firstName, @Param("lname") String lastName);

    List<Person> findByFirstNameAndLastName(@Param("fname") String firstName, @Param("lname") String lastName);
}