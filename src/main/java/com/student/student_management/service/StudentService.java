package com.student.student_management.service;

import org.springframework.stereotype.Service;

import com.student.student_management.dto.StudentDTO;
import com.student.student_management.model.StudentModel;
import com.student.student_management.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository obj;

    public StudentService(StudentRepository obj) {
        this.obj = obj;
    }

    public String add(StudentDTO dto) {
        StudentModel model = new StudentModel();
        String name = dto.getName(); // when i use dto , data is in the form of json
        String email = dto.getEmail();
        model.setName(name); // data save in object form
        model.setEmail(email);
        obj.save(model);
        return "item added succesfully";
    }

    public String deleteItem(Integer id){
        obj.deleteById(id);
        return "item deleted succesfully";
    }
}
