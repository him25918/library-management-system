package com.himanshu.Library_management.repo;

import com.himanshu.Library_management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, String> {

    List<Book> findByBookIdContainingIgnoreCase(String bookId);

    List<Book> findByBookNameContainingIgnoreCase(String bookName);

    List<Book> findByAuthorNameContainingIgnoreCase(String authorName);

    List<Book> findByPublicationContainingIgnoreCase(String publication);
}
