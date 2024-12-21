
package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Entity.Courses;
import com.project.Learning.Management.System.Entity.User;
import com.project.Learning.Management.System.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Create new user
    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        boolean created = adminService.createUser(user);
        if (created) {
            return "User with role " + user.getRole() + " created successfully: " + user.getName();
        }
        return "Failed to create user: " + user.getName();
    }

    // Create new course
    @PostMapping("/createCourse")
    public String createCourse(@RequestBody Courses course) {
        boolean created = adminService.createCourse(course);
        if (created) {
            return "Course created successfully: " + course.getTitle();
        }
        return "Failed to create course: " + course.getTitle();
    }

    // View all enrolled students in a course
    @GetMapping("/course/{courseId}/students")
    public Object viewEnrolledStudents(@PathVariable String courseId) {
        return adminService.getEnrolledStudents(courseId);
    }


    // Generate a performance report
    @GetMapping("/generateReport")
    public String generatePerformanceReport() {
        return adminService.generatePerformanceReport();
    }

    // View all users (students, instructors, admins)
    @GetMapping("/viewAllUsers")
    public String viewAllUsers() {
        return adminService.viewAllUsers();
    }
}
