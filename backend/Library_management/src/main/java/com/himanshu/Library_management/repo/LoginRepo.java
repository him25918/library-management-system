package com.himanshu.Library_management.repo;

import com.himanshu.Library_management.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<Users, String> {

    Optional<Users> findByUserId(String userId);
}
