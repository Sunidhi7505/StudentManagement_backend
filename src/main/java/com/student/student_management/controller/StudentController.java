package com.student.student_management.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_management.dto.StudentDTO;
import com.student.student_management.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService obj;
    //depdency injection
    public StudentController(StudentService obj) {
        this.obj = obj;
    }

    @PostMapping("/add")
    public String createStudent(@RequestBody StudentDTO dto ){
        return obj.add(dto);  //service function
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return obj.deleteItem(id);
    }

}
