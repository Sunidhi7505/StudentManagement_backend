package com.student.student_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.student.student_management.dto.TeacherDTO;
import com.student.student_management.model.TeacherModel;
import com.student.student_management.repository.TeacherRepository;

@Service
public class TeacherService {
    private TeacherRepository obj;
    //di
    public TeacherService(TeacherRepository obj) {
        this.obj = obj;
    }

    public String add(TeacherDTO dto) {
        TeacherModel model = new TeacherModel(); //create obj of model class

        String name = dto.getName();
        String course = dto.getCourse();
        String email = dto.getEmail();

        model.setName(name);
        model.setCourse(course);
        model.setEmail(email);

        obj.save(model);
        return "added succesfully";
    }

    public List<TeacherModel> searchByNameAndCourse(String name , String course) {
        List<TeacherModel> dummy = obj.findByNameAndCourse(name, course);
        
        if(dummy == null){
            return new ArrayList<>();
        }
        return dummy;
    }
}
