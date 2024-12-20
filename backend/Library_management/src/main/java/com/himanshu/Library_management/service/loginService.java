package com.himanshu.Library_management.service;

import com.himanshu.Library_management.entity.Users;
import com.himanshu.Library_management.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class loginService {

    @Autowired
    LoginRepo loginRepo;

    public String registerUser(Users user) {
        if (loginRepo.findByUserId(user.getUserId()).isPresent()) {
            return "Please enter your unique id";
        }

        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);

        loginRepo.save(user);
        return "User registered successfully!";
    }

    public boolean authenticateUser(String username, String password) {
        Optional<Users> user = loginRepo.findByUserId(username);

        if (user.isPresent()) {
            return checkPassword(password, user.get().getPassword());
        }

        return false;
    }

    private String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    private boolean checkPassword(String rawPassword, String encryptedPassword) {
        String decryptedPassword = new String(Base64.getDecoder().decode(encryptedPassword));
        return rawPassword.equals(decryptedPassword);
    }

}
