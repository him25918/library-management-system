package com.himanshu.Library_management.controller;

import com.himanshu.Library_management.dto.IssueBookResponseDTO;
import com.himanshu.Library_management.dto.IssuedBookResponseDTO;
import com.himanshu.Library_management.dto.ReturnBookResponseDTO;
import com.himanshu.Library_management.entity.IssueBook;
import com.himanshu.Library_management.service.IssueService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lib")
public class IssueController {
    @Autowired
    private IssueService libraryService;

    @PostMapping("/issue-book")
    public ResponseEntity<IssueBookResponseDTO> issueBook(@RequestParam String bookId, @RequestParam String studentId) {
        IssueBookResponseDTO result = libraryService.issueBook(bookId, studentId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/return-book")
    public ResponseEntity<ReturnBookResponseDTO> returnBook(@RequestParam String bookId) {
        ReturnBookResponseDTO response = libraryService.returnBook(bookId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all-issues")
    public ResponseEntity<List<IssuedBookResponseDTO>> getAllIssue(){
        List<IssuedBookResponseDTO> issues = libraryService.getAllIssues();
        return ResponseEntity.ok(issues);
    }

    @GetMapping("/my-issues")
    public ResponseEntity<List<IssuedBookResponseDTO>> getAllIssuesById(@RequestParam String studentId){
        List<IssuedBookResponseDTO> issues = libraryService.getAllIssuesById(studentId);
        return ResponseEntity.ok(issues);
    }
}
