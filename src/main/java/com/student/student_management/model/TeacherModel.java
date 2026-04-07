package com.student.student_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Teacher_info")
public class TeacherModel {
    private String name;
    private String contact_no;
    private String course;
    private String email;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

}
