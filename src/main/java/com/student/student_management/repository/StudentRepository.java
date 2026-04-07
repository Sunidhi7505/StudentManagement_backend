package com.student.student_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.student_management.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer>{
    List<StudentModel> findByNameAndMarks(String name, int marks); //this custom methos , phle se nhi hota h yhee function jpa k anadr

    List<StudentModel> findByMarksGreaterThan(int marks);
}
