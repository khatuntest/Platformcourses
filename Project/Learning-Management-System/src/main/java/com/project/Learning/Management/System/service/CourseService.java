package com.project.Learning.Management.System.service;

import com.project.Learning.Management.System.Entity.Courses;
import com.project.Learning.Management.System.Entity.User;  // Ensure User class is imported
import com.project.Learning.Management.System.Entity.Lesson;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Courses> courses = new ArrayList<>();  // Temporary in-memory list

    // Method to add a course
    public Courses addCourse(Courses course) {
        course.setId(courses.size() + 1L);  // Auto-increment ID
        courses.add(course);
        return course;
    }

    // Method to get all courses
    public List<Courses> getAllCourses() {
        return courses;
    }

    // Method to enroll a student in a course
    public void enrollStudent(Long courseId, User student) {
        Courses course = findCourseById(courseId);
        if (course != null) {
            course.addStudent(student);
        }
    }

    // Method to get enrolled students for a course
    public List<String> getEnrolledStudents(Long courseId) {
        Courses course = findCourseById(courseId);
        return course != null ? course.getEnrolledStudentsNames() : new ArrayList<>();
    }

    // Helper method to find a lesson by ID within a course
    private Lesson getLessonById(Courses course, Long lessonId) {
        return course.getLessons().stream()
                .filter(l -> l.getId().equals(lessonId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    public String uploadMedia(Long courseId, MultipartFile file) throws IOException {
        String filePath = "/uploads/" + file.getOriginalFilename();  // Simulated file path
        Courses course = findCourseById(courseId);

        if (course != null) {
            course.addMediaFile(filePath);  // Add media file to course
        }
        return filePath;  // Return the file path (or URL)
    }

    public void generateOTPForLesson(Long courseId, Long lessonId) {
        Courses course = findCourseById(courseId);
        if (course != null) {
            Lesson lesson = getLessonById(course, lessonId);
            lesson.generateOTP();
        }
    }

    public boolean verifyOTP(Long courseId, Long lessonId, String otpEntered) {
        Courses course = findCourseById(courseId);
        if (course != null) {
            Lesson lesson = getLessonById(course, lessonId);
            return lesson.getOtp().equals(otpEntered);
        }
        return false;
    }

    // Helper method to find a course by ID
    private Courses findCourseById(Long courseId) {
        return courses.stream()
                .filter(course -> course.getId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
}
