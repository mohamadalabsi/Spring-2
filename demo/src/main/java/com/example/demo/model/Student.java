package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String email;
//    @Transient  so this does that birthdate will not be a column in ur database , but by get method it will be included because in repo we gave it this class name and it will get all the properties from it also if it is not in the db
//    private Date birthdate;
//
//!    this to return exact age using the date
//    public Date getBirthdate() {
//        return Period.between(this.birthdate, LocalDate.now()).getYears();
//    }
//
//
}
