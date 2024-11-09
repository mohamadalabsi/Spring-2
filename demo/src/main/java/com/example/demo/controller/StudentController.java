package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {



    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //    !  Get
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return new ResponseEntity<> (students, HttpStatus.OK);
    }

    //    !  Post
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {

        Student student1 =studentService.addStudent(student);
        return new ResponseEntity<> (student1, HttpStatus.CREATED);
    }

//
//    //    !  Get
//    @GetMapping("/students")
//    public StudentService getStudentService() {
//        return studentService.getStudents();
//    }
//
//    //    !  Get
//    @GetMapping("/students")
//    public StudentService getStudentService() {
//        return studentService.getStudents();
//    }




}
