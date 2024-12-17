package com.project.Learning.Management.System.controller;

import com.project.Learning.Management.System.Model.Courses;
import com.project.Learning.Management.System.Model.Node;
import com.project.Learning.Management.System.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    // Endpoint to add a new course

    public Courses addCourse(@RequestBody Courses course) {
        return courseService.addCourse(course);
    }

    // Endpoint to get all courses

    public List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Endpoint to enroll a student in a course

    public void enrollStudent(@PathVariable Long courseId, @RequestParam Node studentName) {
        courseService.enrollStudent(courseId, studentName);
    }

    // Endpoint to get enrolled students for a course

    public List<String> getEnrolledStudents(@PathVariable Long courseId) {
        return courseService.getEnrolledStudents(courseId);
    }

    // Endpoint to upload media for a course

    public String uploadMedia(@PathVariable Long courseId, @RequestParam MultipartFile file) throws IOException {
        return courseService.uploadMedia(courseId, file);
    }

    // Endpoint to generate OTP for a lesson

    public void generateOTP(@PathVariable Long courseId, @PathVariable Long lessonId) {
        courseService.generateOTPForLesson(courseId, lessonId);
    }

    // Endpoint to verify OTP for a lesson

    public boolean verifyOTP(@PathVariable Long courseId, @PathVariable Long lessonId, @RequestParam String otp) {
        return courseService.verifyOTP(courseId, lessonId, otp);
    }
}
