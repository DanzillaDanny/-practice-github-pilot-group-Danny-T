package com.example.demo;

import com.example.demo.model.Students;
import com.example.demo.model.Teachers;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.repository.TeachersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(StudentsRepository studentsRepo, TeachersRepository teachersRepo) {
        return args -> {
            studentsRepo.save(new Students(null, "Alice", "alice@example.com"));
            teachersRepo.save(new Teachers(null, "Mr. Smith", "smith@example.com"));
            System.out.println("Saved sample student and teacher");
        };
    }
}

