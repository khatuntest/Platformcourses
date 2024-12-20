package com.project.Learning.Management.System.Repository;

import com.project.Learning.Management.System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}