package com.devesagr.example.mongo.repo;

import com.devesagr.example.mongo.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
}
