package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private StudentRepo repo;
    @Autowired
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }



    public List<Student> getStudents() {
     return   repo.findAll();

    }

    public Student addStudent(Student student) {
        return repo.save(student);
    }
}
