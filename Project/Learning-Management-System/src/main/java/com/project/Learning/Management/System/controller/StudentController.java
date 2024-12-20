package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Entity.Assignment;
import com.project.Learning.Management.System.Entity.Courses;
import com.project.Learning.Management.System.Entity.Quiz;
import com.project.Learning.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    // Enroll a student in a course
    @PostMapping("/{id}/enroll")
    public ResponseEntity<String> enrollInCourse(@PathVariable int id, @RequestBody Courses course) {
        try {
            boolean enrolled = studentService.enrollStudentInCourse(id, course);
            if (enrolled) {
                return ResponseEntity.ok("Student successfully enrolled in the course.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enrollment failed. Course or student may not exist.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // Submit an assignment
    @PostMapping("/{id}/submitAssignment")
    public String submitAssignment(@PathVariable int id, @RequestBody Assignment assignment) {
        boolean submitted = studentService.submitStudentAssignment(id, assignment);
        if (submitted) {
            return "Assignment " + assignment.getTitle() + " submitted by student with ID " + id;
        }
        return "Assignment submission failed for student with ID " + id;
    }

    // Take a quiz
    @PostMapping("/{id}/takeQuiz")
    public String takeQuiz(@PathVariable int id, @RequestBody Quiz quiz) {
        boolean taken = studentService.takeStudentQuiz(id, quiz);
        if (taken) {
            return "Quiz " + quiz.getTitle() + " taken by student with ID " + id;
        }
        return "Quiz submission failed for student with ID " + id;
    }
}
