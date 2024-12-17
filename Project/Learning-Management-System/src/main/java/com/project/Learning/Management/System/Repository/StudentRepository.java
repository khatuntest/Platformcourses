package com.project.Learning.Management.System.Repository;

import com.project.Learning.Management.System.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);  // Example custom query method
}
