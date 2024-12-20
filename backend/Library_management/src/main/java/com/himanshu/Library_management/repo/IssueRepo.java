package com.himanshu.Library_management.repo;

import com.himanshu.Library_management.entity.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IssueRepo extends JpaRepository<IssueBook, Long>{
    Optional<IssueBook> findByBook_BookId(String bookId);

    List<IssueBook> findByStudent_StudentId(String studentId);
}
