package com.himanshu.Library_management.dto;

import java.time.LocalDate;

public class IssuedBookResponseDTO {
    private String bookId;
    private String bookName;
    private String studentId;
    private String studentName;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public IssuedBookResponseDTO(String bookId, String bookName, String studentId, String studentName, LocalDate issueDate, LocalDate returnDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.studentName = studentName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
}
