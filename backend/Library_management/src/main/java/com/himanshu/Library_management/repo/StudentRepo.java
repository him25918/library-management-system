package com.himanshu.Library_management.repo;

import com.himanshu.Library_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,String> {

}
