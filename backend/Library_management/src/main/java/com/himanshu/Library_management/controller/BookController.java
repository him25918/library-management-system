package com.himanshu.Library_management.controller;

import com.himanshu.Library_management.entity.Book;
import com.himanshu.Library_management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-api")
@CrossOrigin(origins = "http://localhost:8080")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    @GetMapping("/all")
    public List<Book> getAll(){
        return service.getAllBook();
    }

    @GetMapping("/search/bookId")
    public List<Book> searchByBookId(@RequestParam String bookId) {
        return service.searchByBookId(bookId);
    }

    // Search by bookName
    @GetMapping("/search/bookName")
    public List<Book> searchByBookName(@RequestParam String bookName) {
        return service.searchByBookName(bookName);
    }

    // Search by authorName
    @GetMapping("/search/authorName")
    public List<Book> searchByAuthorName(@RequestParam String authorName) {
        return service.searchByAuthorName(authorName);
    }

    @GetMapping("/search/publication")
    public List<Book> searchByPublication(@RequestParam String publication) {
        return service.searchByPublication(publication);
    }

    @DeleteMapping("/delete")
    public Book deleteById(@RequestBody String bookId){
        return service.remove(bookId);
    }
}
