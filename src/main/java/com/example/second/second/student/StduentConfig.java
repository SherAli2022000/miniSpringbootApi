package com.example.second.second.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StduentConfig {

    @Bean
    CommandLineRunner commandLineRunner(DepartmentRepository departmentRepository,StudentRepository studentRepository){
        return  args -> {

            Department department1= new Department("dep1");
            Department department2= new Department("dep2");
            departmentRepository.saveAll(List.of(department2,department1));

            student student1 = new student(
                    "2007",
                    "ali",
                    "ali@yopmail.com",
                    LocalDate.of(2000, Month.FEBRUARY,20),
                    department1);

            student student2 = new student(
                    "300",
                    "Sjhah",
                    "shah@yopmail.com",
                    LocalDate.of(2002, Month.FEBRUARY,20),department2);
            studentRepository.saveAll(List.of(student1,student2));
        };
    };

}
