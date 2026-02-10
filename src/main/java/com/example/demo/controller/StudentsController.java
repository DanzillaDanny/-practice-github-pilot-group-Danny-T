package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Students;
import com.example.demo.repository.StudentsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private final StudentsRepository studentsRepository;

    public StudentsController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping
    public List<Students> getAll() {
        return studentsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Students getById(@PathVariable Long id) {
        return studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    @PostMapping
    public Students create(@RequestBody Students student) {
        student.setId(null);
        return studentsRepository.save(student);
    }

    @PutMapping("/{id}")
    public Students update(@PathVariable Long id, @RequestBody Students student) {
        Students existing = studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        return studentsRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Students existing = studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        studentsRepository.delete(existing);
        return ResponseEntity.noContent().build();
    }
}

