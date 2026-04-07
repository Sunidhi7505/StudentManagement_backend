package com.student.student_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.student_management.model.TeacherModel;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, Integer> {
    
    List<TeacherModel> findByNameAndCourse(String name, String course);
}
