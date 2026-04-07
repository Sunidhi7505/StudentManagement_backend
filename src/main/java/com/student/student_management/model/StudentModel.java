package com.student.student_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studentInfo")
public class StudentModel {
    private String name;
    @Id // primary key ki liye hmshea @Id hi likhte hai , model class mein ek primary
        // key hmseah declare krni hai

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String course;
    private String email;
    private int age;
    private int marks;

}
