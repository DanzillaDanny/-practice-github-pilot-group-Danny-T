package com.example.demo.controller;

import com.example.demo.model.Teachers;
import com.example.demo.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public List<Teachers> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teachers> getTeacherById(@PathVariable Long id) {
        Optional<Teachers> t = teacherRepository.findById(id);
        return t.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Teachers> createTeacher(@RequestBody Teachers teacher) {
        Teachers saved = teacherRepository.save(teacher);
        return ResponseEntity.created(URI.create("/teachers/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teachers> updateTeacher(@PathVariable Long id, @RequestBody Teachers teacher) {
        return teacherRepository.findById(id).map(existing -> {
            existing.setName(teacher.getName());
            existing.setEmail(teacher.getEmail());
            Teachers updated = teacherRepository.save(existing);
            return ResponseEntity.ok(updated);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        if (!teacherRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        teacherRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
