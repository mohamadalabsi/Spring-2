package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sound.midi.Sequence;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table (name = "student_table",
      uniqueConstraints = {
         @UniqueConstraint(name = "student_email", columnNames = "email")
      })
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) this or down
//    now this to specify the name of the column in the database and some other things
    @SequenceGenerator( name = "student_sequence",
                        sequenceName = "student_sequence",
                         allocationSize = 1)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE , generator = "student_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition = "Text")
    private String name;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "email", nullable = false, columnDefinition = "Text"
//            , unique = true this should not be written here if you want to change the name , but if it does not matter u should write it
    )
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
