package com.himanshu.Library_management.service;

import com.himanshu.Library_management.dto.IssueBookResponseDTO;
import com.himanshu.Library_management.dto.IssuedBookResponseDTO;
import com.himanshu.Library_management.dto.ReturnBookResponseDTO;
import com.himanshu.Library_management.entity.Book;
import com.himanshu.Library_management.entity.IssueBook;
import com.himanshu.Library_management.entity.Student;
import com.himanshu.Library_management.repo.BookRepo;
import com.himanshu.Library_management.repo.IssueRepo;
import com.himanshu.Library_management.repo.StudentRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class IssueService {
    @Autowired
    private HttpSession session;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private IssueRepo issueRepo;

    @Autowired
    private StudentRepo studentRepo;

    public IssueBookResponseDTO issueBook(String bookId, String studentId){
        Optional<Book> book = bookRepo.findById(bookId);

        Optional<Student> student = studentRepo.findById(studentId);
        if(book.isPresent() && student.isPresent()){
            Book book1 = book.get();
            if("Yes".equals(book1.getIsAvailable())){
                Student std = student.get();

                IssueBook issue = new IssueBook();
                issue.setBook(book1);
                issue.setStudent(std);
                LocalDate issueDate  = LocalDate.now();
                issue.setIssueDate(LocalDate.now());
                LocalDate returnDate = issueDate.plusDays(14);
                issue.setReturnDate(returnDate);
                issueRepo.save(issue);
                book1.setAvailable("Issued");
                bookRepo.save(book1);
                return new IssueBookResponseDTO(book1.getBookName(), book1.getAuthorName(),std.getStudentName(), issue.getIssueDate(), returnDate);
            }else{
                throw new RuntimeException("Book is currently unavailable.");
            }
        }else{
            throw new RuntimeException("Book or Student not found.");
        }
    }

    public ReturnBookResponseDTO returnBook(String bookId) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();

            Optional<IssueBook> issuedBookOptional = issueRepo.findByBook_BookId(bookId);

            if (issuedBookOptional.isPresent()) {
                IssueBook issuedBook = issuedBookOptional.get();
                LocalDate currentDate = LocalDate.now();
                LocalDate returnDate = issuedBook.getReturnDate();

                long fine = 0;
                if (currentDate.isAfter(returnDate)) {
                    long daysOverdue = ChronoUnit.DAYS.between(returnDate, currentDate);
                    fine = daysOverdue;
                }

                book.setAvailable("Yes");
                bookRepo.save(book);
                issueRepo.delete(issuedBook);
                return new ReturnBookResponseDTO(book.getBookName(),
                        issuedBook.getStudent().getStudentName(),
                        issuedBook.getIssueDate(),
                        returnDate,
                        fine);
            } else {
                throw new RuntimeException("This book is not currently issued.");
            }
        } else {
            throw new RuntimeException("Book not found.");
        }
    }

    public List<IssuedBookResponseDTO> getAllIssues(){
        List<IssueBook> Issues = issueRepo.findAll();
        List<IssuedBookResponseDTO> issued = new java.util.ArrayList<>(List.of());
        for(IssueBook issue : Issues){
            Book book = issue.getBook();
            Student std = issue.getStudent();
            IssuedBookResponseDTO temp = new IssuedBookResponseDTO(book.getBookId(),book.getBookName(),std.getStudentId(),std.getStudentName(),issue.getIssueDate(),issue.getReturnDate());
            issued.add(temp);
        }
        return issued;
    }

    public List<IssuedBookResponseDTO> getAllIssuesById(String studentId){
        List<IssueBook> Issues = issueRepo.findByStudent_StudentId(studentId);
        List<IssuedBookResponseDTO> issued = new java.util.ArrayList<>(List.of());
        for(IssueBook issue : Issues){
            Book book = issue.getBook();
            Student std = issue.getStudent();
            IssuedBookResponseDTO temp = new IssuedBookResponseDTO(book.getBookId(),book.getBookName(),std.getStudentId(),std.getStudentName(),issue.getIssueDate(),issue.getReturnDate());
            issued.add(temp);
        }
        return issued;
    }
}
