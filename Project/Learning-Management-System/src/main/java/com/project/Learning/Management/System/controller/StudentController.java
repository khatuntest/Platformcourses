package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Model.Assignment;
import com.project.Learning.Management.System.Model.Courses;
import com.project.Learning.Management.System.Model.Quiz;
import com.project.Learning.Management.System.Model.Student;
import com.project.Learning.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Enroll a student in a course
    @PostMapping("/{id}/enroll")
    public String enrollInCourse(@PathVariable int id, @RequestBody Courses course) {
        boolean enrolled = studentService.enrollStudentInCourse(id, course);
        if (enrolled) {
            return "Student with ID " + id + " enrolled in course: " + course.getTitle();
        }
        return "Student with ID " + id + " is already enrolled in course: " + course.getTitle();
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
