package com.student.student_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_management.dto.StudentDTO;
import com.student.student_management.model.StudentModel;
import com.student.student_management.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService obj;

    // depdency injection
    public StudentController(StudentService obj) {
        this.obj = obj;
    }

    @PostMapping("/add")
    public String createStudent(@RequestBody StudentDTO dto) {
        return obj.add(dto); // service function
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        return obj.deleteItem(id);
    }

    @GetMapping("/fetch")
    public List<StudentModel> fetchAllStudent() {
        return obj.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentModel getStudentId(@PathVariable Integer id) {
        return obj.getStudnetById(id);
    }

    @PutMapping("/update/{id}")
    public String updateStudentInfo(@PathVariable Integer id, @RequestBody StudentDTO dto) {
        return obj.updateStudent(id, dto);
    }

    @GetMapping("/search")
    public List<StudentModel> searchByCondition(@RequestParam String name , @RequestParam int marks) {
        return obj.searchByParam(name , marks);
    }

    @GetMapping("/filter")
    public List<StudentModel> filterByMar(@RequestParam int marks) {
        return obj.filterByMarks(marks);
    }
}
