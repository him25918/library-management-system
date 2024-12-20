package com.himanshu.Library_management.controller;

import com.himanshu.Library_management.entity.Student;
import com.himanshu.Library_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/std-api")
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAll(){
        return service.getAllStudent();
    }
}
