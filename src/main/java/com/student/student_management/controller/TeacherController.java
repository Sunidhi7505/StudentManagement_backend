package com.student.student_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_management.dto.TeacherDTO;
import com.student.student_management.model.TeacherModel;
import com.student.student_management.service.TeacherService;


@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    TeacherService obj;

    public TeacherController(TeacherService obj) {
        this.obj = obj;
    }

    @PostMapping("/add")
    public String addInfo(@RequestBody TeacherDTO dto) {
        return obj.add(dto);
    }

    // name and course k bases pe search krna hai

    @GetMapping("/search")
    public List<TeacherModel> searchByParam(@RequestParam String name, @RequestParam String course) {
        return obj.searchByNameAndCourse(name, course);
    }
    
}



