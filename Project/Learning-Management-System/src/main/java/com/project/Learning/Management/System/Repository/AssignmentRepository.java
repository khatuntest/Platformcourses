package com.project.Learning.Management.System.Repository;

import com.project.Learning.Management.System.Entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
