package com.himanshu.Library_management.dto;

import java.time.LocalDate;

public class IssueBookResponseDTO {
    private String bookTitle;
    private String author;
    private String studentName;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public IssueBookResponseDTO(String bookTitle,String author ,String studentName, LocalDate issueDate, LocalDate returnDate) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.studentName = studentName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
