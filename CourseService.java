package com.learning.courses.service;
import com.learning.courses.model.course;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.learning.courses.model.Lesson;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Service
public class CourseService {
    private List<course> courses = new ArrayList<>();  // Temporary in-memory list

    // Method to add a course
    public course addCourse(course course) {
        course.setId(courses.size() + 1L);  // Auto-increment ID
        courses.add(course);
        return course;
    }

    // Method to get all courses
    public List<course> getAllCourses() {
        return courses;
    }

    // Method to enroll a student in a course
    public void enrollStudent(Long courseId, String studentName) {
        course course = findCourseById(courseId);
        if (course != null) {
            course.addStudent(studentName);
        }
    }

    // Method to get enrolled students for a course
    public List<String> getEnrolledStudents(Long courseId) {
        course course = findCourseById(courseId);
        return course != null ? course.getEnrolledStudents() : new ArrayList<>();
    }
    // Helper method to find a lesson by ID within a course
    private Lesson getLessonById(course course, Long lessonId) {
        return course.getLessons().stream()
                .filter(l -> l.getId().equals(lessonId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }


    public String uploadMedia(Long courseId, MultipartFile file) throws IOException {
        String filePath = "/uploads/" + file.getOriginalFilename();  // Simulated file path
        course course = findCourseById(courseId);

        if (course != null) {
            course.addMediaFile(filePath);  // Add media file to course
        }
        return filePath;  // Return the file path (or URL)
    }


    public void generateOTPForLesson(Long courseId, Long lessonId) {
        course course = findCourseById(courseId);
        if (course != null) {
            Lesson lesson = getLessonById(course, lessonId);
            lesson.generateOTP();
        }
    }


    public boolean verifyOTP(Long courseId, Long lessonId, String otpEntered) {
        course course = findCourseById(courseId);
        if (course != null) {
            Lesson lesson = getLessonById(course, lessonId);
            return lesson.getOtp().equals(otpEntered);
        }
        return false;
    }

    // Helper method to find a course by ID
    private course findCourseById(Long courseId) {
        return courses.stream()
                .filter(course -> course.getId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
}


