package com.project.Learning.Management.System.Repository;

import com.project.Learning.Management.System.Model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    // Custom query methods if needed
}