package com.himanshu.Library_management.dto;

import java.time.LocalDate;

public class ReturnBookResponseDTO {
        private String bookTitle;
        private String studentName;
        private LocalDate issueDate;
        private LocalDate returnDate;
        private Long fine;


        public ReturnBookResponseDTO(String bookTitle, String studentName, LocalDate issueDate, LocalDate returnDate, Long fine) {
            this.bookTitle = bookTitle;
            this.studentName = studentName;
            this.issueDate = issueDate;
            this.returnDate = returnDate;
            this.fine = fine;
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

    public Long getFine() {
        return fine;
    }

    public void setFine(Long fine) {
        this.fine = fine;
    }
}
