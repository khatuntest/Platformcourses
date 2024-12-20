package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Entity.Courses;
import com.project.Learning.Management.System.Entity.User;
import com.project.Learning.Management.System.Repository.AdminRepository;
import com.project.Learning.Management.System.Repository.CourseRepository;
import com.project.Learning.Management.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(UserRepository userRepository, CourseRepository courseRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.adminRepository = adminRepository;
    }

    // Create new user
    public boolean createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return false; // User with the same email already exists
        }
        userRepository.save(user);
        return true;
    }

    // Create new course
    public boolean createCourse(Courses course) {
        if (courseRepository.existsByTitle(course.getTitle())) {
            return false; // Course with the same title already exists
        }
        courseRepository.save(course);
        return true;
    }

    // Get a list of students enrolled in a course
    public List<String> getEnrolledStudents(String courseId) {
        Courses course = courseRepository.findById(Long.valueOf(courseId)).orElse(null);
        if (course != null) {
            // Assuming getEnrolledStudents returns a list of User objects
            return course.getEnrolledStudents().stream()
                    .map(User::getName)  // Map each User to their name
                    .collect(Collectors.toList());
        }
        return List.of(); // Return empty list if course not found or no students enrolled
    }


    // Generate a performance report
    public String generatePerformanceReport() {
        // Placeholder logic for generating a report
        return "Performance report generated (placeholder).";
    }

    // Method to view all users (admin, instructor, students)
    public String viewAllUsers() {
        List<User> allUsers = userRepository.findAll();
        StringBuilder userList = new StringBuilder("Users in the system:\n");

        allUsers.forEach(user -> userList.append(user.getName()).append(" (").append(user.getEmail()).append(") - Role: ").append(user.getRole()).append("\n"));

        return userList.toString();
    }
}
