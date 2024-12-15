package com.learning.courses.controller;
import com.learning.courses.model.course;
import com.learning.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Endpoint to add a new course

    public course addCourse(@RequestBody course course) {
        return courseService.addCourse(course);
    }

    // Endpoint to get all courses

    public List<course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Endpoint to enroll a student in a course

    public void enrollStudent(@PathVariable Long courseId, @RequestParam String studentName) {
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

