package com.himanshu.Library_management.service;

import com.himanshu.Library_management.entity.Student;
import com.himanshu.Library_management.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
}
