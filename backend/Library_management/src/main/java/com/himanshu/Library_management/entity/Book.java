package com.himanshu.Library_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private String bookId;
    private String isbn;
    private String bookName;
    private String authorName;
    private String publication;
    private float price;
    private String isAvailable;
    private String location;

    public String getLocation() {
        return location;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Book(){

    }

    public Book(String bookId,String isbn, String bookName, String authorName, String publication, float price, String isAvailable, String location) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publication = publication;
        this.price = price;
        this.isAvailable = isAvailable;
        this.location = location;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(String available) {
        this.isAvailable = available;
    }
}
