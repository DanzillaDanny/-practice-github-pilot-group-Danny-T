package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Teachers;
import com.example.demo.repository.TeachersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeachersController {
    private final TeachersRepository teachersRepository;

    public TeachersController(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }

    @GetMapping
    public List<Teachers> getAll() {
        return teachersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teachers getById(@PathVariable Long id) {
        return teachersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + id));
    }

    @PostMapping
    public Teachers create(@RequestBody Teachers teacher) {
        teacher.setId(null);
        return teachersRepository.save(teacher);
    }

    @PutMapping("/{id}")
    public Teachers update(@PathVariable Long id, @RequestBody Teachers teacher) {
        Teachers existing = teachersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + id));
        existing.setName(teacher.getName());
        existing.setEmail(teacher.getEmail());
        return teachersRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Teachers existing = teachersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + id));
        teachersRepository.delete(existing);
        return ResponseEntity.noContent().build();
    }
}

