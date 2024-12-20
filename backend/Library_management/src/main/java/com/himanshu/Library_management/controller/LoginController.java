package com.himanshu.Library_management.controller;

import com.himanshu.Library_management.entity.Users;
import com.himanshu.Library_management.service.loginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private loginService userService;

    @PostMapping("/api/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        String message = userService.registerUser(user);
        if (message.equals("User registered successfully!")) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }
    @PostMapping("/api/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> loginRequest, HttpSession session) {
        String userId = loginRequest.get("userId");
        String password = loginRequest.get("password");

        boolean isAuthenticated = userService.authenticateUser(userId, password);

        if (isAuthenticated) {
            session.setAttribute("currentUserId", userId);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid userId or password");
        }
    }

}
