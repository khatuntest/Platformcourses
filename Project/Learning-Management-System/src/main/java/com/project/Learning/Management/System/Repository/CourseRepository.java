package com.project.Learning.Management.System.Repository;

import com.project.Learning.Management.System.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses, Long> {
    boolean existsByTitle(String title);
}