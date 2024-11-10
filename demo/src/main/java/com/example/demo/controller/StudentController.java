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
    public ResponseEntity<?> addStudent(@RequestBody Student student) {


        try {
            Student student1 =studentService.addStudent(student);
            return new ResponseEntity<> (student1, HttpStatus.CREATED);
        }
        catch (Exception e) {
          return new ResponseEntity<> (e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




    //    !  Put
    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id ,@RequestBody Student student) {


        Student student1 = studentService.getStudent(id);

        if (student1 == null) {
            return new ResponseEntity<>("there is no student with this Id  ", HttpStatus.NOT_FOUND);

        }
        else {
            try {
               Student updatedStudent= studentService.updateStudent(id, student);
                return new ResponseEntity<>(updatedStudent, HttpStatus.OK);

            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

    //    !  Delete
    @DeleteMapping ("/students/{id}")
    public ResponseEntity<?>  deleteStudent(@PathVariable Long id) {
        Student student1 = studentService.getStudent(id);

        if (student1 == null) {
            return new ResponseEntity<>("there is no student with this Id  ", HttpStatus.NOT_FOUND);

        } else
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Deleted ", HttpStatus.OK);

    }



}
