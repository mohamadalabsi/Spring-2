package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
      Optional <Student>student1=  repo.getEmail(student.getEmail());

        if (student1.isPresent()) {
            throw  new IllegalStateException("Email is already in use") ;
        }

            return repo.save(student);


    }

//    @Transactional  now the entity in a maneged state
    public Student updateStudent(Long id, Student student) {

       Student student1= repo.findById(id).orElseThrow(()-> new IllegalStateException("Student not found")); // this or down there or like in controller
//      and this IllegalStateException will be by default like INTERNAL_SERVER_ERROR and will stop


        return repo.save(student);
//       if (student1 != null) {
//           return repo.save(student);
//       }
//       else
//           throw  new IllegalStateException("Student not found");
//
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
