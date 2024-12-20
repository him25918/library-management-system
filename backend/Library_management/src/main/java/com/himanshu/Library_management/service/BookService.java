package com.himanshu.Library_management.service;

import com.himanshu.Library_management.entity.Book;
import com.himanshu.Library_management.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }

    public List<Book> searchByBookId(String bookId) {
        return bookRepo.findByBookIdContainingIgnoreCase(bookId);
    }

    public List<Book> searchByBookName(String bookName) {
        return bookRepo.findByBookNameContainingIgnoreCase(bookName);
    }

    public List<Book> searchByAuthorName(String authorName) {
        return bookRepo.findByAuthorNameContainingIgnoreCase(authorName);
    }

    public List<Book> searchByPublication(String publication) {
        return bookRepo.findByPublicationContainingIgnoreCase(publication);
    }

    public Book remove(String bookId){
        Optional<Book> byId = bookRepo.findById(bookId);
        Book book = null;
        if(byId.isPresent()){
            book = byId.get();
            bookRepo.delete(book);
        }
        return book;
    }
}
