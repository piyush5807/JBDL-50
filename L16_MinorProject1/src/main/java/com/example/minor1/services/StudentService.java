package com.example.minor1.services;

import com.example.minor1.models.Student;
import com.example.minor1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void create(Student student) {
        studentRepository.save(student);
    }

    public Student find(int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
}
