package com.project.Learning.Management.System.controller;


import com.project.Learning.Management.System.service.Authentication;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


// Controller Class for APIs
@RestController
@RequestMapping("/api")
public class StudentController {

    // Temporary list to store users
    private final List<User> userList = new ArrayList<>();

    // POST /register
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Check if user already exists
        for (User existingUser : userList) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
            }
        }
        // Add new user to the list
        userList.add(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // POST /login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Authenticate user using the Authentication class
        if (Authentication.authenticate(username, password, userList)) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    // POST /logout
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        // Dummy logic for logout (could be session-based in real applications)
        return ResponseEntity.ok("Logout successful");
    }

    // GET /user/profile/{username}
    @GetMapping("/user/profile/{username}")
    public ResponseEntity<User> getProfile(@PathVariable String username) {
        // Fetch user profile by username
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // PUT /user/profile
    @PutMapping("/user/profile")
    public ResponseEntity<String> updateProfile(@RequestBody User updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(updatedUser.getUsername())) {
                userList.set(i, updatedUser); // Update user profile
                return ResponseEntity.ok("Profile updated successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    // ----------------- Admin-specific APIs -----------------

    // POST /admin/createUser
    @PostMapping("/admin/createUser")
    public ResponseEntity<String> createUser(@RequestBody User newUser) {
        // Add user logic (similar to /register)
        userList.add(newUser);
        return ResponseEntity.ok("User created successfully");
    }

    // POST /admin/createCourse
    @PostMapping("/admin/createCourse")
    public ResponseEntity<String> createCourse(@RequestBody Map<String, String> courseDetails) {
        // Placeholder for course creation logic
        return ResponseEntity.ok("Course created successfully");
    }

    // DELETE /admin/removeCourse/{courseId}
    @DeleteMapping("/admin/removeCourse/{courseId}")
    public ResponseEntity<String> removeCourse(@PathVariable Long courseId) {
        // Placeholder for course removal logic
        return ResponseEntity.ok("Course removed successfully");
    }

    // PUT /admin/updateSystemSettings
    @PutMapping("/admin/updateSystemSettings")
    public ResponseEntity<String> updateSystemSettings(@RequestBody Map<String, String> settings) {
        // Placeholder for system settings update logic
        return ResponseEntity.ok("System settings updated successfully");
    }

    // ----------------- Instructor-specific APIs -----------------

    // POST /instructor/createCourseContent
    @PostMapping("/instructor/createCourseContent")
    public ResponseEntity<String> createCourseContent(@RequestBody Map<String, String> contentDetails) {
        // Placeholder for adding course content
        return ResponseEntity.ok("Course content added successfully");
    }

    // POST /instructor/addAssignment
    @PostMapping("/instructor/addAssignment")
    public ResponseEntity<String> addAssignment(@RequestBody Map<String, String> assignmentDetails) {
        // Placeholder for adding assignments
        return ResponseEntity.ok("Assignment added successfully");
    }

    // DELETE /instructor/removeStudent/{courseId}/{studentId}
    @DeleteMapping("/instructor/removeStudent/{courseId}/{studentId}")
    public ResponseEntity<String> removeStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        // Placeholder for removing students from a course
        return ResponseEntity.ok("Student removed from course successfully");
    }

    // POST /instructor/gradeStudent
    @PostMapping("/instructor/gradeStudent")
    public ResponseEntity<String> gradeStudent(@RequestBody Map<String, String> gradeDetails) {
        // Placeholder for grading logic
        return ResponseEntity.ok("Student graded successfully");
    }

    // ----------------- Student-specific APIs -----------------

    // POST /student/enrollCourse/{courseId}
    @PostMapping("/student/enrollCourse/{courseId}")
    public ResponseEntity<String> enrollCourse(@PathVariable Long courseId) {
        // Placeholder for course enrollment logic
        return ResponseEntity.ok("Enrolled in course successfully");
    }

    // GET /student/viewCourseContent/{courseId}
    @GetMapping("/student/viewCourseContent/{courseId}")
    public ResponseEntity<String> viewCourseContent(@PathVariable Long courseId) {
        // Placeholder for viewing course content
        return ResponseEntity.ok("Course content displayed successfully");
    }

    // POST /student/submitAssignment
    @PostMapping("/student/submitAssignment")
    public ResponseEntity<String> submitAssignment(@RequestBody Map<String, String> submissionDetails) {
        // Placeholder for assignment submission
        return ResponseEntity.ok("Assignment submitted successfully");
    }

    // GET /student/viewGrades
    @GetMapping("/student/viewGrades")
    public ResponseEntity<String> viewGrades() {
        // Placeholder for viewing grades
        return ResponseEntity.ok("Grades displayed successfully");
    }
}
