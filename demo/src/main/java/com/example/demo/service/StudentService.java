package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Student getStudent(Long id) {
        return  repo.findById(id).orElse(null);
    }



    public Student addStudent(Student student) {
        return repo.save(student);
    }


}
