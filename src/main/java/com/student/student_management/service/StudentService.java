package com.student.student_management.service;

import java.util.List;

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
        String course = dto.getCourse();
        int marks = dto.getMarks();

        model.setName(name); // data save in object form
        model.setEmail(email);
        model.setCourse(course);
        model.setMarks(marks);

        obj.save(model);
        return "item added succesfully";
    }

    public String deleteItem(Integer id) {
        obj.deleteById(id);
        return "item deleted succesfully";
    }

    //now get all strudents
    public List<StudentModel> getAllStudents() {
        return obj.findAll();
    }

    public StudentModel getStudnetById(Integer id) {
        return obj.findById(id).orElse(null);
    }

    public String updateStudent(Integer id, StudentDTO dto) {

        // Step 1: check student exists or not
        StudentModel existing = obj.findById(id).orElse(null);

        if (existing == null) {
            return "student not found";
        }

        //update

        String name = dto.getName(); // when we use dto , data is in the form of json
        String email = dto.getEmail();
        String course = dto.getCourse();
        int marks = dto.getMarks();

        existing.setName(name); //now data is save in the form of object
        existing.setEmail(email);
        existing.setCourse(course);
        existing.setMarks(marks);

        // Step 3: save updated data
        obj.save(existing);
        return "Student updated successfully";
    }
    
    public List<StudentModel> searchByParam(String name , int marks) {
        return obj.findByNameAndMarks(name, marks);
    }

    public List<StudentModel> filterByMarks(int marks) {
        return obj.findByMarksGreaterThan(marks);
    }
}
