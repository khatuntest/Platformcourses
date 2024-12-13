package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Model.Assignment;
import com.project.Learning.Management.System.Model.Courses;
import com.project.Learning.Management.System.Model.Quiz;
import com.project.Learning.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")//اني اقوله اي حاجه طالعه من ال class ده لازم يكون مسبوقه بده ثم اللي فوق ال method
public class StudentController {
    @Autowired
    private final StudentService studentService = new StudentService();

    // Enroll a student in a course
    @GetMapping("/{id}/enroll")
    public String enrollInCourse(@PathVariable String id, @RequestBody Courses course) {
        boolean enrolled = studentService.enrollStudentInCourse(id, course);
        if (enrolled) {
            return "Student with ID " + id + " enrolled in course: " + course.getTitle();
        }
        return "Student with ID " + id + " is already enrolled in course: " + course.getTitle();
    }

    // Submit an assignment
    @GetMapping("/{id}/submitAssignment")
    public String submitAssignment( String id, Assignment assignment) {
        boolean submitted = studentService.submitStudentAssignment(id, assignment);
        if (submitted) {
            return "Assignment " + assignment.getTitle() + " submitted by student with ID " + id;
        }
        return "Assignment submission failed for student with ID " + id;
    }

    // Take a quiz
    @GetMapping("/{id}/takeQuiz")
    public String takeQuiz(@PathVariable String id, @RequestBody Quiz quiz) {
        boolean taken = studentService.takeStudentQuiz(id, quiz);
        if (taken) {
            return "Quiz " + quiz.getTitle() + " taken by student with ID " + id;
        }
        return "Quiz submission failed for student with ID " + id;
    }
}
