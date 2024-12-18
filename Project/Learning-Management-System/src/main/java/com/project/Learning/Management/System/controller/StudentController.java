package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Model.*;
import com.project.Learning.Management.System.service.NotificationService;
import com.project.Learning.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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


    @RequestMapping("/api/notifications")
    class NotificationController {
        private final NotificationService notificationService = new NotificationService();

        // Add a new notification
        @PostMapping
        public String addNotification(@RequestBody Notification notification) {
            notification.setId(UUID.randomUUID().toString()); // Generate unique ID
            notificationService.addNotification(notification);
            return "Notification added successfully!";
        }

        // Get unread notifications for a user
        @GetMapping("/{userId}/unread")
        public List<Notification> getUnreadNotifications(@PathVariable String userId) {
            return notificationService.getUnreadNotifications(userId);
        }

        // Get all notifications for a user
        @GetMapping("/{userId}/all")
        public List<Notification> getAllNotifications(@PathVariable String userId) {
            return notificationService.getAllNotifications(userId);
        }

        // Mark a notification as read
        @PutMapping("/{notificationId}/read")
        public String markAsRead(@PathVariable String notificationId) {
            notificationService.markAsRead(notificationId);
            return "Notification marked as read!";
        }
        @GetMapping("/students/{studentId}/notifications")
        public List<Notification> getStudentNotifications(@PathVariable String studentId) {
            return notificationService.getAllNotifications(studentId);
        }
        @GetMapping("/instructors/{instructorId}/notifications")
        public List<Notification> getInstructorNotifications(@PathVariable String instructorId) {
            return notificationService.getAllNotifications(instructorId);
        }
    }






}
