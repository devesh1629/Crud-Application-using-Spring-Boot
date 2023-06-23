package com.devesagr.example.mongo.controller;

import com.devesagr.example.mongo.models.Student;
import com.devesagr.example.mongo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class MyController {

    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student save = this.studentRepository.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }

    @GetMapping("/age")
    public ResponseEntity<String> hello(@RequestBody int age) {
        if(age >= 18)
            return ResponseEntity.ok("You are allowed to vote");
        return ResponseEntity.badRequest().body("You are under age");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        this.studentRepository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
