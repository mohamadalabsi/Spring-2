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
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student1 = studentService.getStudent(id);

//        1
        if (student1 != null) {
            return new ResponseEntity<> (student1, HttpStatus.OK);

        }
        else
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);

//        2   here it will return ok in either way if or if not the student is there
//            return new ResponseEntity<> (student1, HttpStatus.OK);

    }


    //    !  Post
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {


        try {
            Student student1 =studentService.addStudent(student);
            return new ResponseEntity<> (student1, HttpStatus.CREATED);
        }
        catch (Exception e) {
          return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }






}
