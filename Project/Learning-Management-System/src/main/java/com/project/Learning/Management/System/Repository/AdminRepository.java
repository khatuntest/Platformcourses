package com.project.Learning.Management.System.Repository;

import com.project.Learning.Management.System.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}